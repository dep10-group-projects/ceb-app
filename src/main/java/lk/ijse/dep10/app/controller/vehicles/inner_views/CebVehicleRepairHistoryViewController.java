package lk.ijse.dep10.app.controller.vehicles.inner_views;

import com.mysql.cj.protocol.a.SqlDateValueEncoder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.dep10.app.controller.vehicles.CebVehicleViewController;
import lk.ijse.dep10.app.db.DBConnection;
import lk.ijse.dep10.app.model.CebVehicleRepair;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CebVehicleRepairHistoryViewController {

    public Label lblUser;
    public Label lblRegistrationNumber;
    public Label lblChassisNumber;
    public Label lblEngineNumber;
    public Label lblType;
    public Label lblYear;
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

    private String regNum;

    public void initialize(){
        regNum = System.getProperty("REG_NUM");
        lblRegistrationNumber.setText(regNum);
        lblChassisNumber.setText(System.getProperty("CHAS_NUM"));
        lblEngineNumber.setText(System.getProperty("ENG_NUM"));
        lblType.setText(System.getProperty("TYPE"));
        lblYear.setText(System.getProperty("MAN_YEAR"));

        String[] locations = {"Area Office","Baddegama CSC", "Wanduraba CSC", "Gonapinuwala CSC",
                "Thalgaswala CSC", "Udumaga CSC", "AMU"};
        cmbLocation.getItems().addAll(locations);

        cmbLocation.getSelectionModel().selectedItemProperty().addListener((val, prev, cur)->{
            if (cur != null) {
                txtLocation.setText(cur);
            }
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
    void btnExportOnAction(ActionEvent event) {

    }

    @FXML
    void btnReAssignOnAction(ActionEvent event) {
        System.out.println("reassgning(cebvehiclerepair btnREassign)");
        String location = txtLocation.getText();
        LocalDate date = dtpkrAssignedDate.getValue();
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement stm1 =
                    connection.prepareStatement("UPDATE Ceb_Assignment_History SET " +
                    "assigned_location=?, assigned_date=? WHERE reg_num=?");
            stm1.setString(1,location);
            stm1.setString(2,date.toString());
            stm1.setString(3, regNum);
            stm1.executeUpdate();

            PreparedStatement stm2 =
                    connection.prepareStatement("UPDATE Vehicle SET " +
                            "assigned_date=? WHERE registration_number=?");
            stm2.setString(1, date.toString());
            stm2.setString(2, regNum);

            PreparedStatement stm3 =
                    connection.prepareStatement("UPDATE Ceb_Vehicle SET " +
                            "location=? WHERE ceb_registration_number=?");
            stm3.setString(1, location);
            stm3.setString(2, regNum);

            connection.commit();
            new Alert(Alert.AlertType.CONFIRMATION, "Successfully Reassigned");

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            new Alert(Alert.AlertType.ERROR, "Re-assigning Process failed!").show();
            throw new RuntimeException(e);
        } finally {
            try {
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
