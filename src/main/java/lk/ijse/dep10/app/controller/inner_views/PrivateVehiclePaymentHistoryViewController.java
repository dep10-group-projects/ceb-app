package lk.ijse.dep10.app.controller.inner_views;

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
import lk.ijse.dep10.app.model.PrivateVehiclePayment;

import java.io.IOException;

public class PrivateVehiclePaymentHistoryViewController {

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
    private ComboBox<String> cmbPerson;

    @FXML
    private DatePicker dtpkrAssignedDate;

    @FXML
    private DatePicker dtpkrRepairDate;

    @FXML
    private TableView<PrivateVehiclePayment> tblPayments;

    @FXML
    private TextField txtCost;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtDistance;

    @FXML
    private TextField txtLocation;

    public void initialize(){
        String[] persons = {
                "EE-Area Office", "EA-Area Office", "ES com1-Area office", "ES com2-Area office",
                "ES Office1-Area office", "ES office2-Area office", "ES-Baddegama CSC", "ES-Wanduraba CSC",
                "ES-Gonapinuwala CSC", "ES-Thalgaswala CSC", "ES-Udumaga CSC", "ES-AMU"
        };
        cmbPerson.getItems().addAll(persons);
    }

    @FXML
    void btnBackOnAction(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/PrivateVehicleView.fxml")));
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
