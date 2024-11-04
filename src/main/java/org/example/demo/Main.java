package org.example.demo;

import java.io.File;
import java.util.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    private static final String BUTTON_STYLE =
            "-fx-background-color: #2e8bff; -fx-text-fill: white; -fx-border-radius: 5;";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Set<String> set = new HashSet<>();
        HBox mainWindow = new HBox();
        mainWindow.setSpacing(20);

        VBox textBox = new VBox();
        textBox.setSpacing(10);

        Label inputLabel = new Label("a1 b1 p(i-1) a2 b2");
        TextField inputField = new TextField();

        Label displayLabel = new Label("Binary inputs:");
        TextArea displayArea = new TextArea();
        displayArea.setEditable(false);

        Label secondaryDisplayLabel = new Label("Covered points:");
        TextArea secondaryDisplayArea = new TextArea();
        secondaryDisplayArea.setEditable(false);

        Button clearButton = new Button("Clear");
        clearButton.setStyle(BUTTON_STYLE);
        clearButton.setPrefWidth(150);
        clearButton.setOnAction(event -> {
            inputField.clear();
            displayArea.clear();
            secondaryDisplayArea.clear();
            set.clear();
        });

        inputField.setOnAction(event -> {

            String inputText = inputField.getText();
            Controller controller = new Controller();
            if (controller.stringToIntData(inputText, set)) {
                displayArea.appendText(inputText + "  --  " + set.size() + "/" + "78" + "\n");
                List<String> sortedList = new ArrayList<>(set);
                sortedList.sort(Comparator.comparingInt(s -> {
                    int index = s.indexOf('(');
                    if (index != -1) {
                        String numStr = s.substring(0, index);
                        return Integer.parseInt(numStr.trim());
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }));
                secondaryDisplayArea.clear();
                for (String str : sortedList) {
                    secondaryDisplayArea.appendText(str + "\n");
                }
                inputField.clear();
            }
        });

        textBox.getChildren().addAll(inputLabel, inputField, displayLabel, displayArea, secondaryDisplayLabel, secondaryDisplayArea, clearButton);

        File imageFile = new File("sumator/sumator.png");
        Image image = new Image(imageFile.toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);

        mainWindow.getChildren().addAll(textBox, imageView);

        Scene scene = new Scene(mainWindow, 1000, 750);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("sumator-diagnostics");
        primaryStage.show();
    }
}
