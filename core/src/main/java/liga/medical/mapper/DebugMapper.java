package liga.medical.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.model.Debug;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.UUID;

@Mapper
public interface DebugMapper extends liga.medical.mapper.Mapper {
    final ObjectMapper objectMapper = new ObjectMapper();

    @Insert("insert into debug values(#{uuid},#{system_type_id},#{method_params});")
    void addMessage(Debug debug);


    default void addMessageWith(String message) throws JsonProcessingException {
        Debug debug = objectMapper.readValue(message, Debug.class);
        String uid = UUID.randomUUID().toString();
        Long systemTypeId = debug.getSystemTypeId();
        String description = debug.getMethodParams();
        Debug debug1 = new Debug(uid,systemTypeId,description);
        addMessage(debug1);
    }
}
