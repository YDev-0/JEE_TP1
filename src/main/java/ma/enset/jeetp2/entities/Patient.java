package ma.enset.jeetp2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.Collection;

@Document("patient")
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
  @Id
  private String id;
  @Field(name = "name")
  private String name;
  @Field(name = "birth_date")
  private LocalDate birthDate;
  @Field(name = "sick")
  private boolean sick;
  @Field(name = "score")
  private int score;
  @DBRef(lazy = true)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Collection<Appointment> appointments;
}
