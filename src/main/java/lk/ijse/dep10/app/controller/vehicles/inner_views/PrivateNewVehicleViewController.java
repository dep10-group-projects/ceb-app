package lk.ijse.dep10.app.controller.vehicles.inner_views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PrivateNewVehicleViewController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnSave;

    @FXML
    private ComboBox<String> cmbPerson;

    @FXML
    private ComboBox<String> cmbType;

    @FXML
    private DatePicker dtpkrAssignedDate;

    @FXML
    private TextField txtChassisNumber;

    @FXML
    private TextArea txtComments;

    @FXML
    private TextField txtEngineNumber;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtRegistrationNumber;

    @FXML
    private TextField txtVehicleType;

    public void initialize(){
        String[] persons = {
                "EE-Area Office", "EA-Area Office", "ES com1-Area office", "ES com2-Area office",
                "ES Office1-Area office", "ES office2-Area office", "ES-Baddegama CSC", "ES-Wanduraba CSC",
                "ES-Gonapinuwala CSC", "ES-Thalgaswala CSC", "ES-Udumaga CSC", "ES-AMU"
        };
        String[] types = {"Car", "Van", "Lorry", "Cab", "Other"};
        cmbPerson.getItems().addAll(persons);
        cmbType.getItems().addAll(types);
    }
    @FXML
    void btnBackOnAction(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/vehicles/PrivateVehicleView.fxml")));
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

}
