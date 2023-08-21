package com.krvinay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@Table(name = "movie")
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable = false,unique = true)
    private String name;
	
	@Column(name = "description", nullable = false)
    private String description;
	
	@Column(name = "artist", nullable = false)
    private String artist;
	
	@Column(name = "email", nullable = false,unique = true)
	@Email
    private String email;
   

}
