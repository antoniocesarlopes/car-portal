package com.analitycs.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car_model_analytics")
@Data
@NoArgsConstructor
public class CarModelAnalyticsEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="car_model_analytics_sequence")
	@SequenceGenerator(name="car_model_analytics_sequence", sequenceName="car_model_analytics_seq", allocationSize = 10)
    private Long id;

    private String model;

    private Long posts;

}
