package br.com.carportal.config;

import java.util.HashMap;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import commons.data.dto.CarPostCreationDTO;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class CarPostProducerConfig {

	private final KafkaProperties kafkaProperties;
	
	@Bean
	ProducerFactory<String, CarPostCreationDTO> carPostProducerFactory() {
		var configs = new HashMap<String, Object>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
		configs.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configs, new StringSerializer(), new JsonSerializer<>());
	}
	
    @Bean
    KafkaTemplate<String, CarPostCreationDTO> carPostKafkaTemplate(ProducerFactory<String, CarPostCreationDTO> carPostProducerFactory) {
        return new KafkaTemplate<>(carPostProducerFactory);
    }
	
}
