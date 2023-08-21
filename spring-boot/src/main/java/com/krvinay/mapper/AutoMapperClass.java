package com.krvinay.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.krvinay.dto.MovieDto;
import com.krvinay.entity.MovieEntity;

@Mapper
public interface AutoMapperClass {	
	
	AutoMapperClass MAPPER=Mappers.getMapper(AutoMapperClass.class);
	
	//Convert JPA MovieEntity into MovieDto
	
	//@Mapping(source="email", target="emailAdress")//use to map if having different field name
	MovieDto mapToMovieDto(MovieEntity entity);
	//Convert MovieDto into JPA MovieEntity 
	MovieEntity mapToMovieEntity(MovieDto movieDto);

}
