package br.com.carportal.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

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
public class CarPostDTO {

	private String model;
	private String brand;
	private String price;
	private String description;
	private String engineVersion;
	private String city;
	private String createDate;
	private Long ownerId;
	private String ownerName;
	private String ownerType;
	private String contact;
	
}