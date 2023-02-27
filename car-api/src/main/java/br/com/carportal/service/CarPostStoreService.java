package br.com.carportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import commons.data.dto.CarPostDTO;

@Service
public interface CarPostStoreService {
	
	List<CarPostDTO> getCarsForSales();
	
	void changeCarForSale(CarPostDTO carPost, String id);
	
	void removeCarForSale(String id);

}
