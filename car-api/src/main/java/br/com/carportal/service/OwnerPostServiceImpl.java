package br.com.carportal.service;

import org.springframework.stereotype.Service;

import br.com.carportal.client.CarPostStoreClient;
import br.com.carportal.data.dto.OwnerPostDTO;
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
