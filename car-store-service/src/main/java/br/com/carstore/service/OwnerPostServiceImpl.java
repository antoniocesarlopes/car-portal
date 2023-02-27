package br.com.carstore.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.carstore.data.entity.OwnerPost;
import br.com.carstore.repository.OwnerPostRepository;
import commons.data.dto.OwnerPostDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OwnerPostServiceImpl implements OwnerPostService {

    private final OwnerPostRepository ownerPostRepository;

    @Override
    public void createOwnerPost(OwnerPostDTO ownerPostDTO) {

        OwnerPost ownerPost = new OwnerPost();
        ownerPost.setName(ownerPostDTO.getName());
        ownerPost.setType(ownerPostDTO.getType());
        ownerPost.setContactNumber(ownerPostDTO.getContactNumber());

        ownerPostRepository.save(ownerPost);

    }

	@Override
	public List<OwnerPostDTO> getAllOwners() {
        return ownerPostRepository
        		.findAll()
        		.stream()
        		.map(ownerPost -> mapEntityToDTO(ownerPost))
        		.collect(Collectors.toList());
    }

	@Override
	public void changeOwner(OwnerPostDTO ownerPostDTO, Long ownerId) {
		ownerPostRepository.findById(ownerId).ifPresentOrElse(ownerPost -> {
			ownerPost.setName(ownerPostDTO.getName());
			ownerPost.setType(ownerPostDTO.getType());
			ownerPost.setContactNumber(ownerPostDTO.getContactNumber());

			ownerPostRepository.save(ownerPost);
		}, () -> {
			throw new NoSuchElementException();
		});
	}
	
	@Override
	public void deleteOwner(Long ownerId) {
		ownerPostRepository.deleteById(ownerId);
		
	}
	
	private OwnerPostDTO mapEntityToDTO(OwnerPost ownerPost) {
		return OwnerPostDTO.builder()
				.name(ownerPost.getName())
				.type(ownerPost.getType())
				.contactNumber(ownerPost.getContactNumber())
				.build();
	}

}

