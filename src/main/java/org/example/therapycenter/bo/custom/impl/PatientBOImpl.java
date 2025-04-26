package org.example.therapycenter.bo.custom.impl;

import org.example.therapycenter.bo.custom.PatientBO;
import org.example.therapycenter.dao.custom.PatientDAO;
import org.example.therapycenter.dao.impl.PatientDAOImpl;
import org.example.therapycenter.dto.PatientDTO;
import org.example.therapycenter.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientBOImpl implements PatientBO {
    PatientDAO patientDAO = new PatientDAOImpl();

    @Override
    public String getNextPatientId() {
        return patientDAO.getNextId();
    }


    @Override
    public boolean savePatient(PatientDTO patientDTO) {
        if (patientDTO.getId() == null || patientDTO.getId().isEmpty()) {
            patientDTO.setId(patientDAO.getNextId());
        }

        return patientDAO.save(new Patient(
                patientDTO.getId(),
                patientDTO.getName(),
                patientDTO.getEmail(),
                patientDTO.getContact(),
                new ArrayList<>()
        ));
    }


    @Override
    public ArrayList<PatientDTO> getAllPatients() {
        List<Patient> patients = patientDAO.getAll();
        ArrayList<PatientDTO> patientDTOs = new ArrayList<>();

        for (Patient patient : patients) {
            patientDTOs.add(new PatientDTO(
                    patient.getId(),
                    patient.getName(),
                    patient.getEmail(),
                    patient.getContact()
            ));
        }
        return patientDTOs;

    }

    @Override
    public boolean updatePatient(PatientDTO patientDTO) {
        return patientDAO.update(new Patient(
                patientDTO.getId(),
                patientDTO.getName(),
                patientDTO.getEmail(),
                patientDTO.getContact(),
                new ArrayList<>()
        ));
    }

    @Override
    public boolean deletePatient(String patientId) {
        return patientDAO.delete(patientId);
    }

    @Override
    public List<PatientDTO> searchPatient(String searchText) {
        List<Patient> patients = patientDAO.search(searchText);
        ArrayList<PatientDTO> patientDTOs = new ArrayList<>();

        for (Patient patient : patients) {
            patientDTOs.add(new PatientDTO(
                    patient.getId(),
                    patient.getName(),
                    patient.getEmail(),
                    patient.getContact()
            ));
        }
        return patientDTOs;
    }
}
