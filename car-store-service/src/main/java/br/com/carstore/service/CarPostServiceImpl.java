package br.com.carstore.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.carstore.data.entity.CarPost;
import br.com.carstore.repository.CarPostRepository;
import br.com.carstore.repository.OwnerPostRepository;
import commons.data.dto.CarPostCreationDTO;
import commons.data.dto.CarPostDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarPostServiceImpl implements  CarPostService {

    private final CarPostRepository carPostRepository;

    private final OwnerPostRepository ownerPostRepository;

    @Override
    public void newPostDetails(CarPostCreationDTO carPostDTO) {
        carPostRepository.save(mapDtoToEntity(carPostDTO));
    }

    @Override
    public List<CarPostDTO> getCarSales() {
        return carPostRepository
        		.findAll()
        		.stream()
        		.map(carPost -> mapEntityToDTO(carPost))
        		.collect(Collectors.toList());
    }

    @Override
	public void changeCarSale(CarPostDTO carPostDTO, Long postId) {

		carPostRepository.findById(postId).ifPresentOrElse(carPost -> {
			carPost.setDescription(carPostDTO.getDescription());
			// carPost.setContact(carPostDTO.getContact());
			carPost.setPrice(carPostDTO.getPrice());
			carPost.setBrand(carPostDTO.getBrand());
			carPost.setEngineVersion(carPostDTO.getEngineVersion());
			carPost.setModel(carPostDTO.getModel());

			carPostRepository.save(carPost);

		}, () -> {
			throw new NoSuchElementException();
		});
	}

    @Override
    public void deleteCarSale(Long postId) {
        carPostRepository.deleteById(postId);
    }

	private CarPost mapDtoToEntity(CarPostCreationDTO carPostDTO) {
		CarPost carPost = new CarPost();

		ownerPostRepository.findById(carPostDTO.getOwnerId())
		.ifPresentOrElse(owner -> {
			carPost.setOwnerPost(owner);
		}, () -> {
			throw new RuntimeException();
		});

		carPost.setModel(carPostDTO.getModel());
		carPost.setBrand(carPostDTO.getBrand());
		carPost.setPrice(carPostDTO.getPrice());
		carPost.setCity(carPostDTO.getCity());
		carPost.setDescription(carPostDTO.getDescription());
		carPost.setEngineVersion(carPostDTO.getEngineVersion());
		carPost.setCreateDate(LocalDateTime.now());

		return carPost;
	}

    private CarPostDTO mapEntityToDTO(CarPost carPost){

        return CarPostDTO.builder()
                .brand(carPost.getBrand())
                .city(carPost.getCity())
                .model(carPost.getModel())
                .description(carPost.getDescription())
                .engineVersion(carPost.getEngineVersion())
                .createDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(carPost.getCreateDate()))
                .ownerName(carPost.getOwnerPost().getName())
                .price(carPost.getPrice()).build();
        
    }

}