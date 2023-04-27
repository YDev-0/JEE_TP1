package ma.enset.jeetp2;

import ma.enset.jeetp2.entities.*;
import ma.enset.jeetp2.repos.AppointmentRepository;
import ma.enset.jeetp2.repos.ConsultationRepository;
import ma.enset.jeetp2.repos.DoctorRepository;
import ma.enset.jeetp2.repos.PatientRepository;
import ma.enset.jeetp2.services.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JeeTp2Application {


  public static void main(String[] args) {
    SpringApplication.run(JeeTp2Application.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(IHospitalService iHospitalService) {
    return args -> {
      // Clear database
      iHospitalService.deleteAll();

      addPatients(iHospitalService);
      addDoctors(iHospitalService);
      addAppointments(iHospitalService);
      addConsultations(iHospitalService);

//      System.out.println(iHospitalService.getDoctorById(iHospitalService.getAllAppointments().get(0).getDoctor().getId()));
      System.out.println(iHospitalService.getAllAppointments().get(0).getDoctor());
    };
  }

  // filling database
  private static void addPatients(IHospitalService iHospitalService) {
    for (int i = 0; i < 5; i++) {
      Calendar cal = Calendar.getInstance();
      int days = 0;
      if(Math.random() > 0.5)
        days = (int) (Math.random() * 4) + 1;
      else
        days = (int) ((Math.random() * 23) + 1) * -1;
      cal.add(Calendar.DAY_OF_MONTH, days);
      Patient patient = new Patient();
      patient.setName("patient " + (i + 1));
      patient.setBirthDate(LocalDate.ofInstant(cal.toInstant(), cal.getTimeZone().toZoneId()));
      patient.setSick(Math.random() > 0.5);
      patient.setScore((int) Math.random() * 100);
      iHospitalService.savePatient(patient);
    }
  }

  private static void addDoctors(IHospitalService iHospitalService) {
    for (int i = 0; i < 5; i++) {
      String speciality = Math.random() < 0.3 ? "Cardio" : Math.random() > 0.7 ? "Dentist" : "Generalist";
      Doctor doctor = new Doctor();
      doctor.setName("doctor " + (i + 1));
      doctor.setEmail("doctor" + (i + 1) + "@email.ma");
      doctor.setSpeciality(speciality);
      iHospitalService.saveDoctor(doctor);
    }
  }

  private static void addAppointments(IHospitalService iHospitalService) {
    // random status
    AppointmentStatus status;
      status = Math.random() < 0.3 ? AppointmentStatus.CANCELED : Math.random() < 0.7 ? AppointmentStatus.DONE : AppointmentStatus.PENDING;

    // random patient and doctor
    List<Patient> patients = iHospitalService.getAllPatients();
    List<Doctor> doctors = iHospitalService.getAllDoctors();

    Appointment appointment = new Appointment();
    appointment.setDate(new Date());
    appointment.setStatus(status);
    appointment.setPatient(patients.get((int) Math.random() * patients.size()));
    appointment.setDoctor(doctors.get((int) Math.random() * doctors.size()));

    iHospitalService.saveAppointment(appointment);
  }

  private static void addConsultations(IHospitalService iHospitalService) {
    List<Appointment> appointments = iHospitalService.getAllAppointments();
    Consultation consultation = new Consultation();
    consultation.setAppointment(appointments.get(0));

    // random date
    Calendar cal = Calendar.getInstance();
    int days = 0;
    if(Math.random() > 0.5)
      days = (int) (Math.random() * (Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH) - Calendar.DAY_OF_MONTH)) + 1;
    else
      days = (int) (Math.random() * (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - 1) + 1) * -1;
    cal.add(Calendar.DAY_OF_MONTH, days);
    consultation.setDate(LocalDate.ofInstant(cal.toInstant(), cal.getTimeZone().toZoneId()));

    consultation.setReport("Consultation report ....");

    iHospitalService.saveConsultation(consultation);
  }

  private static void devide() {
    System.out.println("\n------------------------------------------------------------------------------------");
  }
}
