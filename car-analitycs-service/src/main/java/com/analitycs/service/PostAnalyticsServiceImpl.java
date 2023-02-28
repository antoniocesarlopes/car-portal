package com.analitycs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analitycs.data.entity.BrandAnalyticsEntity;
import com.analitycs.data.entity.CarModelAnalyticsEntity;
import com.analitycs.data.entity.CarModelPriceEntity;
import com.analitycs.repository.BrandAnalyticsRepository;
import com.analitycs.repository.CarModelAnalyticsRepository;
import com.analitycs.repository.CarPriceAnalyticsRepository;

import commons.data.dto.CarPostCreationDTO;

@Service
public class PostAnalyticsServiceImpl implements PostAnalyticsService{

    @Autowired
    private BrandAnalyticsRepository brandAnalyticsRepository;

    @Autowired
    private CarModelAnalyticsRepository carModelAnalyticsRepository;

    @Autowired
    private CarPriceAnalyticsRepository carPriceAnalyticsRepository;

    @Override
    public void saveDataAnalytics(CarPostCreationDTO carPostDTO) {
        saveBrandAnalytics(carPostDTO.getBrand());
        saveCarModelAnalytics(carPostDTO.getModel());
        saveCarModelPriceAnalytics(carPostDTO.getModel(),carPostDTO.getPrice());
    }

    private void saveBrandAnalytics(String brand){

        BrandAnalyticsEntity brandAnalyticsEntity = new BrandAnalyticsEntity();

        brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse(item->{
            item.setPosts(item.getPosts()+1);
            brandAnalyticsRepository.save(item);
        }, ()-> {
            brandAnalyticsEntity.setBrand(brand);
            brandAnalyticsEntity.setPosts(1L);
            brandAnalyticsRepository.save(brandAnalyticsEntity);
        });

    }

    private void saveCarModelAnalytics(String carModel){

        CarModelAnalyticsEntity carModelAnalyticsEntity = new CarModelAnalyticsEntity();

        carModelAnalyticsRepository.findByModel(carModel).ifPresentOrElse(item->{
            item.setPosts(item.getPosts()+1);
            carModelAnalyticsRepository.save(item);
        }, ()-> {
            carModelAnalyticsEntity.setModel(carModel);
            carModelAnalyticsEntity.setPosts(1L);
            carModelAnalyticsRepository.save(carModelAnalyticsEntity);
        });

    }

    private void saveCarModelPriceAnalytics(String carModel, Double price){

        CarModelPriceEntity carModelPriceEntity = new CarModelPriceEntity();

        carModelPriceEntity.setModel(carModel);
        carModelPriceEntity.setPrice(price);
        carPriceAnalyticsRepository.save(carModelPriceEntity);

    }

}
