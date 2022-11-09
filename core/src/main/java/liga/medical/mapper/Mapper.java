package liga.medical.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.model.Exception;
import liga.medical.model.Info;

public interface Mapper {
    void addMessage(Info info);

    void addMessageWith(String message) throws JsonProcessingException;
}
