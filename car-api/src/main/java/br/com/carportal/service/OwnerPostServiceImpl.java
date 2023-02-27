package br.com.carportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.carportal.client.CarPostStoreClient;
import commons.data.dto.OwnerPostDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OwnerPostServiceImpl implements OwnerPostService {
	
	private final CarPostStoreClient carPostStoreClient;

	@Override
	public void createOwnerCar(OwnerPostDTO ownerPost) {
		carPostStoreClient.createOwnerPostClient(ownerPost);
	}

	@Override
	public List<OwnerPostDTO> getAllOwners() {
		return carPostStoreClient.getAllOwners();
	}

	@Override
	public void changeOwner(OwnerPostDTO ownerPostDTO, String id) {
		carPostStoreClient.changeOwner(ownerPostDTO, id);
	}

	@Override
	public void deleteOwner(Long ownerId) {
		carPostStoreClient.deleteOwner(ownerId);
	}


}
