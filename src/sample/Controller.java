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
    private char[][] field = new char[3][3];

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
        howMove = 1;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                field[i][j] = 'e';
    }
    private void checkToWin(int x, int y) {
        boolean win = false;
        if(howMove==9) {
            DialogWindows.resultWindowInfo("Nikt nie wygrał");
            resetRound();
        }
        else if(howMove>=5) {
            if(field[x][0] == field[x][1] && field[x][1] == field[x][2])
                win = true;
            else if(field[0][y] == field[1][y] && field[1][y] == field[2][y])
                win = true;
            else if(x==y) {
                if(field[0][0] == field[1][1] && field[1][1] == field[2][2])
                    win = true;
            }
            else if(x+y==2) {
                if(field[0][2] == field[1][1] && field[1][1] == field[2][0])
                    win = true;
            }
            if(win) {
                String whoWin = queueS;
                if(whoWin=="O") {
                    int pointsX = Integer.parseInt(scoreX.getText());
                    pointsX++;
                    scoreX.setText(String.valueOf(pointsX));
                    DialogWindows.resultWindowInfo("Wygrywa gracz X");
                } else {
                    int pointsO = Integer.parseInt(scoreO.getText());
                    pointsO++;
                    scoreO.setText(String.valueOf(pointsO));
                    DialogWindows.resultWindowInfo("Wygrywa gracz O");
                }

                resetRound();
            }
            else
                howMove++;
        }
        else
            howMove++;
    }

    public void clickZeroZero() {
        field[0][0] = queueS.charAt(0);
        changeText(zeroZero);
        checkToWin(0,0);
    }
    public void clickZeroOne() {
        field[0][1] = queueS.charAt(0);
        changeText(zeroOne);
        checkToWin(0,1);
    }
    public void clickZeroTwo() {
        field[0][2] = queueS.charAt(0);
        changeText(zeroTwo);
        checkToWin(0,2);
    }
    public void clickOneZero() {
        field[1][0] = queueS.charAt(0);
        changeText(oneZero);
        checkToWin(1,0);
    }
    public void clickOneOne() {
        field[1][1] = queueS.charAt(0);
        changeText(oneOne);
        checkToWin(1,1);
    }
    public void clickOneTwo() {
        field[1][2] = queueS.charAt(0);
        changeText(oneTwo);
        checkToWin(1,2);
    }
    public void clickTwoZero() {
        field[2][0] = queueS.charAt(0);
        changeText(twoZero);
        checkToWin(2,0);
    }
    public void clickTwoOne() {
        field[2][1] = queueS.charAt(0);
        changeText(twoOne);
        checkToWin(2,1);
    }
    public void clickTwoTwo() {
        field[2][2] = queueS.charAt(0);
        changeText(twoTwo);
        checkToWin(2,2);
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
