package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainController {
    private BigDecimal left;
    private String selectedOperator;
    private boolean start;

    @FXML

    private TextField textField;

    public MainController(){
        this.left = BigDecimal.ZERO;
        this.selectedOperator = "";
        this.start = false;
    }


    public void processNumber(ActionEvent event) {

        Button button = (Button)event.getSource();
        String buttonText = button.getText();
        if(buttonText.equals("C")){
            if(buttonText.equals("C")){
                left = BigDecimal.ZERO;
            }
            selectedOperator = "";
            start = true;
            textField.setText("");
            return;
        }

        if(buttonText.matches("[0-9\\.]")){
            if(!start){
                start = true;
                textField.clear();

            }
            textField.appendText(buttonText);
            return;
        }
        if(buttonText.matches("[-X/+]")){

            left = new BigDecimal(textField.getText());
            selectedOperator = buttonText;
            start = false;
            return;
        }

        if(buttonText.equals("=")){
            final BigDecimal right = start ? new BigDecimal(textField.getText()) : left;

            left = calculate(selectedOperator, left, right);
            textField.setText(left.toString());
            start = false;

            if(right.equals("0")){
                textField.setText("You cannot divide by ZERO!");
            }

            return;

        }


    }
    public static BigDecimal calculate(String operator, BigDecimal left, BigDecimal right){

        switch (operator){
            case "+":
                return left.add(right);
            case "-":
                return left.subtract(right);
            case "X":
                return left.multiply(right);
            case "/":

                try {
                    return left.divide(right, 3, RoundingMode.CEILING);
                }
                catch (ArithmeticException ae){

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("ERROR");
                    alert.setContentText("You cannot divide by ZERO!");
                    alert.showAndWait();

                }

        }


        return right;
    }

}


