package br.com.alopes.client;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.alopes.data.dto.CarPostDTO;
import br.com.alopes.data.dto.OwnerPostDTO;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CarPostStoreClient {

	@Value("${api.service.user-store.uri}")
	private String USER_STORE_SERVICE_URI;

	@Value("${api.service.post-store.uri}")
	private String POST_STORE_SERVICE_URI;

	private final RestTemplate restTemplate;

	public List<CarPostDTO> getCarsForSalesClient() {
		ResponseEntity<CarPostDTO[]> responseEntity = restTemplate.getForEntity(POST_STORE_SERVICE_URI + "/cars", CarPostDTO[].class);
		return Arrays.asList(Objects.requireNonNullElse(responseEntity.getBody(), new CarPostDTO[] {}));
	}

	public void createOwnerPostClient(OwnerPostDTO newUser) {
		restTemplate.postForEntity(USER_STORE_SERVICE_URI, newUser, OwnerPostDTO.class);
	}

	public void changeCarForSaleClient(CarPostDTO carPostDTO, String id) {
		restTemplate.put(POST_STORE_SERVICE_URI + "/car/" + id, carPostDTO, CarPostDTO.class);
	}

	public void deleteCarForSaleClient(String id) {
		restTemplate.delete(POST_STORE_SERVICE_URI + "/car/" + id);
	}

}
