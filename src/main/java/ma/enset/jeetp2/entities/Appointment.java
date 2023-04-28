package ma.enset.jeetp2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document("appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
  @Id
  private String id;
  @Field(name = "date")
  private Date date;
  @Field(name = "status")
  private AppointmentStatus status;
  @DocumentReference(collection = "patient")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Patient patient;
  @DocumentReference(collection = "doctor")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Doctor doctor;
  @DocumentReference
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Consultation consultation;
}
