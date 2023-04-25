package ma.enset.jeetp2;

import ma.enset.jeetp2.entities.Patient;
import ma.enset.jeetp2.repos.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JeeTp2Application implements CommandLineRunner {
  @Autowired
  private PatientRepository m_patientRepos;

  public static void main(String[] args) {
    SpringApplication.run(JeeTp2Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    m_patientRepos.deleteAll();
    for (int i = 0; i < 100; i++) {
      Calendar cal = Calendar.getInstance();
      int days = 0;
      if(Math.random() > 0.5)
        days = (int) (Math.random() * 4) + 1;
      else
        days = (int) ((Math.random() * 23) + 1) * -1;
      cal.add(Calendar.DAY_OF_MONTH, days);
      m_patientRepos.save(new Patient(null, ("patient " + (i + 1)), LocalDate.ofInstant(cal.toInstant(), cal.getTimeZone().toZoneId()), Math.random() > 0.5, (int) (Math.random() * 100)));
    }

    System.out.println("List of patients :");
    List<Patient> patients = m_patientRepos.findAll();

    patients.forEach(p -> {
      System.out.println(p);
    });

    devide();

    System.out.println("Find patient by id :");
    String id = m_patientRepos.findAll().get(0).getId();
    try {
      Patient p = m_patientRepos.findById(id).orElseThrow(() -> new RuntimeException("Patient with id " + id + " not found."));
      System.out.println(p);

      // edit
      devide();
      System.out.println("Edit patient :");
      p.setScore(870);
      m_patientRepos.save(p);
      System.out.println(p);

      // delete
      devide();
      System.out.println("Delete patient with id: " + id);
      m_patientRepos.deleteById(id);
      patients = m_patientRepos.findAll();
      patients.forEach(_p -> {
        System.out.println(_p);
      });


      // find by birth date
      devide();
      patients = m_patientRepos.findByBirthDateBetween(new Date(), new Date());
      if(patients.isEmpty())
        System.out.println("Nothing found !");
      else patients.forEach(_p -> System.out.println(_p));

      // test custom method
      devide();
      Calendar cal = Calendar.getInstance();
      cal.add(Calendar.DAY_OF_MONTH, -2);
      patients = m_patientRepos.chercherPatient(cal.getTime(), new Date());
      patients.forEach(_p -> {
        System.out.println(_p);
      });

      devide();
      System.out.println("Search by name: patient 2 or patient 5 :");
      m_patientRepos.chercherPatientParNom("patient 2", "patient 5").forEach(_p -> {
        System.out.println(_p);
      });
    } catch(Exception e) {
      System.err.println(e.getMessage());
    }
  }

  private static void devide() {
    System.out.println("\n------------------------------------------------------------------------------------");
  }
}
