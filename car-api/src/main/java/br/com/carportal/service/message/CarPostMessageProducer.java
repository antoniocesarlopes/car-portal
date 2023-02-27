package br.com.carportal.service.message;

import java.util.logging.Logger;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import commons.data.dto.CarPostCreationDTO;
import commons.data.dto.CarPostDTO;
import commons.util.Constantes.TOPICS;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CarPostMessageProducer {
	
	private Logger logger = Logger.getLogger(CarPostMessageProducer.class.getName());
	
	private final KafkaTemplate<String, CarPostCreationDTO> carPostKafkaTemplate;
	
	public void sendMessage(CarPostCreationDTO carPostDTO) {
		logger.info("CAR POST MESSAGE ::: Enviando o anúncio do carro para fila...");
		carPostKafkaTemplate.send(TOPICS.CAR_POST, carPostDTO);
	}

}
