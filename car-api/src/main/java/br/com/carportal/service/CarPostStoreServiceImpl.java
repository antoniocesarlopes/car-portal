package br.com.carportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.carportal.client.CarPostStoreClient;
import commons.data.dto.CarPostDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarPostStoreServiceImpl implements CarPostStoreService {
	
	private final CarPostStoreClient carPostStoreClient;

	@Override
	public List<CarPostDTO> getCarsForSales() {
		return carPostStoreClient.getCarsForSalesClient();
	}

	@Override
	public void changeCarForSale(CarPostDTO carPost, String id) {
		carPostStoreClient.changeCarForSaleClient(carPost, id);
	}

	@Override
	public void removeCarForSale(String id) {
		carPostStoreClient.deleteCarForSaleClient(id);
	}

}
