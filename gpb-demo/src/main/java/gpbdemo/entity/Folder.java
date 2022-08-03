package gpbdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor

@Document("folders")
public class Folder {
  @Id
  private long id;
  @Field("name")
  private String folderName;

  public Folder(String folderName) {
    this.folderName = folderName;
  }
}
