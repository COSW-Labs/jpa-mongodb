package eci.cosw.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
  @Id
  private String id;

  private String name;
  
  public User(String name) {
      this.name = name;
  }

  @Override
  public String toString() {
      return String.format(
              "User[id=%s, name='%s']",
              id, name);
  }

  public String getId() {
      return id;
  }

  public void setId(String id) {
      this.id = id;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }
}
