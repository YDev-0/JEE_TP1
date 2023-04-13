package ma.enset.jeetp2.repos;

import ma.enset.jeetp2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
