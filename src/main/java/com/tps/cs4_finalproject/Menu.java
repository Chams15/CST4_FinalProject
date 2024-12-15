package com.tps.cs4_finalproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Menu {
    @FXML
    private Button cfgmenu;

    @FXML
    private Button dfamenu;

    @FXML
    private Button hanoimenu;

    @FXML
    private AnchorPane menupanelright;

    @FXML
    private Button pdamenu;

    @FXML
    private Button turingmachinemenu;


    public void initialize() {
        dfamenu.setOnAction(actionEvent -> {
            try {
                Functions f = new Functions();
                f.changeScene(actionEvent,"DFA.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        pdamenu.setOnAction(actionEvent -> {
            try {
                Functions f = new Functions();
                f.changeScene(actionEvent,"PDA.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        turingmachinemenu.setOnAction(actionEvent -> {
            File htmlFile = new File("src/main/resources/com/tps/cs4_finalproject/TuringMachine/cs4_turingmachine/index.html");
            try {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });

        hanoimenu.setOnAction(actionEvent -> {
            try {
                Functions f = new Functions();
                f.changeScene(actionEvent,"Hanoi.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
