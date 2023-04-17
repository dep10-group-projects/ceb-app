package lk.ijse.dep10.app.controller.vehicles.inner_views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.dep10.app.db.DBConnection;
import lk.ijse.dep10.app.model.CebAssignments;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class CebAssignmentHistoryViewController {

    public TableView<CebAssignments> tblAssignments;
    @FXML
    private Button btnBack;

    @FXML
    private Button btnDeleteSelectedRecord;

    @FXML
    private Button btnExport;

    @FXML
    private TextField txtSearch;

    public void initialize(){
        tblAssignments.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("registrationNumber"));
        tblAssignments.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("assignedLocation"));
        tblAssignments.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("type"));
        tblAssignments.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("assignedDateString"));
        tblAssignments.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("comments"));

        loadData("");

        txtSearch.textProperty().addListener((val, prev,current)->{
            loadData(current);
        });
    }

    private void loadData(String qry ){
        qry = "%"+qry+"%";
        tblAssignments.getItems().clear();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String query = "SELECT * FROM Ceb_Assignment_History WHERE reg_num LIKE ? || assigned_location LIKE ?";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1,qry);
            stm.setString(2,qry);
            ResultSet rst = stm.executeQuery();

            while (rst.next()) {
                String regNum = rst.getString("reg_num");
                String assignedLocation = rst.getString("assigned_location");
                String vehicleType = rst.getString("vehicle_type");
                Date assignedDate = rst.getDate("assigned_date");
                String comments = rst.getString("comments");

                CebAssignments cebAssignments = new CebAssignments(regNum, assignedLocation, vehicleType, assignedDate, comments);
                tblAssignments.getItems().add(cebAssignments);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
    void btnDeleteSelectedRecordOnAction(ActionEvent event) {

    }

    @FXML
    void btnExportOnAction(ActionEvent event) {

    }

}
