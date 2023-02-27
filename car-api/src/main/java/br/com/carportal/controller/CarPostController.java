package br.com.carportal.controller;

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

import br.com.carportal.service.CarPostStoreService;
import br.com.carportal.service.message.CarPostMessageProducer;
import commons.data.dto.CarPostCreationDTO;
import commons.data.dto.CarPostDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
public class CarPostController {

	private final CarPostStoreService carPostStoreService;
	
	private final CarPostMessageProducer carPostMessage;
	
	@GetMapping(value = "/posts",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(summary = "Lista os Carros a venda", description = "Recupera todos os carros a venda",
	tags = {"Carros"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = {
							@Content(
									mediaType = MediaType.APPLICATION_JSON_VALUE,
									array = @ArraySchema(schema = @Schema(implementation = CarPostDTO.class))
									)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
			)
	public ResponseEntity<List<CarPostDTO>> getCarSalles() {
		return ResponseEntity.ok(carPostStoreService.getCarsForSales());
	}
	
	@PostMapping("/posts")
	@Operation(summary = "Adiciona um carro a venda",
	description = "Recebe um carro para venda e envia para fila de mensagens",
	tags = {"Carros"},
	responses = {
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
			)
	public ResponseEntity<?> postCarForSale(@RequestBody CarPostCreationDTO carPostDTO) {
		carPostMessage.sendMessage(carPostDTO);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value = "/{id}")
	@Operation(summary = "Atualiza um carro a venda",
	description = "Atualiza uma postagem de carro a venda através do seu identificador único",
	tags = {"Carros"},
	responses = {
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
			)
	public ResponseEntity<?> changeCarSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id ) {
		carPostStoreService.changeCarForSale(carPostDTO, id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remove um carro a venda",
	description = "Remove uma postagem de carro a venda através do seu identificador único",
	tags = {"Carros"},
	responses = {
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
			)
	public ResponseEntity<?> deleteCarsForSale(String id) {
		carPostStoreService.removeCarForSale(id);
		return ResponseEntity.ok().build();
	}
}
