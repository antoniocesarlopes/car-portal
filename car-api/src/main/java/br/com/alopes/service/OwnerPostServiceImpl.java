package br.com.alopes.service;

import org.springframework.stereotype.Service;

import br.com.alopes.client.CarPostStoreClient;
import br.com.alopes.data.dto.OwnerPostDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OwnerPostServiceImpl implements OwnerPostService {
	
	private final CarPostStoreClient carPostStoreClient;

	@Override
	public void createOwnerCar(OwnerPostDTO ownerPost) {
		carPostStoreClient.createOwnerPostClient(ownerPost);
	}

}
