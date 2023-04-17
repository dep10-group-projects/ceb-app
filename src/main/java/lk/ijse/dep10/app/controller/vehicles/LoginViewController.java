package lk.ijse.dep10.app.controller.vehicles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewController {

    @FXML
    private Button btnLogIn;

    @FXML
    private TextField btnPassword;

    @FXML
    private TextField txtPfNumber;

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        Stage stage = (Stage) btnLogIn.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/vehicles/VehicleSelectionView.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
