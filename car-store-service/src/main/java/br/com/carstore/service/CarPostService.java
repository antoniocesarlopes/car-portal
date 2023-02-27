package br.com.carstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import commons.data.dto.CarPostCreationDTO;
import commons.data.dto.CarPostDTO;

@Service
public interface CarPostService {

    void newPostDetails(CarPostCreationDTO carPostDTO);

    List<CarPostDTO> getCarSales();

    void changeCarSale(CarPostDTO carPostDTO, Long postId);

    void deleteCarSale(Long postId);

}

