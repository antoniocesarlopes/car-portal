package br.com.carstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import commons.data.dto.OwnerPostDTO;

@Service
public interface OwnerPostService {

    void createOwnerPost(OwnerPostDTO ownerPostDTO);

    List<OwnerPostDTO> getAllOwners();

	void changeOwner(OwnerPostDTO ownerPostDTO, Long ownerId);
	
	void deleteOwner(Long ownerId);

}

