package ma.enset.jeetp2.repos;

import ma.enset.jeetp2.entities.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
}
