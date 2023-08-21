package com.krvinay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krvinay.entity.MovieEntity;

public interface MovieRespository extends JpaRepository<MovieEntity, Long>{

	Optional<MovieEntity> findByName(String name);
}
