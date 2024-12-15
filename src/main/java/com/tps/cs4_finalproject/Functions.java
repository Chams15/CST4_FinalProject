package com.tps.cs4_finalproject;
import com.almasb.fxgl.app.GameApplication;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import static com.tps.cs4_finalproject.HelloApplication.primaryStage;


public class Functions {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public static String sortString(String inputString) {
        // Converting input string to character array
        char tempArray[] = inputString.toCharArray();

        // Sorting temp array using
        Arrays.sort(tempArray);

        // Returning new sorted string
        return new String(tempArray);
    }
    public class StringHalfComparison {
        public static boolean compareStringHalvesToInt(String input, int n) {
            if (input.length() % 2 != 0) {
                throw new IllegalArgumentException("String length must be even.");
            } // Split the string into two halves
            else {
                int mid = input.length() / 2;
                int firsthalf = input.substring(0, mid).length();
                int secondhalf = input.substring(mid).length();

                return firsthalf == n || secondhalf == n;

            }
        }
    }
    public void changeScene(ActionEvent event, String fxml) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    static String insertStringInMiddle(String original, String toInsert) {

        int middleIndex = original.length() / 2;
        String firstHalf = original.substring(0, middleIndex);
        String secondHalf = original.substring(middleIndex);


        return firstHalf + toInsert + secondHalf;
    }

    public static boolean syntaxMatch(char str1, char str2) {
        char ch1 = str1;
        char ch2 = str2;

        if (Character.isLetter(ch1) && Character.isLetter(ch2)) {
            return true;
        } else if (Character.isDigit(ch1) && Character.isDigit(ch2)) {
            return true;
        } else if (!Character.isLetterOrDigit(ch1) && !Character.isLetterOrDigit(ch2)) {
            return true;
        } else {
            return false;
        }
    }
}
