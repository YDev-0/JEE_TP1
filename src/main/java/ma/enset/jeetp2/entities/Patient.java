package ma.enset.jeetp2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

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

}
