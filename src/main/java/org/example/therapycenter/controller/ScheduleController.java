package org.example.therapycenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ScheduleController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colPatient;

    @FXML
    private TableColumn<?, ?> colTherapist;

    @FXML
    private TableColumn<?, ?> colTherapyProgram;

    @FXML
    private TableColumn<?, ?> colTime;

    @FXML
    private AnchorPane contentAnchorPane;

    @FXML
    private TableView<?> tblPatient;

    @FXML
    private TextField txtDate;
    @FXML
    private TextField txtScheduleId;

    @FXML
    private TextField txtPatient;

    @FXML
    private TextField txtTherapist;

    @FXML
    private TextField txtTherapyProgram;

    @FXML
    private TextField txtTime;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void onActionDelete(ActionEvent event) {

    }

    @FXML
    void onActionSave(ActionEvent event) {

    }

    @FXML
    void onActionUpdate(ActionEvent event) {

    }
}
