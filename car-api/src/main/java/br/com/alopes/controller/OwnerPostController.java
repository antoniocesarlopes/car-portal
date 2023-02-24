package br.com.alopes.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alopes.data.dto.OwnerPostDTO;
import br.com.alopes.service.OwnerPostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/owner")
@RequiredArgsConstructor
public class OwnerPostController {

	private final OwnerPostService ownerPostService;
	
	@PostMapping(
			consumes = { MediaType.APPLICATION_JSON_VALUE  },
			produces = { MediaType.APPLICATION_JSON_VALUE  })
	@Operation(summary = "Adiciona o dono da postagem",
	description = "Adiciona o dono da postagem",
	tags = {"Anunciante"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200"
					),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
			)
	public ResponseEntity<?> create(@RequestBody OwnerPostDTO ownerPostDTO) {
		ownerPostService.createOwnerCar(ownerPostDTO);
		return ResponseEntity.ok().build();
	}
	
}
