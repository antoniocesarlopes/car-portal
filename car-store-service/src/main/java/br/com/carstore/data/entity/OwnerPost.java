package br.com.carstore.data.entity;

import java.util.List;

import commons.data.entity.TypeOwner;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "owner_post")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnerPost {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="owner_post_sequence")
	@SequenceGenerator(name="owner_post_sequence", sequenceName="owner_post_seq", allocationSize = 10)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "type", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private TypeOwner type;
	
	@Column(name = "contact_number", nullable = false, length = 20)
	private String contactNumber;
	
	@OneToMany(mappedBy="ownerPost", fetch = FetchType.LAZY)
	private List<CarPost> carPost;

}
