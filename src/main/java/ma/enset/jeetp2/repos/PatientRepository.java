package ma.enset.jeetp2.repos;

import ma.enset.jeetp2.entities.Patient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends MongoRepository<Patient, String> {
  List<Patient> findBySick(boolean sick);
  List<Patient> findBySick(boolean sick, Pageable pageable);

  List<Patient> findBySickAndScoreLessThan(boolean sick, int score);
  List<Patient> findBySickIsTrueAndScoreLessThan(int score);
  List<Patient> findByBirthDateBetween(Date date1, Date date2);

  @Query("{'birth_date': {$gt: ?0, $lt: ?1}}")
  List<Patient> chercherPatient(Date d1, Date d2);

  @Query("{$or:  [{'name':  ?0}, {'name':  ?1}]}")
  List<Patient> chercherPatientParNom(String n1, String n2);
}
