package org.example.therapycenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ReportController implements Initializable {

    @FXML
    private Button btnGenerate;

    @FXML
    private ComboBox<?> btnReport;

    @FXML
    private Button btnSave;

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colPatient;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colTherapyProgram;

    @FXML
    private AnchorPane contentAnchorPane;

    @FXML
    private TableView<?> tblReport;

    @FXML
    private TextField txtReportId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void onActionGenerate(ActionEvent event) {

    }

    @FXML
    void onActionSave(ActionEvent event) {

    }
}
