package org.example.therapycenter.controller;

import javafx.scene.control.*;
import org.example.therapycenter.bo.custom.LoginBO;
import org.example.therapycenter.bo.custom.impl.LoginBOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.collections.FXCollections;

import java.io.IOException;

public class SignUpController {
    private final LoginBO loginBO = new LoginBOImpl();

    @FXML
    private Button btnSignIn;

    @FXML
    private Button btnSignUp;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private ComboBox<String> comboRole;

    @FXML
    private void initialize() {
        comboRole.setItems(FXCollections.observableArrayList("Admin", "Receptionist"));
    }

    @FXML
    void onActionSignUp(ActionEvent event) {
        String username = txtUserName.getText();
        String password = txtPassword.getText();
        String role = comboRole.getValue();

        if (username.isEmpty() || password.isEmpty() || role == null || role.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please fill all fields!").show();
            return;
        }

        boolean isSaved = loginBO.saveUser(username, password, role);

        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "User registered successfully!").show();
            clearFields();
        } else {
            new Alert(Alert.AlertType.ERROR, "Registration failed. Try again!").show();
        }
    }

    private void clearFields() {
        txtUserName.clear();
        txtPassword.clear();
        comboRole.getSelectionModel().clearSelection();
    }

    @FXML
    void onActionSignin(ActionEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
    }
}
