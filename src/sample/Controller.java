package sample;

public class Controller {

    public double Calculator(long number1, long number2, String operator){

        switch (operator) {
            case "+": {
                return number1 + number2;
            }
            case "-": {
                return number1 - number2;

            }
            case "/": {
                if(number2==0){
                    return 0;
                }
                return number1 / number2;
            }
            case "X": {
                return number1 * number2;
            }
            default:
                break;
        }

        return 0;
    }
}
