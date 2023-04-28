package ma.enset.jeetp2.repos;

import ma.enset.jeetp2.entities.Appointment;
import ma.enset.jeetp2.entities.Doctor;
import ma.enset.jeetp2.entities.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
  Collection<Appointment> findAllByDoctor(Doctor doctor);
  Collection<Appointment> findAllByPatient(Patient patient);
}
