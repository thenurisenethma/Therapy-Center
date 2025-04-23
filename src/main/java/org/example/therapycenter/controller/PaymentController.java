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

public class PaymentController implements Initializable {

    @FXML
    private Button btnInvoice;

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
    private TableView<?> tblPatient;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtPatient;

    @FXML
    private TextField txtStatus;

    @FXML
    private TextField txtTherapyProgram;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void onActionInvoice(ActionEvent event) {

    }

    @FXML
    void onActionSave(ActionEvent event) {

    }

}
