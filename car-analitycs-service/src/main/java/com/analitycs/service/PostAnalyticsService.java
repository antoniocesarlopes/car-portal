package com.analitycs.service;

import org.springframework.stereotype.Service;

import commons.data.dto.CarPostCreationDTO;

@Service
public interface PostAnalyticsService {

    void saveDataAnalytics(CarPostCreationDTO carPostDTO);

}
