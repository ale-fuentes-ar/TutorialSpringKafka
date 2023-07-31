package ale.fuentes.kafka.provider.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    private final Integer ONE_DAY_MILISECOND = 86_400_000;
    private final Integer ONE_GIGABYTE_IN_BYTE = 1_073_741_826;
    private final Integer ONE_MEGABYTE_IN_BYTE = 1_048_576;

    @Value("${tutorialKafka.topic.name}")
    private String NOME_TOPIC_PROPERTY;

    @Bean
    public NewTopic generateTopic() {

        Map<String, String> configTopic = new HashMap<>();

        configTopic.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        configTopic.put(TopicConfig.RETENTION_MS_CONFIG, ONE_DAY_MILISECOND.toString());
        configTopic.put(TopicConfig.SEGMENT_BYTES_CONFIG, ONE_GIGABYTE_IN_BYTE.toString());
        configTopic.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, ONE_MEGABYTE_IN_BYTE.toString());

        return TopicBuilder
                .name(NOME_TOPIC_PROPERTY)
                .partitions(2)
                .replicas(2)
                .configs(configTopic)
                .build();
    }
}
