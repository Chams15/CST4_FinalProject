package com.tps.cs4_finalproject;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;


public class CFG {

    @FXML
    private Button cfgbutton;

    @FXML
    private ImageView cfgimage;

    @FXML
    private TextField inputfield;

    @FXML
    private TextArea outputfield;

    @FXML
    private Circle s1;

    @FXML
    private Circle s2;

    @FXML
    private Circle s3;

    @FXML
    private Button cfgreturn;

    private void updateState(Circle state, Color color, String message) {
        state.setFill(color);
        outputfield.setText(message);
        System.out.println(message);
    }


    static void reverseArray(String[] arr) {
        int n = arr.length;

        // Temporary array to store elements in reversed order
        String[] temp = new String[n];

        // Copy elements from original array to temp in reverse order
        for (int i = 0; i < n; i++)
            temp[i] = arr[n - i - 1];

        // Copy elements back to original array
        for (int i = 0; i < n; i++)
            arr[i] = temp[i];
    }

    public void initialize() {
        cfgbutton.setOnAction(event -> {
            updateState(s1,Color.BLUE,"");
            updateState(s2,Color.BLUE,"");
            updateState(s3,Color.BLUE,"");

            String inputText = inputfield.getText();

            if (inputText == null || inputText.isEmpty()) {
                outputfield.setText("Invalid Input: Please put a proper string");
                return;
            }

            if (inputText.length() % 2 != 0) {
                outputfield.setText("Invalid String: Input is not even.");
                return;
            }

            int mid = inputText.length() / 2;
            String input = inputText.toLowerCase();
            String firsthalf = input.substring(0, mid);
            String secondhalf = input.substring(mid);

            String secondhalfreversed = new StringBuilder(secondhalf).reverse().toString();

            String[] firstStringArray = firsthalf.split("");
            String[] secondStringArray = secondhalfreversed.split("");

// Run the checking process in a separate thread
            new Thread(() -> {
                for (AtomicInteger i = new AtomicInteger(); i.get() < firstStringArray.length; i.getAndIncrement()) {
                    int index = i.get();

                    Platform.runLater(() -> {

                        if (firstStringArray[index].equals(secondStringArray[index])) {
                            if (index == 0) {
                                updateState(s1, Color.GREEN, "State 1 Reached");
                                outputfield.setText("State 1 Reached");
                            } else if (index == firstStringArray.length - 2) {
                                updateState(s2, Color.GREEN, "State 2 Reached");
                                outputfield.appendText("\nState 2 Reached");
                            } if (index == firstStringArray.length - 1) {
                                updateState(s3, Color.GREEN, "Valid Input");
                                updateState(s2, Color.GREEN, "");
                                outputfield.appendText("\nState 3 Reached");
                                outputfield.appendText("\n"+ firsthalf+ "c"+ secondhalf);
                            }
                        } else {
                            updateState(s1, Color.RED, "Mismatch found: Invalid String Input");
                            updateState(s2, Color.RED, "");
                            updateState(s3, Color.RED, "");
                            outputfield.setText("Mismatch found: Invalid String Input");
                            i.set(9999);

                        }
                    });

                    try {
                        Thread.sleep(1000); // Delay for visual updates
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }).start();

        });

        cfgreturn.setOnAction(ActionEvent -> {
            Functions f = new Functions();
            try {
                f.changeScene(ActionEvent,"Menu.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        }
}
