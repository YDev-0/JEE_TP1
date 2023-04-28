package ma.enset.jeetp2.services;

import ma.enset.jeetp2.entities.Appointment;
import ma.enset.jeetp2.entities.Consultation;
import ma.enset.jeetp2.entities.Doctor;
import ma.enset.jeetp2.entities.Patient;

import java.util.Collection;
import java.util.List;

public interface IHospitalService {
  // get data
  List<Patient> getAllPatients();
  List<Doctor> getAllDoctors();
  List<Appointment> getAllAppointments();
  List<Consultation> getAllConsultations();

  Doctor getDoctorById(String id);

  // save
  Patient savePatient(Patient patient);
  Doctor saveDoctor(Doctor doctor);
  Appointment saveAppointment(Appointment appointment);
  Consultation saveConsultation(Consultation consultation);

  void deleteAll();
}
