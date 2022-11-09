package liga.medical.queuelistener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitRouterListener {

    private final LoggingService loggingService;

    public RabbitRouterListener(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @RabbitListener(queues = QueueNames.DAILY_QUEUE_NAME)
    public void receiveAndRedirectDailyMessage(String message) {
        loggingService.routeMessage(message);
    }

    @RabbitListener(queues = QueueNames.ALERT_QUEUE_NAME)
    public void receiveAndRedirectAlertMessage(String message) {
        loggingService.routeMessage(message);
    }

    @RabbitListener(queues = QueueNames.ERROR_QUEUE_NAME)
    public void receiveAndRedirectErrorMessage(String message) {
        loggingService.routeMessage(message);
    }

    @RabbitListener(queues = QueueNames.COMMON_MONITORING_QUEUE_NAME)
    public void receiveAndRedirectCommonMessage(String message) {
        loggingService.routeMessage(message);
    }

}
