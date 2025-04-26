package org.example.therapycenter.dao.impl;

import org.example.therapycenter.bo.exception.NotFoundException;
import org.example.therapycenter.configuration.FactoryConfiguration;
import org.example.therapycenter.dao.custom.PatientDAO;
import org.example.therapycenter.entity.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientDAOImpl implements PatientDAO {
    private final FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();


    @Override
    public String getNextId() {
        Session session = factoryConfiguration.getSession();
        String lastId = session.createQuery("SELECT p.id FROM Patient p ORDER BY p.id DESC", String.class)
                .setMaxResults(1)
                .uniqueResult();
        session.close();
        if (lastId != null) {
            int nextId = Integer.parseInt(lastId.substring(1)) + 1;
            return String.format("P%03d", nextId);
        } else {
            return "P001";
        }
    }

    @Override
    public ArrayList<String> getAllPatientNames() {
        return null;
    }

    @Override
    public String getPatientNameById(String patientId) {
        return "";
    }

    @Override
    public String getPatientIdByName(String selectedPatientName) {
        return "";
    }


    @Override
    public Optional<Patient> findByPK(String patientId) {
        return Optional.empty();
    }

    @Override
    public boolean save(Patient patient) {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(patient);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Patient> getAll() {
        Session session = factoryConfiguration.getSession();
        List<Patient> patientList = session.createQuery("FROM Patient", Patient.class).list();
        session.close();
        return patientList;
    }


    @Override
    public boolean update(Patient patient) {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try{
            session.merge(patient);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }finally {
            if(session != null){
                session.close();
            }
        }    }

    @Override
    public boolean delete(String patientId) {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Patient patient = session.get(Patient.class,patientId);
            if(patient == null){
                throw new NotFoundException("Patient not found");
            }

            session.remove(patient);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }finally {
            if(session != null){
                session.close();
            }
        }    }

    @Override
    public List<Patient> search(String searchText) {
        Session session = factoryConfiguration.getSession();
        List<Patient> patients;

        try{
            patients = session.createQuery(
                            "FROM Patient p WHERE " +
                                    "p.id LIKE :searchText OR " +
                                    "p.name LIKE :searchText OR " +
                                    "p.contact LIKE :searchText OR " +
                                    "CAST(p.contact AS string) LIKE :searchText",
                            Patient.class)
                    .setParameter("searchText", "%" + searchText + "%")
                    .getResultList();
        }finally {
            session.close();
        }
        return patients;
    }
}
