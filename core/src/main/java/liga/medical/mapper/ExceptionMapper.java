package liga.medical.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.model.Exception;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.UUID;

@Mapper
public interface ExceptionMapper extends liga.medical.mapper.Mapper {

    final ObjectMapper objectMapper = new ObjectMapper();

    @Insert("insert into debug values(#{uuid},#{system_type_id},#{method_params});")
    void addMessage(Exception exception);


    default void addMessageWith(String message) throws JsonProcessingException {
        Exception exception = objectMapper.readValue(message, Exception.class);
        String uid = UUID.randomUUID().toString();
        Long systemTypeId = exception.getSystemTypeId();
        String description = exception.getMethodParams();
        Exception exception1 = new Exception(uid,systemTypeId,description);
        addMessage(exception1);
    }
}

