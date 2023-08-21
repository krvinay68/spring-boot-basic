/**
* This is mannual conversion implementation between Entity to DTO and VICE-VERSa
*/	

package com.krvinay.mapper;

import com.krvinay.dto.MovieDto;
import com.krvinay.entity.MovieEntity;

public class MovieMapper {
	
	//Convert JPA MovieEntity into MovieDto
	public static MovieDto mapToMovieDto(MovieEntity entity) {

	    MovieDto responseDto=new MovieDto(					
	    		entity.getId(),
	    		entity.getName(),
	    		entity.getDescription(),
	    		entity.getArtist(),
	    		entity.getEmail()				
				);	    
		return responseDto;
	}
	
	//Convert MovieDto into JPA MovieEntity 
	public static MovieEntity mapToMovieEntity(MovieDto movieDto) {

		MovieEntity responseEntity=new MovieEntity(					
				movieDto.getId(),
				movieDto.getName(),
				movieDto.getDescription(),
				movieDto.getArtist(),
				movieDto.getEmail()				
			);	    
			return responseEntity;
	}
}
