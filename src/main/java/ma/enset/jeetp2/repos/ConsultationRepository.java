package ma.enset.jeetp2.repos;

import ma.enset.jeetp2.entities.Consultation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsultationRepository extends MongoRepository<Consultation, String> {
}
