package lk.ijse.dep10.app.controller.vehicles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.dep10.app.db.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginViewController {

    @FXML
    private Button btnLogIn;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPfNumber;

    @FXML
    void btnLoginOnAction(ActionEvent event) {

        if(!dataValid()) return;

        Stage stage = (Stage) btnLogIn.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/vehicles/VehicleSelectionView.fxml"))));
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean dataValid() {
        boolean dataValid = true;

        String pfNumber = txtPfNumber.getText();
        String password = txtPassword.getText();

        if(pfNumber.isEmpty()){
            txtPfNumber.requestFocus();
            return false;
        } else if (password.isEmpty()) {
            txtPassword.requestFocus();
            return false;
        }

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User WHERE pf_number=" + pfNumber);
            if(!resultSet.next()){
                txtPfNumber.requestFocus();
                return false;
            }

            String passwordFromDB = resultSet.getString("password");
            if (!passwordFromDB.equals(password)) {
                txtPassword.requestFocus();
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return dataValid;
    }

}
