package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {


    @FXML
    private Label result;
    private long number1 = 0;
    private String operator = "";
    private boolean start = true;
    private Model model = new Model();


    public void processNumber(ActionEvent event) {

        if(start) {
            result.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        result.setText(result.getText()+value);


    }
    public void processOperators(ActionEvent event) {


            String value = ((Button)event.getSource()).getText();


            if(!value.equals("=")) {
                if (!operator.isEmpty())
                    return;
                else if(operator.equals("."))
                    value = ((Button)event.getSource()).getText()+operator;


                operator = value;
                number1 = Long.parseLong(result.getText());
                result.setText("");
            }

            else
            {
                if(operator.isEmpty())
                    return;
                long number2 = Long.parseLong(result.getText());
                double output = model.calculate(number1,number2,operator);
                result.setText(String.valueOf(output));
                operator = "";
                start = true;
            }

        }

}


