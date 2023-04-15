package lk.ijse.dep10.app.controller.inner_views;

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

public class CebNewVehicleViewController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnSave;

    @FXML
    private ComboBox<String> cmbLocation;

    @FXML
    private ComboBox<String> cmbVehicleType;

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
    private TextField txtManufacturedYear;

    @FXML
    private TextField txtRegistrationNumber;

    @FXML
    private TextField txtVehicleType;

    public void initialize(){
        String[] vehicleTypes = {"Car", "Van", "Lorry", "Cab", "Other"};
        String[] locations = {"Area Office","Baddegama CSC", "Wanduraba CSC", "Gonapinuwala CSC",
                "Thalgaswala CSC", "Udumaga CSC", "AMU"};
        cmbVehicleType.getItems().addAll(vehicleTypes);
        cmbLocation.getItems().addAll(locations);
    }

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
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

}

