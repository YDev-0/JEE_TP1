package ma.enset.jeetp2.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.enset.jeetp2.entities.Appointment;
import ma.enset.jeetp2.entities.Consultation;
import ma.enset.jeetp2.entities.Doctor;
import ma.enset.jeetp2.entities.Patient;
import ma.enset.jeetp2.repos.AppointmentRepository;
import ma.enset.jeetp2.repos.ConsultationRepository;
import ma.enset.jeetp2.repos.DoctorRepository;
import ma.enset.jeetp2.repos.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class IHospitalServiceImpl implements IHospitalService {
  private PatientRepository m_patientRepos;
  private DoctorRepository m_doctorRepos;
  private AppointmentRepository m_appointmentRepos;
  private ConsultationRepository m_consultationRepos;

  // get data
  @Override
  public List<Patient> getAllPatients() {
    List<Patient> patients = m_patientRepos.findAll();

    patients.forEach(p -> {
      p.setAppointments(m_appointmentRepos.findAllByPatient(p));
    });

    return patients;
  }
  @Override
  public List<Doctor> getAllDoctors() {
    List<Doctor> doctors = m_doctorRepos.findAll();

    doctors.forEach(d -> {
      d.setAppointments(m_appointmentRepos.findAllByDoctor(d));
    });

    return doctors;
  }
  @Override
  public List<Appointment> getAllAppointments() {
    return m_appointmentRepos.findAll();
  }

  @Override
  public List<Consultation> getAllConsultations() {
    return m_consultationRepos.findAll();
  }

  @Override
  public Doctor getDoctorById(String id) {
    return m_doctorRepos.findById(id).get();
  }

  // save
  @Override
  public Patient savePatient(Patient patient) {
    return m_patientRepos.save(patient);
  }

  @Override
  public Doctor saveDoctor(Doctor doctor) {
    return m_doctorRepos.save(doctor);
  }

  @Override
  public Appointment saveAppointment(Appointment appointment) {
    return m_appointmentRepos.save(appointment);
  }

  @Override
  public Consultation saveConsultation(Consultation consultation) {
    return m_consultationRepos.save(consultation);
  }

  @Override
  public void deleteAll() {
    m_consultationRepos.deleteAll();
    m_appointmentRepos.deleteAll();
    m_patientRepos.deleteAll();
    m_doctorRepos.deleteAll();
  }
}
