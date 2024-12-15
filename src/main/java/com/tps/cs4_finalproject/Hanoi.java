package com.tps.cs4_finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Hanoi {

    @FXML
    private TextField inputhanoi;

    @FXML
    private TextArea outputhanoi;

    @FXML
    private Button returnhanoi;

    @FXML
    private Button solvehanoi;

    @FXML
    private Button testbuttonhanoi;

    private int count = 0;

    public void solveTowerOfHanoi(int n, String source, String target, String auxiliary, TextArea textArea) {
        if (n == 1) {
            count++;
            textArea.appendText("Move disk 1 from " + source + " to " + target + " | Move Count: " + count + "\n");
            return;
        }


        solveTowerOfHanoi(n - 1, source, auxiliary, target, textArea);

        count++; // Increment the move count for the nth disk move
        textArea.appendText("Move disk " + n + " from " + source + " to " + target + " | Move Count: " + count + "\n");


        solveTowerOfHanoi(n - 1, auxiliary, target, source, textArea);
    }



    public void initialize() {

        returnhanoi.setOnAction(actionEvent -> {

            try {
                Functions f = new Functions();
                f.changeScene(actionEvent,"Menu.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        solvehanoi.setOnAction(actionEvent -> {

            outputhanoi.setText("");
            count = 0;
            int n = Integer.valueOf(inputhanoi.getText());
            solveTowerOfHanoi(n,"A", "C", "B", outputhanoi);

        });

        testbuttonhanoi.setOnAction(actionEvent -> {
            try {
                Desktop.getDesktop().browse(new URL("https://cahucom-hanoi.vercel.app/").toURI());
            } catch (Exception e) {
                System.out.println(e);
            }

        });
    }
}
