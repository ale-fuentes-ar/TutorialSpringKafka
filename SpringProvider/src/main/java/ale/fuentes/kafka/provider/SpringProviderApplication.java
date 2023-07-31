package ale.fuentes.kafka.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringProviderApplication {

	// only for test
	@Value("${tutorialKafka.topic.name}")
	private String NOME_TOPIC_PROPERTY;

	public static void main(String[] args) {
		SpringApplication.run(SpringProviderApplication.class, args);
	}

	@Bean
	CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate){
		return args -> {
			kafkaTemplate.send(NOME_TOPIC_PROPERTY, "This message is a example. For do listen");
		};
	}

}
