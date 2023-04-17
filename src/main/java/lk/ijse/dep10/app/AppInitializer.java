package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.dep10.app.db.DBConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        generateTables();
        boolean adminExists = adminExists();
        String url = adminExists ? "/view/vehicles/LoginView.fxml" : "/view/vehicles/SignUpView.fxml";
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource(url))));
//        primaryStage.setResizable(false);
//        primaryStage.setTitle(adminExists ? "Login": "Create Admin Account");
        primaryStage.setTitle("CEB-Vehicle Management System");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

    private boolean adminExists(){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            return stm.executeQuery("SELECT * FROM User WHERE role='ADMIN'").next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void generateTables() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
//            ResultSet rst = stm.executeQuery("SHOW TABLES");

            if (true){
                System.out.println("Generating tables");
                InputStream is = getClass().getResourceAsStream("/schema.sql");
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                StringBuilder dbScript = new StringBuilder();
                while ((line = br.readLine()) != null){
                    dbScript.append(line).append("\n");
                }
                br.close();
                stm.execute(dbScript.toString());
            }
            System.out.println("Tables generated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
