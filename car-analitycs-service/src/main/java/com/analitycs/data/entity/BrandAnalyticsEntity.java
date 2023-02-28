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
@Table(name = "brand_analytics")
@Data
@NoArgsConstructor
public class BrandAnalyticsEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="brand_analytics_sequence")
	@SequenceGenerator(name="brand_analytics_sequence", sequenceName="brand_analytics_seq", allocationSize = 10)
    private Long id;

    private String brand;

    private Long posts;

}
