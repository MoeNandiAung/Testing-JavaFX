package com.example;


import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application; 
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Justine extends Application {

    private static final String[] ROMANTIC_MESSAGES = {
        "Dear My Love Justine,",
        " ",
        "First of all, I want to thank you for being with me for six months together. I am really blessed to have you in my life. Your smile makes my day brighter, and every moment with you is special. Your love is my greatest treasure, and knowing you're there for me when I need you means the world.",
        " ",
        "Even though we might have a few fights here and there, it doesn't change how much I love you. Now that we're in a long-distance relationship, I want you to know that we'll get through it together. I know your work is tough on your body and mind, but stay strong; I'm here for you. Despite the challenges, I am really hoping the day when we can meet together again. And we'll tackle any problems that come our way. I trust that God will soon grant our wishes. Please always remember that my love for you is beyond words, and it's endless.",
        " ",
        "Forever and always, yours",
        "Moe"
       
    };
    private Stage primaryStage ;
    private BackgroundImage background;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        


        //For the first page first scene
        VBox root = new VBox();
        // Create a label text and a button with a heart shape
        Label labelText = new Label();
        Button heartButton = createHeartButton();
        
         // Create a scale transition for the heart shape
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), heartButton);
        scaleTransition.setFromX(1.0);
        scaleTransition.setFromY(1.0);
        scaleTransition.setToX(1.5); // Scale horizontally to 1.5 times
        scaleTransition.setToY(1.5); // Scale vertically to 1.5 times
        scaleTransition.setCycleCount(ScaleTransition.INDEFINITE); // Repeat indefinitely
        scaleTransition.setAutoReverse(true); // Reverse the animation
        scaleTransition.play();
        labelText.setText("Happy Half-Anniversary to Us!");
        labelText.setFont(new Font("Arial",35));
        labelText.setTextFill(Color.rgb(244,13,48));
        labelText.setWrapText(true);
        

        // adding a button and label to first scene
        root.setAlignment(Pos.CENTER); // Center the VBox
        root.setSpacing(20); // Set spacing between children
        root.getChildren().add(labelText);
        root.getChildren().add(heartButton);
        
       
        

    // Load the background image
    Image backgroundImage = new Image(getClass().getResourceAsStream("/com/example/images/pastel.jpg"));
    background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
    root.setBackground(new Background(background));
       
       
        Scene firstScene = new Scene(root, 500, 500);
        primaryStage.setTitle("JUSTINE & MOE");
        primaryStage.setScene(firstScene);
       
        primaryStage.show();
    }
    


    // Second page
    private void showSecondPage(){
        Label msg = new Label("Oops! You got a message.");
        msg.setFont(new Font("Arial",35));
        msg.setTextFill(Color.rgb(244,13,48));
        Button envelopeButton = createEnvelopeButton();
        StackPane buttonWrapper = new StackPane(envelopeButton);
        buttonWrapper.setStyle("-fx-background-color: transparent;");

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2), buttonWrapper);
        rotateTransition.setByAngle(45); // Rotate 360 degrees
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE); // Repeat indefinitely
        rotateTransition.play();



        envelopeButton.setOnAction(e -> showThirdPage());
        VBox page2 = new VBox();
        page2.getChildren().add(msg);
        page2.getChildren().add(buttonWrapper);
        page2.setBackground(new Background(background));
        page2.setPadding(new Insets(20));
        page2.setAlignment(Pos.CENTER);
        page2.setSpacing(25);
        Scene secondScene = new Scene(page2, 500, 500);
        primaryStage.setScene(secondScene);
        
    }
    // Third page
    private void showThirdPage(){
        Label msg = new Label();
        msg.setText("Here's my love letter for you ^_^ ");
        msg.setFont(new Font("Arial",25));
        msg.setTextFill(Color.rgb(218, 112, 214));

        TextArea loveLetter = new TextArea();
        loveLetter.setWrapText(true);
        loveLetter.setMaxHeight(1000);
        loveLetter.setMaxWidth(500);
        loveLetter.setPrefRowCount(20);
        loveLetter.setStyle("-fx-background-color: #AA336A; -fx-text-fill: #DA70D6; -fx-font-size: 14;");
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        loveLetter.setEffect(dropShadow);
        for(String i : ROMANTIC_MESSAGES)
        {
            loveLetter.appendText(i + "\n");
        }
        loveLetter.setEditable(false); // Set the TextArea to be read-only
        VBox page3 = new VBox();
        page3.getChildren().add(msg);
        page3.getChildren().add(loveLetter);
        page3.setBackground(new Background(background));
        page3.setAlignment(Pos.TOP_CENTER);
        page3.setSpacing(20);
        Scene thirdScene = new Scene(page3, 500, 500);
        primaryStage.setScene(thirdScene);


    }

    

    private Button createHeartButton() {
        Button button = new Button();

        // Set the graphic to the heart shape
        
        button.setGraphic(createHeartShape());
        button.setStyle("-fx-background-color: transparent;");
        button.setOnAction(e -> showSecondPage());  
          

        // Set the preferred size of the button
        button.setPrefSize(100, 100);

        return button;
    }

    private SVGPath createHeartShape() {
        SVGPath heart = new SVGPath();
        heart.setContent("M23.6,0c-3.4,0-6.3,2.7-7.6,5.6C14.7,2.7,11.8,0,8.4,0C3.8,0,0,3.8,0,8.4c0,9.4,9.5,11.9,16,21.2c6.1-9.3,16-12.1,16-21.2C32,3.8,28.2,0,23.6,0z");
        heart.setFill(Color.RED);
        heart.setStroke(Color.RED);

        // Set the size of the heart shape
        heart.setScaleX(2.0);
        heart.setScaleY(2.0);

        return heart;
    }


    private Button createEnvelopeButton() {
        Button button = new Button();

        // Set the graphic to the envelope shape
        button.setGraphic(createEnvelopeShape());
        button.setStyle("-fx-background-color: transparent;");

        // Set the preferred size of the button
        button.setPrefSize(100, 100);

        return button;
    }

    private SVGPath createEnvelopeShape() {
        SVGPath envelope = new SVGPath();
        envelope.setContent("M 350 200 L 200 200 L 200 300 L 350 300 L 350 200 L 300 250 L 250 250 L 200 200 ");
        envelope.setFill(Color.rgb(173,216,230));
        envelope.setStroke(Color.BLUE);

        // Set the size of the envelope shape
        envelope.setScaleX(1.0);
        envelope.setScaleY(1.0);

        return envelope;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
