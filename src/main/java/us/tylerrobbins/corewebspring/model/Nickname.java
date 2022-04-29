package us.tylerrobbins.corewebspring.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"nickname", "intimacy"})
@Generated("jsonschema2pojo")
public class Nickname {

  @JsonProperty("nickname")
  private String nickname;
  @JsonProperty("intimacy")
  private Integer intimacy;

  @JsonProperty("nickname")
  public String getNickname() {
    return nickname;
  }

  @JsonProperty("nickname")
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  @JsonProperty("intimacy")
  public Integer getIntimacy() {
    return intimacy;
  }

  @JsonProperty("intimacy")
  public void setIntimacy(Integer intimacy) {
    this.intimacy = intimacy;
  }

}
