package liga.medical.queuelistener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.mapper.DebugMapper;
import liga.medical.mapper.ExceptionMapper;
import liga.medical.model.MessageType;
import liga.medical.model.RabbitMessageDto;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {

    private final ObjectMapper objectMapper;

    private final DebugMapper debugMapper;

    private final ExceptionMapper exceptionMapper;

    public LoggingService(ObjectMapper objectMapper, DebugMapper debugMapper, ExceptionMapper exceptionMapper) {
        this.objectMapper = objectMapper;
        this.debugMapper = debugMapper;
        this.exceptionMapper = exceptionMapper;
    }

    public void routeMessage(String message) {
        try {
            RabbitMessageDto rabbitMessageDto = objectMapper.readValue(message, RabbitMessageDto.class);
            MessageType messageType = MessageType.valueOf(rabbitMessageDto.getType());

            switch (messageType) {
                case DAILY:
                case ALERT:
                    debugMapper.addMessageWith(message);
                    break;
                default:
                    exceptionMapper.addMessageWith(message);
            }
        } catch (Exception exception) {
            try {
                exceptionMapper.addMessageWith(message);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
