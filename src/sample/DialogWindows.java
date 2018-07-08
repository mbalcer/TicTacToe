package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class DialogWindows {
    public static void resultWindowInfo(String info) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Wynik gry");
        alert.setHeaderText(null);
        alert.setContentText(info);

        alert.showAndWait();
    }

    public static boolean confirmResetGame() {
        Alert dialogReset = new Alert(Alert.AlertType.CONFIRMATION);
        dialogReset.setTitle("Potwierdź zresetowanie gry");
        dialogReset.setHeaderText(null);
        dialogReset.setContentText("Na pewno chcesz zresetować grę?");

        Optional<ButtonType> result = dialogReset.showAndWait();
        if(result.get() == ButtonType.OK)
            return true;
        else
            return false;
    }
}
