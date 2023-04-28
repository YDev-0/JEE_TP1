package ma.enset.jeetp2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document("consultation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {
  @Id
  private String id;
  @Field(name = "date")
  private LocalDate date;
  @Field(name = "report")
  private String report;
  @DocumentReference
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Appointment appointment;
}
