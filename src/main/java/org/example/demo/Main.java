package org.example.demo;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HBox mainWindow = new HBox();
        mainWindow.setSpacing(20);

        VBox textBox = new VBox();
        textBox.setSpacing(10);

        Label inputLabel = new Label("a1 b1 p(i-1) a2 b2");
        TextField inputField = new TextField();

        Label displayLabel = new Label("Output:");
        TextArea displayArea = new TextArea();
        displayArea.setEditable(false);

        inputField.setOnAction(event -> {
            String inputText = inputField.getText();
            Controller controller = new Controller();
            controller.stringToIntData(inputText);
        });

        textBox.getChildren().addAll(inputLabel, inputField, displayLabel, displayArea);

        File imageFile = new File("sumator/sumator.png");
        Image image = new Image(imageFile.toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(500); // Adjust width as needed
        imageView.setPreserveRatio(true);

        mainWindow.getChildren().addAll(textBox, imageView);

        Scene scene = new Scene(mainWindow, 1000, 750);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("sumator-diagnostics");
        primaryStage.show();
    }
}
