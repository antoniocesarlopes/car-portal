package br.com.alopes.service;

import org.springframework.stereotype.Service;

import br.com.alopes.data.dto.OwnerPostDTO;

@Service
public interface OwnerPostService {
	
	void createOwnerCar(OwnerPostDTO ownerPost);
	
}
