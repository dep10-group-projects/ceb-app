package lk.ijse.dep10.app.controller.vehicles.inner_views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import lk.ijse.dep10.app.controller.vehicles.CebVehicleViewController;
import lk.ijse.dep10.app.db.DBConnection;
import org.w3c.dom.Text;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        cmbLocation.getSelectionModel().selectedItemProperty().addListener((val, prev, cur)->{
            txtLocation.setText(cur);
        });
        cmbVehicleType.getSelectionModel().selectedItemProperty().addListener((val, prev, cur)->{
            txtVehicleType.setText(cur);
        });

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
    void btnClearOnAction(ActionEvent event) {
        txtVehicleType.clear();
        txtRegistrationNumber.clear();
        txtEngineNumber.clear();
        txtChassisNumber.clear();
        txtManufacturedYear.clear();
        txtLocation.clear();
        txtComments.clear();
        txtRegistrationNumber.requestFocus();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String type = txtVehicleType.getText();
        String registrationNumber= txtRegistrationNumber.getText();
        String engineNumber = txtEngineNumber.getText();
        String chassisNumber = txtChassisNumber.getText();
        String manufacturedYear = txtManufacturedYear.getText();
        int manufacturedYearInt = Integer.parseInt(manufacturedYear);
        String location = txtLocation.getText();
        LocalDate localDate = dtpkrAssignedDate.getValue();
        Date sqlDate = Date.valueOf(localDate);
        String comments = txtComments.getText();

        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            String qry = "INSERT INTO Vehicle (registration_number, owner, type, assigned_date, comments)" +
                    "VALUES ('%s','%s', '%s', '%s', '%s')";
            String formattedQry = String.format(qry, registrationNumber, "CEB", type, sqlDate, comments);
            statement.executeUpdate(formattedQry);

            qry = "INSERT INTO Ceb_Vehicle (ceb_registration_number, location, chassis_number, engine_number, manufacture_year) " +
                    "VALUES ('%s','%s', '%s', '%s', '%s')";
            formattedQry = String.format(qry, registrationNumber, location, chassisNumber, engineNumber, manufacturedYearInt);
            statement.executeUpdate(formattedQry);

            qry = "INSERT INTO Ceb_Assignment_History (reg_num, assigned_location, vehicle_type, assigned_date, comments) " +
                    "VALUES ('%s','%s', '%s', '%s', '%s')";
            formattedQry = String.format(qry, registrationNumber, location, type, sqlDate, comments);
            statement.executeUpdate(formattedQry);


            connection.commit();


        } catch (Throwable e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to save the student").show();
        } finally {
            try {
                DBConnection.getInstance().getConnection().setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

}

