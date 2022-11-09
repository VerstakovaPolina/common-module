package liga.medical.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Debug extends Info{

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String uuid;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long systemTypeId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String methodParams;
}
