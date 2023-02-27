package br.com.carstore.data.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "car_post")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarPost {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="car_post_sequence")
	@SequenceGenerator(name="car_post_sequence", sequenceName="car_post_seq", allocationSize = 10)
	private Long id;
	
	@Column(name = "model", nullable = false, length = 50)
	private String model;
	
	@Column(name = "brand", nullable = false, length = 50)
	private String brand;
	
	@Column(name = "price", nullable = false, length = 7, precision = 2)
	private Double price;
	
	@Column(name = "description", nullable = false, length = 200)
	private String description;
	
	@Column(name = "engine_version", nullable = false, length = 5)
	private String engineVersion;
	
	@Column(name = "city", nullable = false, length = 50)
	private String city;
	
	@Column(name = "createDate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@PastOrPresent
	private LocalDateTime createDate;
	
	@ManyToOne
	@JoinColumn(name = "owner_post_id", nullable = false, referencedColumnName = "id")
	private OwnerPost ownerPost;

}
