package br.com.carportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import commons.data.dto.OwnerPostDTO;

@Service
public interface OwnerPostService {
	
	void createOwnerCar(OwnerPostDTO ownerPost);

	List<OwnerPostDTO> getAllOwners();

	void changeOwner(OwnerPostDTO ownerPostDTO, String id);

	void deleteOwner(Long ownerId);
	
}
