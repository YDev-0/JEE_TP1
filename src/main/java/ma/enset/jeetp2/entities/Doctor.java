package ma.enset.jeetp2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.jeetp2.services.IHospitalService;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;

@Document("doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
  @Id
  private String id;
  private String name;
  private String email;
  private String speciality;
  private Collection<Appointment> appointments;
}
