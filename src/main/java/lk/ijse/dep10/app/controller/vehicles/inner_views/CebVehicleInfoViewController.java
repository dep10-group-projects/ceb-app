package lk.ijse.dep10.app.controller.vehicles.inner_views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.dep10.app.controller.vehicles.CebVehicleViewController;
import lk.ijse.dep10.app.model.CebVehicle;

import java.io.IOException;
import java.util.ArrayList;

public class CebVehicleInfoViewController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDeleteSelectedRecord;

    @FXML
    private Button btnExport;

    @FXML
    private TableView<CebVehicle> tblVehicle;

    public void initialize(){
        ArrayList<CebVehicle> cebVehicles = CebVehicleViewController.getCebVehicles();

        tblVehicle.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("registrationNumber"));
        tblVehicle.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("currentLocation"));
        tblVehicle.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("type"));
        tblVehicle.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("chassisNumber"));
        tblVehicle.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("engineNumber"));
        tblVehicle.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("manufacturedYear"));
        tblVehicle.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("comments"));

        tblVehicle.getItems().addAll(cebVehicles);
    }
    @FXML
    void btnBackOnAction(ActionEvent event) {
        CebVehicleViewController.getCebVehicles().clear();
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
