package gpbdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Document("requests")
public class Request {
  @Id
  private long id;
  private String text;
  @Field
  private long modifiedDate;
  @Field
  private long length;
  @Field("tags")
  private List<Tag> tagList;
  @Field
  private Folder folder;

  public Request(String text, long modifiedDate, long length, List<Tag> tagList, Folder folder) {
    this.text = text;
    this.modifiedDate = modifiedDate;
    this.length = length;
    this.tagList = tagList;
    this.folder = folder;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Request request = (Request) o;
    return id == request.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
