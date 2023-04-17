package lk.ijse.dep10.app.controller.vehicles.inner_views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.dep10.app.model.CebVehicleRepair;

import java.io.IOException;

public class CebVehicleRepairHistoryViewController {

    @FXML
    private Button btnAddNewRepair;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDeleteRecord;

    @FXML
    private Button btnExport;

    @FXML
    private Button btnReAssign;

    @FXML
    private ComboBox<String> cmbLocation;

    @FXML
    private DatePicker dtpkrAssignedDate;

    @FXML
    private DatePicker dtpkrRepairDate;

    @FXML
    private TableView<CebVehicleRepair> tblRepairs;

    @FXML
    private TextField txtCost;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtSlipNumber;

    public void initialize(){
        String[] locations = {"Area Office","Baddegama CSC", "Wanduraba CSC", "Gonapinuwala CSC",
                "Thalgaswala CSC", "Udumaga CSC", "AMU"};
        cmbLocation.getItems().addAll(locations);
    }

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
    void btnExportOnAction(ActionEvent event) {

    }

    @FXML
    void btnReAssignOnAction(ActionEvent event) {

    }

}
