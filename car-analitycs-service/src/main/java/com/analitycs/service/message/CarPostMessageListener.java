package com.analitycs.service.message;

import java.util.logging.Logger;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.analitycs.service.PostAnalyticsService;

import commons.data.dto.CarPostCreationDTO;
import commons.util.Constantes.GROUP_ID;
import commons.util.Constantes.TOPICS;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CarPostMessageListener {
	
	private Logger logger = Logger.getLogger(CarPostMessageListener.class.getName());
	
    private final PostAnalyticsService postAnalyticsService;

    @KafkaListener(topics = TOPICS.CAR_POST, groupId = GROUP_ID.ANALYTICS_POST)
    public void listening(@Payload CarPostCreationDTO carPost) {

    	logger.info("ANALYTICS DATA - Received Car Post information: " + carPost);
        postAnalyticsService.saveDataAnalytics(carPost);
    }

}

