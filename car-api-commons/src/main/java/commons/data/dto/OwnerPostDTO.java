package commons.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import commons.data.entity.TypeOwner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class OwnerPostDTO {
	
	private String name;
	private TypeOwner type;
	private String contactNumber;

}
