package br.com.alopes.service.message;

import java.util.logging.Logger;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import br.com.alopes.data.dto.CarPostDTO;
import br.com.alopes.util.Constantes.TOPICS;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CarPostMessageService {
	
	private Logger logger = Logger.getLogger(CarPostMessageService.class.getName());
	
	private final KafkaTemplate<String, CarPostDTO> carPostKafkaTemplate;
	
	public void sendMessage(CarPostDTO carPostDTO) {
		logger.info("CAR POST MESSAGE ::: Enviando a postagem do carro para fila...");
		carPostKafkaTemplate.send(TOPICS.CAR_POST, carPostDTO);
	}

}
