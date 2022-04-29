package us.tylerrobbins.corewebspring.RESTservice;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import us.tylerrobbins.corewebspring.model.NickNameList;

@Service
public class RestService {

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  ObjectMapper objectMapper;

  @Value("${nickNameApiUri}")
  private String nicknameUri;


  public Optional<NickNameList> getNickNames(String name) {

    // return type is set as text/html
    // get json as string and convert to object with objectMapper

    String nickNamesString = restTemplate.getForObject(nicknameUri, String.class, name);
    NickNameList nickNames;
    try {
      nickNames = objectMapper.readValue(nickNamesString, NickNameList.class);
    } catch (JsonMappingException e) {
      System.out.println("json mapping exception");
      return Optional.empty();
    } catch (JsonProcessingException e) {
      System.out.println("json processing exception");
      return Optional.empty();
    }

    if (nickNames != null) {
      return Optional.of(nickNames);
    } else {
      return Optional.empty();
    }
  }
}
