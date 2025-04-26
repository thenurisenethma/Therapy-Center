package org.example.therapycenter.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.therapycenter.bo.custom.PatientBO;
import org.example.therapycenter.bo.custom.impl.PatientBOImpl;
import org.example.therapycenter.dto.PatientDTO;
import org.example.therapycenter.dto.tm.PatientTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class PatientController implements Initializable {

    @FXML
    private Button btnAssign;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnPatient;

    @FXML
    private Button btnPayment;

    @FXML
    private Button btnReports;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnScheduling;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnTherapist;

    @FXML
    private Button btnTherapyProgram;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private AnchorPane contentAnchorPane;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private AnchorPane navBarAnchorPane;

    @FXML
    private TableView<PatientTM> tblPatient;

    @FXML
    private TextField txtContact;
    @FXML
    private Button btnReset;
    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSearch;

    PatientBO patientBO = new PatientBOImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        String defaultStyle = "-fx-border-color: yellow; -fx-text-fill: black; -fx-background-color: white; -fx-border-width: 2px;";

        txtName.setStyle(defaultStyle);
        txtEmail.setStyle(defaultStyle);
        txtContact.setStyle(defaultStyle);

        txtSearch.setOnAction(event ->{
        });

        try{
            refreshPage();
        }catch (Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to load patient id").show();
        }

    }

    private void refreshPage() {
        loadNextPatientId();
        loadTableData();

        btnSave.setDisable(false);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);

        txtName.setText("");
        txtEmail.setText("");
        txtContact.setText("");


        String defaultStyle = "-fx-border-color: yellow; -fx-text-fill: black; -fx-background-color: white; -fx-border-width: 2px;";

        txtName.setStyle(defaultStyle);
        txtContact.setStyle(defaultStyle);
        txtEmail.setStyle(defaultStyle);

    }


    private void loadNextPatientId() {
        String nextPatientId = patientBO.getNextPatientId();
        txtId.setText(nextPatientId);
    }

    private void loadTableData() {
        ArrayList<PatientDTO> patientDTOS = patientBO.getAllPatients();
        ObservableList<PatientTM> patientTMS = FXCollections.observableArrayList();

        for(PatientDTO patientDTO : patientDTOS){
            PatientTM patientTM = new PatientTM(
                    patientDTO.getId(),
                    patientDTO.getName(),
                    patientDTO.getEmail(),
                    patientDTO.getContact()
            );
            patientTMS.add(patientTM);
        }
        tblPatient.setItems(patientTMS);
    }

    @FXML
    void clickedTable(MouseEvent event) {
        PatientTM patientTM = tblPatient.getSelectionModel().getSelectedItem();
        if (patientTM != null) {
            txtId.setText(patientTM.getId());
            txtName.setText(patientTM.getName());
            txtEmail.setText(patientTM.getEmail());
            txtContact.setText(String.valueOf(patientTM.getContact()));

            btnSave.setDisable(true);
            btnDelete.setDisable(false);
            btnUpdate.setDisable(false);
        }
    }

    @FXML
    void onActionAssign(ActionEvent event) {

    }

    @FXML
    void onActionDelete(ActionEvent event) {
        String patientId = txtId.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete this Patient?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

            if(optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {
                boolean isDeleted = patientBO.deletePatient(patientId);
                if(isDeleted) {
                    refreshPage();
                    new Alert(Alert.AlertType.INFORMATION, "Patient deleted Successfully").show();
                }else{
                    new Alert(Alert.AlertType.ERROR, "Failed to delete patient").show();
                }
            }
        }

        @FXML
        void onActionReset(ActionEvent event) {
            refreshPage();
        }

    @FXML
    void onActionSave(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String contact = txtContact.getText();

        String namePattern = "^[A-Za-z ]+$";
        String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        String contactPattern = "^(\\d+)||((\\d+\\.)(\\d){2})$";

        boolean hasErrors = false;
        StringBuilder errorMessage = new StringBuilder("Please correct the following errors:\n");

        String errorStyle = "-fx-border-color: red; -fx-text-fill: white; -fx-background-color: transparent;";
        String defaultStyle = "-fx-border-color: green; -fx-text-fill: white; -fx-background-color: transparent;";


        if (name.isEmpty() || !name.matches(namePattern)) {
            txtName.setStyle(errorStyle);
            errorMessage.append("- Name is empty or in an incorrect format\n");
            hasErrors = true;

        }else{
            txtName.setStyle(defaultStyle);
        }
        if (contact.isEmpty() || !contact.matches(contactPattern)) {
            txtContact.setStyle(errorStyle);
            errorMessage.append("- empty or in an incorrect format\n");
            hasErrors = true;

        }else{
            txtContact.setStyle(defaultStyle);
        }

        if (email.isEmpty() || !email.matches(emailPattern)) {
            txtEmail.setStyle(errorStyle);
            errorMessage.append("- Email is empty or in an incorrect format\n");
            hasErrors = true;

        }else{
            txtEmail.setStyle(defaultStyle);
        }


        if (hasErrors) {
            new Alert(Alert.AlertType.ERROR, errorMessage.toString()).show();
            return;
        }

        boolean isSaved = patientBO.savePatient(new PatientDTO(id , name  , email , contact));
        if (isSaved) {
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Patient saved successfully!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to save patient!").show();
        }

    }


    @FXML
    void onActionSearch(ActionEvent event) {
        try{
            searchPatient();
        }catch (Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error searching patient").show();
        }
    }
    private void searchPatient () {
        String searchText = txtSearch.getText().trim();

        patientBO.searchPatient(searchText);

        if(searchText.isEmpty()){
            loadTableData();
            return;
        }
        List<PatientDTO> patientDTOS = patientBO.searchPatient(searchText);
        ObservableList<PatientTM> patientTMS = FXCollections.observableArrayList();

        for(PatientDTO patientDTO : patientDTOS){
            PatientTM patientTM = new PatientTM(
                    patientDTO.getId(),
                    patientDTO.getName(),
                    patientDTO.getEmail(),
                    patientDTO.getContact()
            );
            patientTMS.add(patientTM);
        }
        tblPatient.setItems(patientTMS);

    }

    @FXML
    void onActionUpdate(ActionEvent event){
        String id = txtId.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String contact = txtContact.getText();

        String namePattern = "^[A-Za-z ]+$";
        String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        boolean hasErrors = false;
        StringBuilder errorMessage = new StringBuilder("Please correct the following errors:\n");

        String errorStyle = "-fx-border-color: red; -fx-text-fill: black; -fx-background-color: white;-fx-border-width: 2px;";
        String defaultStyle = "-fx-border-color: green; -fx-text-fill: black; -fx-background-color: white;-fx-border-width: 2px;";


        if (name.isEmpty() || !name.matches(namePattern)) {
            txtName.setStyle(errorStyle);
            errorMessage.append("- Name is empty or in an incorrect format\n");
            hasErrors = true;

        }else{
            txtName.setStyle(defaultStyle);
        }
        if (contact.isEmpty()) {
            txtContact.setStyle(errorStyle);
            errorMessage.append("- contact is empty\n");
            hasErrors = true;

        }else{
            txtContact.setStyle(defaultStyle);
        }
        if (email.isEmpty() || !email.matches(emailPattern)) {
            txtEmail.setStyle(errorStyle);
            errorMessage.append("- Email is empty or in an incorrect format\n");
            hasErrors = true;

        }else{
            txtEmail.setStyle(defaultStyle);
        }

        if (hasErrors) {
            new Alert(Alert.AlertType.ERROR, errorMessage.toString()).show();
            return;
        }

        boolean isUpdated = patientBO.updatePatient(new PatientDTO(id , name  , email ,contact ));
        if (isUpdated) {
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Patient updated successfully!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to update patient!").show();
        }
    }


}
