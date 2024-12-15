package com.tps.cs4_finalproject;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


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

    public void initialize() {
        cfgbutton.setOnAction(event -> {
            if (inputfield.getText() == null || inputfield.getText().equals("")) {
                outputfield.setText("Invalid Input: Please put a proper string");
                return;
            }


        });

    }
}
