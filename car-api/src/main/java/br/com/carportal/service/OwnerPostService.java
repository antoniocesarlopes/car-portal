package br.com.carportal.service;

import org.springframework.stereotype.Service;

import br.com.carportal.data.dto.OwnerPostDTO;

@Service
public interface OwnerPostService {
	
	void createOwnerCar(OwnerPostDTO ownerPost);
	
}
