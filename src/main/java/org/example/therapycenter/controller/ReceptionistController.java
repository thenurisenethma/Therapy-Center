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

public class ReceptionistController implements Initializable {

    @FXML
    private Button btnPatient;

    @FXML
    private Button btnPayment;

    @FXML
    private Button btnReports;

    @FXML
    private Button btnScheduling;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private AnchorPane navBarAnchorPane;

    @FXML
    private AnchorPane receptionistContentAnPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void onActionPatient(ActionEvent event) throws IOException {
        receptionistContentAnPane.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("/view/Patient.fxml"));
        receptionistContentAnPane.getChildren().add(load);
    }

    @FXML
    void onActionPayment(ActionEvent event) throws IOException {
        receptionistContentAnPane.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("/view/Payment.fxml"));
        receptionistContentAnPane.getChildren().add(load);
    }

    @FXML
    void onActionReports(ActionEvent event) throws IOException {
        receptionistContentAnPane.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("/view/Report.fxml"));
        receptionistContentAnPane.getChildren().add(load);
    }

    @FXML
    void onActionSchedule(ActionEvent event) throws IOException {
        receptionistContentAnPane.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("/view/Schedule.fxml"));
        receptionistContentAnPane.getChildren().add(load);
    }

}
