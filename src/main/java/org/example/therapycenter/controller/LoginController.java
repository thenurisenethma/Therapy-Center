package org.example.therapycenter.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button btnSignIn;

    @FXML
    private ComboBox<String> comboRole;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> objects = FXCollections.observableArrayList();
        objects.add("Receptionist");
        objects.add("Admin");
        comboRole.setItems(objects);
    }

    @FXML
    void onActionSignin(ActionEvent event) throws IOException {

        String value = comboRole.getValue();
        if (value.equals("Receptionist")) {
            Window window = comboRole.getScene().getWindow();
            window.hide();
            Parent load = FXMLLoader.load(getClass().getResource("/view/Receptionist.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Receptionist");
            Scene scene = new Scene(load);
            stage.setScene(scene);
            stage.show();
        }else {
            Window window = comboRole.getScene().getWindow();
            window.hide();
            Parent load = FXMLLoader.load(getClass().getResource("/view/AdminDashBoard.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Admin");
            Scene scene = new Scene(load);
            stage.setScene(scene);
            stage.show();
        }

    }


}
