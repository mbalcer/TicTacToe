package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    Label scoreX;
    @FXML
    Label scoreO;
    @FXML
    Label queue;

    @FXML
    Button zeroZero;
    @FXML
    Button zeroOne;
    @FXML
    Button zeroTwo;
    @FXML
    Button oneZero;
    @FXML
    Button oneOne;
    @FXML
    Button oneTwo;
    @FXML
    Button twoZero;
    @FXML
    Button twoOne;
    @FXML
    Button twoTwo;

    private String queueS = "X";
    private int howMove = 1;

    private void changeQueue() {
        if (queueS == "X") {
            queueS = "O";
            queue.setText("O");
        }
        else {
            queueS = "X";
            queue.setText("X");
        }
    }
    private void changeText(Button btn) {
        btn.setText(queueS);
        changeQueue();
        btn.setDisable(true);
        checkToWin();
    }
    private void resetButton(Button btn) {
        btn.setDisable(false);
        btn.setText("");
    }
    private void resetRound() {
        resetButton(zeroZero);
        resetButton(zeroOne);
        resetButton(zeroTwo);
        resetButton(oneZero);
        resetButton(oneOne);
        resetButton(oneTwo);
        resetButton(twoZero);
        resetButton(twoOne);
        resetButton(twoTwo);
        howMove=1;
    }
    private void checkToWin() {
        if(howMove>=5) {
            if((zeroZero.getText() == zeroOne.getText() && zeroZero.getText() == zeroTwo.getText() && zeroZero.getText()!="") ||
            (oneZero.getText() == oneOne.getText() && oneZero.getText() == oneTwo.getText() && oneZero.getText()!="") ||
            (twoZero.getText() == twoOne.getText() && twoZero.getText() == twoTwo.getText() && twoZero.getText()!="") ||
            (zeroZero.getText() == oneZero.getText() && oneZero.getText() == twoZero.getText() && zeroZero.getText()!="") ||
            (zeroOne.getText() == oneOne.getText() && oneOne.getText() == twoOne.getText() && zeroOne.getText()!="") ||
            (zeroTwo.getText() == oneTwo.getText() && oneTwo.getText() == twoTwo.getText() && zeroTwo.getText()!="") ||
            (zeroZero.getText() == oneOne.getText() && oneOne.getText() == twoTwo.getText() && zeroZero.getText()!="") ||
            (zeroTwo.getText() == oneOne.getText() && oneOne.getText() == twoZero.getText() && zeroTwo.getText()!="")
                    ){
                String whoWin = queueS;
                if(whoWin=="O") {
                    int pointsX = Integer.parseInt(scoreX.getText());
                    pointsX++;
                    scoreX.setText(String.valueOf(pointsX));
                    DialogWindows.resultWindowInfo("Wygrywa gracz O");
                } else {
                    int pointsO = Integer.parseInt(scoreO.getText());
                    pointsO++;
                    scoreO.setText(String.valueOf(pointsO));
                    DialogWindows.resultWindowInfo("Wygrywa gracz O");
                }

                resetRound();
            }
            else if(howMove==9) {
                DialogWindows.resultWindowInfo("Nikt nie wygrał");
                resetRound();
            }
            else
                howMove++;
        }
        else
            howMove++;
    }

    public void clickZeroZero() {
        changeText(zeroZero);
    }
    public void clickZeroOne() {
        changeText(zeroOne);
    }
    public void clickZeroTwo() {
        changeText(zeroTwo);
    }
    public void clickOneZero() {
        changeText(oneZero);
    }
    public void clickOneOne() {
        changeText(oneOne);
    }
    public void clickOneTwo() {
        changeText(oneTwo);
    }
    public void clickTwoZero() {
        changeText(twoZero);
    }
    public void clickTwoOne() {
        changeText(twoOne);
    }
    public void clickTwoTwo() {
        changeText(twoTwo);
    }
    public void resetGame() {
        if(DialogWindows.confirmResetGame()) {
            resetRound();
            queueS = "X";
            queue.setText("X");
            scoreO.setText("0");
            scoreX.setText("0");
        }
    }
}
