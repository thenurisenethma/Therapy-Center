package org.example.therapycenter.bo.custom;

import org.example.therapycenter.dto.PatientDTO;

import java.util.ArrayList;
import java.util.List;

public interface PatientBO extends SuperBO {
    String getNextPatientId();

    boolean savePatient(PatientDTO patientDTO);

    ArrayList<PatientDTO> getAllPatients();

    boolean updatePatient(PatientDTO patientDTO);

    boolean deletePatient(String patientId);

    List<PatientDTO> searchPatient(String searchText);
}