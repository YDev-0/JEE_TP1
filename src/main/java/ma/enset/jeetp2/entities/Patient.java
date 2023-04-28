package ma.enset.jeetp2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.jeetp2.services.IHospitalService;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Document("patient")
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
  @Id
  private String id;
  private String name;
  @Field(name = "birth_date")
  private LocalDate birthDate;
  private boolean sick;
  private int score;
  private Collection<Appointment> appointments;
}
