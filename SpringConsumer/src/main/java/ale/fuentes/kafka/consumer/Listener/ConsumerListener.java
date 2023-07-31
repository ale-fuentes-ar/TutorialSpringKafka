package ale.fuentes.kafka.consumer.Listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@Slf4j
public class ConsumerListener {

    @KafkaListener(topics = {"topic-greeting"}, groupId = "group-default-id")
    public void toListen(String message) {
        log.warn("[LISTEN] a new message received : {}", message);
    }
}
