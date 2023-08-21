package com.krvinay.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Schema(
		description = "Movie DTO Information"
)
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

//this is only for xml it is optional
//@XmlRootElement
//@JsonIgnoreProperties({"description","email"})//ignoring fields in response
public class MovieDto {
	
	private long id;
	
	@Schema(description = "Movie Name")
	@NotEmpty
    private String name;
	
	@Schema(description = "Movie description")
	//@JsonProperty("desc")//response filtering
    private String description;
	@Schema(description = "Movie artist name")
    private String artist;
	//@JsonIgnore//ignore in response
	@Schema(description = "emailadderss")
    private String email;
}
