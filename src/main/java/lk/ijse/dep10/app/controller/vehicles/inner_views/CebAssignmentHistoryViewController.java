package lk.ijse.dep10.app.controller.vehicles.inner_views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CebAssignmentHistoryViewController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDeleteSelectedRecord;

    @FXML
    private Button btnExport;

    @FXML
    private TextField txtSearch;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/vehicles/CebVehicleView.fxml")));
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDeleteSelectedRecordOnAction(ActionEvent event) {

    }

    @FXML
    void btnExportOnAction(ActionEvent event) {

    }

}
