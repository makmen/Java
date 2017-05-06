package task.four;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import task.MainApp;
import task.debug.ShowAlarm;
import task.lib.*;

/**
 * Created by AMakas on 25.01.2017.
 */
public class FourController {
    private int limit = 10;
    private double firstNumber;
    private double secondNumber;
    private Operation operation = new Operation();
    private boolean clearTfMain = false;
    @FXML
    private TextField tfMain;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btn0;

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    private void SetNumber(String idBtn) {
        String mainText = tfMain.getText();
        if (clearTfMain) {
            mainText = "0";
            clearTfMain = false;
        }
        if (mainText.length() < limit) {
            String number = idBtn.substring(idBtn.length() - 1);
            if ( !mainText.equals("0") ) {
                tfMain.setText( mainText + number );
            } else {
                tfMain.setText( number );
            }
        }
    }
    @FXML
    private void handleSetComma() {
        String mainText = tfMain.getText();
        if (mainText.length() < limit) {
            if (!mainText.contains(",")) {
                tfMain.setText( mainText + "," );
            }
        }
    }
    @FXML
    private void handleSetNumber0() {
        SetNumber(btn0.getId());
    }
    @FXML
    private void handleSetNumber1() {
        SetNumber(btn1.getId());
    }
    @FXML
    private void handleSetNumber2() {
        SetNumber(btn2.getId());
    }
    @FXML
    private void handleSetNumber3() {
        SetNumber(btn3.getId());
    }
    @FXML
    private void handleSetNumber4() {
        SetNumber(btn4.getId());
    }
    @FXML
    private void handleSetNumber5() {
        SetNumber(btn5.getId());
    }
    @FXML
    private void handleSetNumber6() {
        SetNumber(btn6.getId());
    }
    @FXML
    private void handleSetNumber7() {
        SetNumber(btn7.getId());
    }
    @FXML
    private void handleSetNumber8() {
        SetNumber(btn8.getId());
    }
    @FXML
    private void handleSetNumber9() {
        SetNumber(btn9.getId());
    }
    @FXML
    private void handleClearAll() {
        tfMain.setText("0");
        clearTfMain = false;
        firstNumber = secondNumber = 0;
        operation.setStrategy(null);
    }
    @FXML
    private void handleClear() {
        if ( !tfMain.equals("0") ) {
            tfMain.setText("0");
        }
    }
    @FXML
    private void handleBack() {
        String mainText = tfMain.getText();
        if ( !mainText.equals("0") ) {
            mainText = mainText.substring(0, mainText.length() - 1);
            tfMain.setText( (!mainText.equals("")) ? mainText : "0" );
        }
    }
    @FXML
    private void handleDiv() {
        firstNumber = toDouble(tfMain.getText());
        clearTfMain = true;
        operation.setStrategy(new OperationDivision());
    }
    @FXML
    private void handleMul() {
        firstNumber = toDouble(tfMain.getText());
        clearTfMain = true;
        operation.setStrategy(new OperationMultiplication());
    }
    @FXML
    private void handleMinus() {
        firstNumber = toDouble(tfMain.getText());
        clearTfMain = true;
        operation.setStrategy(new OperationSubtraction());
    }
    @FXML
    private void handlePlus() {
        firstNumber = toDouble(tfMain.getText());
        clearTfMain = true;
        operation.setStrategy(new OperationAddition());
    }
    @FXML
    private void handleEqual() {
        if (operation.getStrategy() != null) {
            secondNumber = toDouble(tfMain.getText());
            clearTfMain = true;
            firstNumber = operation.calculation(firstNumber, secondNumber);
            tfMain.setText( toNeedString(firstNumber) );
        }
    }
    @FXML
    private void handleRevert() {
        handleDiv();
        if (firstNumber != 0) {
            firstNumber = operation.calculation(1, firstNumber);
            tfMain.setText(toNeedString(firstNumber));
        }
    }
    @FXML
    private void handlePlusMinus() {
        handleMul();
        if (firstNumber != 0) {
            firstNumber = operation.calculation(-1, firstNumber);
            tfMain.setText( toNeedString(firstNumber) );
        }
    }
    @FXML
    private void handleSqrt() {
        firstNumber = toDouble(tfMain.getText());
        clearTfMain = true;
        if (firstNumber >= 0) {
            firstNumber = Math.sqrt(firstNumber);
            tfMain.setText( toNeedString(firstNumber) );
        }
    }

    private String toNeedString(double num) {
        String output = Double.toString(num);
        if (output.contains(".")) {
            output = output.replace('.', ',');
        }

        return output;
    }

    private double toDouble(String str) {
        if (str.contains(",")) {
            str = str.replace(',', '.');
        }
        double output;
        try {
            output = Double.parseDouble(str);
        } catch(Exception ex) {
            output = 0;
        }

        return output;
    }

}
