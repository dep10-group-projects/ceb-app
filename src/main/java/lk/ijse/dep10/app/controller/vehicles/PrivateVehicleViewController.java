package lk.ijse.dep10.app.controller.vehicles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import lk.ijse.dep10.app.model.PrivateVehicle;

import java.io.IOException;

public class PrivateVehicleViewController {

    @FXML
    private Button btnAddNewVehicle;

    @FXML
    private Button btnAssignmentHistory;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnExtraVehicleInfo;

    @FXML
    private Button btnPaymentHistory;

    @FXML
    private Label lblLoggedUser;

    @FXML
    private TableView<PrivateVehicle> tblVehicles;

    @FXML
    void btnAddNewVehicleOnAction(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/vehicles/inner_views/PrivateNewVehicleView.fxml")));
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnAssignmentHistoryOnAction(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/vehicles/inner_views/PrivateAssignmentHistory.fxml")));
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnBackOnAction(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/vehicles/VehicleSelectionView.fxml")));
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnExtraVehicleInfoOnAction(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/vehicles/inner_views/PrivateVehicleInfoView.fxml")));
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnPaymentHistoryOnAction(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/vehicles/inner_views/PrivateVehiclePaymentHistoryView.fxml")));
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
