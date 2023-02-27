package br.com.carstore.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carstore.service.OwnerPostService;
import commons.data.dto.CarPostDTO;
import commons.data.dto.OwnerPostDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class OwnerPostController {

	private final OwnerPostService ownerPostService;
	
	@PostMapping(
			consumes = { MediaType.APPLICATION_JSON_VALUE  },
			produces = { MediaType.APPLICATION_JSON_VALUE  })
	@Operation(summary = "Adiciona vendedor",
	description = "Adiciona o vendedor/proprietário do carro",
	tags = {"Vendedor"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200"
					),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
			)
    public ResponseEntity<?> createOwner(@RequestBody OwnerPostDTO ownerPostDTO){
        ownerPostService.createOwnerPost(ownerPostDTO);
        return ResponseEntity.ok().build();
    }

	@GetMapping(
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(summary = "Lista os Vendedores", description = "Recupera todos os vendedores/proprietários",
	tags = {"Vendedor"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = {
							@Content(
									mediaType = MediaType.APPLICATION_JSON_VALUE,
									array = @ArraySchema(schema = @Schema(implementation = OwnerPostDTO.class))
									)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
			)
	public ResponseEntity<List<OwnerPostDTO>> getAllOwners() {
		return ResponseEntity.ok(ownerPostService.getAllOwners());
	}
	
	@PutMapping(value = "/{id}")
	@Operation(summary = "Atualiza um vendedor",
	description = "Atualiza um vendedor/proprietário através do seu identificador único",
	tags = {"Vendedor"},
	responses = {
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
			)
	public ResponseEntity<?> changeOwner(@RequestBody OwnerPostDTO ownerPostDTO, @PathVariable("id") String id){
		ownerPostService.changeOwner(ownerPostDTO, Long.valueOf(id));
        return ResponseEntity.ok().build();
    }
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remove um vendedor",
	description = "Remove um vendedor/proprietário através do seu identificador único",
	tags = {"Vendedor"},
	responses = {
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
			)
	public ResponseEntity<?> deleteOwner(@PathVariable("id") String id){
		ownerPostService.deleteOwner(Long.valueOf(id));
        return ResponseEntity.ok().build();
    }
	
}
