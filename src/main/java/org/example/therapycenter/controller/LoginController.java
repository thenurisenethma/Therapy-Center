package org.example.therapycenter.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.example.therapycenter.bo.custom.LoginBO;
import org.example.therapycenter.bo.custom.impl.LoginBOImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnSignIn;

    @FXML
    private ComboBox<String> comboRole;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    private final LoginBO loginBo = new LoginBOImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> objects = FXCollections.observableArrayList();
        objects.add("Receptionist");
        objects.add("Admin");
        comboRole.setItems(objects);
    }
    @FXML
    void onActionSignUp(ActionEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/SignUp.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Sign Up");
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void onActionSignin(ActionEvent event) throws IOException {
        String username = txtUserName.getText();
        String password = txtPassword.getText();
        String value = comboRole.getValue();

        if (loginBo.authenticateUser(username, password) && value.equals("Receptionist")) {
            Window window = comboRole.getScene().getWindow();
            window.hide();
            Parent load = FXMLLoader.load(getClass().getResource("/view/Receptionist.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Receptionist");
            Scene scene = new Scene(load);
            stage.setScene(scene);
            stage.show();
        } else if (loginBo.authenticateUser(username, password) && value.equals("Admin")) {
            Window window = comboRole.getScene().getWindow();
            window.hide();
            Parent load = FXMLLoader.load(getClass().getResource("/view/AdminDashBoard.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Admin");
            Scene scene = new Scene(load);
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Login failed! Please check username, password, and role.");
            alert.showAndWait();
        }
    }



}
