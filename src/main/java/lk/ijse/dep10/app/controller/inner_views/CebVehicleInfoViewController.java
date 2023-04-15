package lk.ijse.dep10.app.controller.inner_views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import lk.ijse.dep10.app.model.CebVehicle;

import java.io.IOException;

public class CebVehicleInfoViewController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDeleteSelectedRecord;

    @FXML
    private Button btnExport;

    @FXML
    private TableView<CebVehicle> tblVehicle;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/CebVehicleView.fxml")));
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
