package org.example.therapycenter.dao.custom;

import org.example.therapycenter.dao.CrudDAO;
import org.example.therapycenter.entity.Patient;
import java.util.ArrayList;
import java.util.Optional;
public interface PatientDAO extends CrudDAO<Patient> {

    String getNextId();

    ArrayList<String> getAllPatientNames();
    String getPatientNameById(String patientId);
    String getPatientIdByName(String selectedPatientName);
    Optional<Patient> findByPK(String patientId);
}
