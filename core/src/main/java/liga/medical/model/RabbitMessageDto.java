package liga.medical.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RabbitMessageDto {

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  private long id;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String type;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String description;

}
