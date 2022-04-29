package us.tylerrobbins.corewebspring.model;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "gender", "nicknames"})
@Generated("jsonschema2pojo")
public class NickNameList {

  @JsonProperty("name")
  private String name;
  @JsonProperty("gender")
  private String gender;
  @JsonProperty("nicknames")
  private List<Nickname> nicknames = null;

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("gender")
  public String getGender() {
    return gender;
  }

  @JsonProperty("gender")
  public void setGender(String gender) {
    this.gender = gender;
  }

  @JsonProperty("nicknames")
  public List<Nickname> getNicknames() {
    return nicknames;
  }

  @JsonProperty("nicknames")
  public void setNicknames(List<Nickname> nicknames) {
    this.nicknames = nicknames;
  }

}
