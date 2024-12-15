package com.tps.cs4_finalproject;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DFA {
    @FXML
    public Button dfaButton;

    @FXML
    public TextField dfatext;
    @FXML
    public Circle s1;

    @FXML
    public Circle s2;

    @FXML
    public Circle s3;

    @FXML
    public Circle deadstate;

    @FXML
    public Button returnDFA;

    public void initialize() {
        dfaButton.setOnAction(event -> {
            try {
                String inputText = dfatext.getText();

                // Handle null or empty input
                if (inputText == null || inputText.isEmpty()) {
                    System.out.println("Input text is empty or null");
                    return;
                }

                // Get the first character of the string
                char firstChar = inputText.charAt(0);
                int length = inputText.length();


                new Thread(() -> {
                    for (final int[] i = {0}; i[0] < length; i[0]++) {
                        int index = i[0];
                        Platform.runLater(() -> {
                            if(Functions.syntaxMatch(firstChar, inputText.charAt(index))) {
                                if (index == length - 1) {
                                    s3.setFill(Color.GREEN);

                                    System.out.println("State 3");
                                } else if (index == length - 2) {
                                    s2.setFill(Color.GREEN);

                                    System.out.println("State 2");
                                } else {
                                    s1.setFill(Color.GREEN);

                                    System.out.println("State 1");
                                }
                            }
                            else{
                                deadstate.setFill(Color.RED);
                                System.out.println("Dead State");
                                i[0] = 9999;

                            }

                        });

                        // Delay to simulate state transition
                        try {
                            Thread.sleep(1000); // Reduce delay to make UI more responsive
                        } catch (InterruptedException e) {
                            System.err.println("Thread interrupted: " + e.getMessage());
                            return;
                        }

                    }
                }).start();
            }
        finally{
                    s1.setFill(Color.BLUE);
                    s2.setFill(Color.BLUE);
                    s3.setFill(Color.BLUE);
                    deadstate.setFill(Color.BLUE);

                }

        });

        returnDFA.setOnAction(actionEvent -> {
            try {
                Functions f = new Functions();
                f.changeScene(actionEvent,"Menu.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

}