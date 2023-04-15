package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import lk.ijse.dep10.app.model.CebVehicle;

import java.io.IOException;

public class CebVehicleViewController {

    @FXML
    private Button btnAddNewVehicle;

    @FXML
    private Button btnAssignmentHistory;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnExtraVehicleInfo;

    @FXML
    private Button btnRepairHistory;

    @FXML
    private Label lblLoggedUser;

    @FXML
    private TableView<CebVehicle> tblVehicles;

    @FXML
    void btnAddNewVehicleOnAction(ActionEvent event) {
        Stage stage = (Stage) btnAddNewVehicle.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/inner_views/CebNewVehicleView.fxml")));
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnAssignmentHistoryOnAction(ActionEvent event) {
        Stage stage = (Stage) btnAssignmentHistory.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/inner_views/CebAssignmentHistoryView.fxml")));
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnBackOnAction(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/VehicleSelectionView.fxml")));
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnExtraVehicleInfoOnAction(ActionEvent event) {
        Stage stage = (Stage) btnExtraVehicleInfo.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/inner_views/CebVehicleInfoView.fxml")));
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnRepairHistoryOnAction(ActionEvent event) {
        Stage stage = (Stage) btnRepairHistory.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/inner_views/CebVehicleRepairHistoryView.fxml")));
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
