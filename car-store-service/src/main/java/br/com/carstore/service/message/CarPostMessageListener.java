package br.com.carstore.service.message;

import java.util.logging.Logger;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.carstore.service.CarPostService;
import commons.data.dto.CarPostCreationDTO;
import commons.util.Constantes.GROUP_ID;
import commons.util.Constantes.TOPICS;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CarPostMessageListener {
	
	private Logger logger = Logger.getLogger(CarPostMessageListener.class.getName());
	
    private final CarPostService carPostService;

    @KafkaListener(topics = TOPICS.CAR_POST, groupId = GROUP_ID.STORE_POST)
    public void listening(@Payload CarPostCreationDTO carPost) {

    	logger.info("CAR STORE - Received Car Post information: " + carPost);
        carPostService.newPostDetails(carPost);
    }

}

