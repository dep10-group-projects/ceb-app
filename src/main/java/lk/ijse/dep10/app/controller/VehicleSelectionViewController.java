package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class VehicleSelectionViewController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnCebVehicles;

    @FXML
    private Button btnPrivateVehicles;

    @FXML
    private Label lblLoggedIn;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnCebVehiclesOnAction(ActionEvent event) {
        Stage stage = (Stage) btnCebVehicles.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/CebVehicleView.fxml")));
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnPrivateVehiclesOnAction(ActionEvent event) {
        Stage stage = (Stage) btnCebVehicles.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/PrivateVehicleView.fxml")));
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
