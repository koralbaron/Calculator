import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

//A class of the Controller - where all the buttons are handled
public class Controller {

    @FXML
    private Label calcScreen;// the screen to display the results on

    private double num1 = 0; // to store the first number of the operation
    private String operator = "";// the current operation

    //event waiting for a number to be clicked
    //and handle this event
    public void onNumberClicked(MouseEvent evt){
        Button btn = (Button)evt.getSource();
        String btnText = btn.getText();
        this.calcScreen.setText(this.calcScreen.getText() + btnText);
    }
    // event waiting for a symbol (not number) to be clicked
    //and handle this event
    public void onSymbolClicked(MouseEvent evt){
        Button btn = (Button)evt.getSource();
        String btnText = btn.getText();
        //this.calcScreen.setText(this.calcScreen.getText() + btnText);
        if(btnText.equals("=")){
            if (operator.equals("")){

            }else {
                int lastIndex = this.calcScreen.getText().lastIndexOf(operator);
                num1 = Double.parseDouble(this.calcScreen.getText().substring(0, lastIndex));
                double num2 = Double.parseDouble(this.calcScreen.getText().substring(lastIndex + 1));
                switch (operator) {
                    case "+":
                        calcScreen.setText((num1 + num2) + "");

                        break;
                    case "-":
                        calcScreen.setText((num1 - num2) + "");
                        break;
                    case "x":
                        calcScreen.setText((num1 * num2) + "");
                        break;
                    case "/":
                        calcScreen.setText((num1 / num2) + "");
                        break;
                    default:
                        calcScreen.setText((num1) + "");

                }
                operator = "";
            }
        }
        else if(btnText.equals("C")) {
            calcScreen.setText(" ");
            operator = "";
        }
        else if(btnText.equals("+/-")){
            num1 = Double.parseDouble(this.calcScreen.getText());
            if(num1 == 0){
                calcScreen.setText(calcScreen.getText());
            }else{
                num1 = -1 * num1;
                calcScreen.setText(num1 +"");
            }
        }
        else if(btnText.equals(".")){
            if(!operator.equals("")){
                int lastIndex = this.calcScreen.getText().lastIndexOf(operator);
                String strNum2 = this.calcScreen.getText().substring(lastIndex + 1);
                if(strNum2.equals("")){// in case of(+.)
                    return;
                }
                double num2 = Double.parseDouble(this.calcScreen.getText().substring(lastIndex + 1));
                calcScreen.setText(this.calcScreen.getText() + ".");
            }
            else {
                num1 = Double.parseDouble(this.calcScreen.getText());
                int intNum1 = (int) num1;
                if ((num1 - intNum1) == 0) {
                    calcScreen.setText(intNum1 + ".");
                } else {
                    return;
                }
            }
        }
        else {
            if(!operator.equals("")){
                return;
            }
            switch (btnText) {
                case "+":
                    operator = "+";
                    break;
                case "-":
                    operator = "-";
                    break;
                case "x":
                    operator = "x";
                    break;
                case "/":
                    operator = "/";
                    break;
            }

            calcScreen.setText(calcScreen.getText()+ btnText);
        }

    }
}
