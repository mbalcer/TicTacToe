package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    Label score;

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

    private String queue = "X";

    private void changeQueue() {
        if(queue=="X")
            queue = "O";
        else
            queue = "X";
    }
    private void changeText(Button btn) {
        btn.setText(queue);
        changeQueue();
        btn.setDisable(true);
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
}
