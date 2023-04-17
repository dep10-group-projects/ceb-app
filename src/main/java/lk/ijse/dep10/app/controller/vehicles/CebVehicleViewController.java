package lk.ijse.dep10.app.controller.vehicles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.dep10.app.db.DBConnection;
import lk.ijse.dep10.app.model.CebVehicle;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class CebVehicleViewController {

    @FXML
    private Button btnAddNewVehicle;

    @FXML
    private Button btnAssignmentHistory;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnExtraVehicleInfo;

    @FXML
    private Button btnRepairHistory;

    @FXML
    private Label lblLoggedUser;

    @FXML
    private TableView<CebVehicle> tblVehicles;

    private static ArrayList<CebVehicle> cebVehicles = new ArrayList<>();

    public void initialize(){
        tblVehicles.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("registrationNumber"));
        tblVehicles.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("currentLocation"));
        tblVehicles.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("type"));


        loadVehicles();


        System.out.println(cebVehicles);

        tblVehicles.getItems().addAll(cebVehicles);

    }

    public static ArrayList<CebVehicle> getCebVehicles() {
        return cebVehicles;
    }

    private void loadVehicles() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Vehicle WHERE owner='CEB'");
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Ceb_Vehicle WHERE ceb_registration_number=?");
            while (resultSet.next()) {
                String registrationNumber = resultSet.getString("registration_number");
                String type = resultSet.getString("type");
                String comments = resultSet.getString("comments");
                preparedStatement.setString(1, registrationNumber);
                ResultSet rst1 = preparedStatement.executeQuery();
                while (rst1.next()) {
                    String location = rst1.getString("location");
                    String chassisNumber = rst1.getString("chassis_number");
                    String engineNumber = rst1.getString("engine_number");
                    int manufacturedYear = rst1.getInt("manufacture_year");
                    CebVehicle vehicle = new CebVehicle(registrationNumber, location, type, chassisNumber, engineNumber,
                            manufacturedYear, comments );
                    System.out.println(vehicle);
                    cebVehicles.add(vehicle);
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void btnAddNewVehicleOnAction(ActionEvent event) {
        Stage stage = (Stage) btnAddNewVehicle.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/vehicles/inner_views/CebNewVehicleView.fxml")));
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnAssignmentHistoryOnAction(ActionEvent event) {
        Stage stage = (Stage) btnAssignmentHistory.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/vehicles/inner_views/CebAssignmentHistoryView.fxml")));
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnBackOnAction(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/vehicles/VehicleSelectionView.fxml")));
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnExtraVehicleInfoOnAction(ActionEvent event) {
        Stage stage = (Stage) btnExtraVehicleInfo.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/vehicles/inner_views/CebVehicleInfoView.fxml")));
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnRepairHistoryOnAction(ActionEvent event) {
        Stage stage = (Stage) btnRepairHistory.getScene().getWindow();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/vehicles/inner_views/CebVehicleRepairHistoryView.fxml")));
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
