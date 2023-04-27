package ma.enset.jeetp2.repos;

import ma.enset.jeetp2.entities.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
}
