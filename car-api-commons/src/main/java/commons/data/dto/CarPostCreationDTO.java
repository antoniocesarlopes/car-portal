package commons.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
@SuppressWarnings("unused")
@JsonPropertyOrder({"model", "brand", "price", "description", "engineVersion", "city", "createDate", "ownerId"})
public class CarPostCreationDTO {

	private String model;
	private String brand;
	private Double price;
	private String description;
	private String engineVersion;
	private String city;
	private String createDate;
	private Long ownerId;
	
}
