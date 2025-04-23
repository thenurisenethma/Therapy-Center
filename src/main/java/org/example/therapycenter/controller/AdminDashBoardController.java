package org.example.therapycenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashBoardController implements Initializable {

    @FXML
    private Button btnPatient;

    @FXML
    private Button btnPayment;

    @FXML
    private Button btnReports;

    @FXML
    private Button btnScheduling;

    @FXML
    private Button btnTherapist;

    @FXML
    private Button btnTherapyProgram;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private AnchorPane navBarAnchorPane;

    @FXML
    private AnchorPane AdminContentAnPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void onActionPatient(ActionEvent event) throws IOException {
        AdminContentAnPane.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("/view/Patient.fxml"));
        AdminContentAnPane.getChildren().add(load);
    }

    @FXML
    void onActionPayment(ActionEvent event) throws IOException {
        AdminContentAnPane.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("/view/Payment.fxml"));
        AdminContentAnPane.getChildren().add(load);
    }

    @FXML
    void onActionReports(ActionEvent event) throws IOException {
        AdminContentAnPane.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("/view/Report.fxml"));
        AdminContentAnPane.getChildren().add(load);

    }

    @FXML
    void onActionSchedule(ActionEvent event) throws IOException {
        AdminContentAnPane.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("/view/Schedule.fxml"));
        AdminContentAnPane.getChildren().add(load);
    }

    @FXML
    void onActionTherapist(ActionEvent event) throws IOException {
        AdminContentAnPane.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("/view/Therapist.fxml"));
        AdminContentAnPane.getChildren().add(load);
    }

    @FXML
    void onActionTherapyProgram(ActionEvent event) throws IOException {
        AdminContentAnPane.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("/view/TherapyProgram.fxml"));
        AdminContentAnPane.getChildren().add(load);
    }

}
