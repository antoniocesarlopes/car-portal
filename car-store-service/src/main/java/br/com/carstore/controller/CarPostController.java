package br.com.carstore.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carstore.service.CarPostService;
import commons.data.dto.CarPostDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class CarPostController {

	private final CarPostService carPostService;
	
	@GetMapping(value = "/cars",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(summary = "Carros a venda", description = "Recupera todos os carros a venda",
	tags = {"Sales"},
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
	public ResponseEntity<List<CarPostDTO>> getCarSales(){
        return ResponseEntity.ok(carPostService.getCarSales());
    }

	@PutMapping(value = "/car/{id}")
	@Operation(summary = "Atualiza um carro a venda",
	description = "Atualiza uma postagem de carro a venda através do seu identificador único",
	tags = {"Sales"},
	responses = {
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
			)
	public ResponseEntity<?> changeCarSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id){
        carPostService.changeCarSale(carPostDTO, Long.valueOf(id));
        return ResponseEntity.ok().build();
    }

	
	@DeleteMapping(value = "/car/{id}")
	@Operation(summary = "Remove um carro a venda",
	description = "Remove uma postagem de carro a venda através do seu identificador único",
	tags = {"Postagem"},
	responses = {
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
			)
	public ResponseEntity<?> deleteCarSale(@PathVariable("id") String id){
        carPostService.deleteCarSale(Long.valueOf(id));
        return ResponseEntity.ok().build();
    }

}
