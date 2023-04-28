package ma.enset.jeetp2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;

@Document("doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
  @Id
  private String id;
  @Field(name = "name")
  private String name;
  @Field(name = "email")
  private String email;
  @Field(name = "speciality")
  private String speciality;
  @DBRef(lazy = true)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Collection<Appointment> appointments;
}
