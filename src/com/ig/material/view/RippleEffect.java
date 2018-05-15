package com.ig.material.view;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.time.Duration;

public class RippleEffect {

    private Circle circle;
    private Rectangle circleClip;
    private Button parent;
    private javafx.util.Duration duration;
    private ScaleTransition scaleTransition;
    private FadeTransition fadeTransition;
    private ParallelTransition parallelTransition;

    public RippleEffect(Button parent){
        this.parent = parent;

        circle = new Circle(20);
        circle.setVisible(false);
        circle.setFill(new Color(0.5, 0.5, 0.5, 0.78));

        circleClip = new Rectangle();

        duration = javafx.util.Duration.millis(300);

        scaleTransition = new ScaleTransition(duration, circle);
        fadeTransition = new FadeTransition(duration, circle);

        parallelTransition = new ParallelTransition(scaleTransition, fadeTransition);

        configAnnimation();

        circle.setClip(circleClip);
    }


    private void configAnnimation(){
        scaleTransition.setFromX(0);
        scaleTransition.setFromY(0);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);

        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);

        scaleTransition.setInterpolator(Interpolator.EASE_OUT);
        fadeTransition.setInterpolator(Interpolator.EASE_OUT);

        parallelTransition.setOnFinished(e -> circle.setVisible(false));

    }

    public void configEffect(MouseEvent event){

        circle.setRadius(Math.max(parent.getWidth() / 3.0, parent.getHeight() / 3.0));

        circle.setCenterX(event.getX());
        circle.setCenterY(event.getY());

        circleClip.setWidth(parent.getWidth());
        circleClip.setHeight(parent.getHeight());




    }

    public void playAnimation(){
        circle.setVisible(true);
        parallelTransition.playFromStart();
    }


    public static void installEffect(Button button){
        ButtonSkin buttonSkin = createSkin(button);
        button.setSkin(buttonSkin);
    }



    private static ButtonSkin createSkin(Button button){
        ButtonSkin buttonSkin = new ButtonSkin(button);
        RippleEffect rippleEffect = new RippleEffect(button);
        buttonSkin.getChildren().add(0, rippleEffect.circle);

        button.addEventFilter(MouseEvent.MOUSE_CLICKED, e ->{
            rippleEffect.configEffect(e);
            rippleEffect.playAnimation();
        });
        return buttonSkin;
    }
}
