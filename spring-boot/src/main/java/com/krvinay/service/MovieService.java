package com.krvinay.service;

import java.util.List;

import com.krvinay.dto.MovieDto;
import com.krvinay.entity.MovieEntity;

public interface MovieService {
	
	MovieDto add(MovieDto movie);
	List<MovieDto> gets();
	MovieDto get(Long id);
	MovieDto update(MovieDto movie);
	void delete(Long id);
	
}
