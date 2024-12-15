package com.tps.cs4_finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Stack;

import static com.tps.cs4_finalproject.Functions.sortString;

public class PDA {
    @FXML
    private TextField valueofn;

    @FXML
    private TextField inputarea;

    @FXML
    private Button pdabutton;

    @FXML
    public TextArea pdaTextArea;

    @FXML
    private Button pdareturnbutton;


    boolean simulatePDA(String values, int n) {
        Stack<Character> stack = new Stack<>();
        String state = "q0";

        System.out.printf("δ: (%s, %s, %s)%n", state, values, stack);
        pdaTextArea.appendText(String.format("δ: (%s, %s, %s)%n", state, values, stack));

        for (char ch : values.toCharArray()) {
            if (state.equals("q0") && ch == 'a') {
                stack.push(ch); // Push 'a' onto the stack
                values = values.substring(1); // Remove processed character
                System.out.printf("δ: (%s, %s, %s)%n", state, values, stack);
                pdaTextArea.appendText(String.format("δ: (%s, %s, %s)%n", state, values, stack));
            } else if (ch == 'b') {
                if (stack.isEmpty() || stack.pop() != 'a') {
                    return false;
                }
                state = "q1"; // Transition to state q1 on 'b'
                values = values.substring(1); // Remove processed character
                System.out.printf("δ: (%s, %s, %s)%n", state, values, stack);
                pdaTextArea.appendText(String.format("δ: (%s, %s, %s)%n", state, values, stack));
            } else {
                return false; // Invalid character
            }
        }
        return false;

    }


    public void initialize() {
        pdabutton.setOnAction(event -> {
            pdaTextArea.clear();

            if (inputarea.getText() == null || inputarea.getText().equals("")) {
                pdaTextArea.setText("Invalid Input: Please put a proper string");
                return;
            }
            int n = Integer.valueOf(valueofn.getText());
            String values = inputarea.getText();

            String sortcheck = sortString(values);

            // stack

            if (!(values.length() % 2 == 0)) {
                simulatePDA(values, n);
                System.out.println("Uneven String: Rejected");
                pdaTextArea.appendText("Uneven String: Rejected\n");
            } else {
                if (!(sortcheck.equals(values))) {
                    System.out.println("Value does not follow a^n b^n format");
                    pdaTextArea.appendText("Value does not follow a^n b^n format");
                } else if (Functions.StringHalfComparison.compareStringHalvesToInt(values, n)) {
                    simulatePDA(values, n);
                    System.out.println("Accepted");
                    pdaTextArea.appendText("Accepted\n");

                } else {
                    simulatePDA(values, n);
                    System.out.println("Rejected: a and b does not match the value of n");
                    pdaTextArea.appendText("Rejected: a and b does not match the value of n");
                }

            }





        });

        pdareturnbutton.setOnAction(actionEvent -> {
            try {
                Functions f = new Functions();
                f.changeScene(actionEvent,"Menu.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
