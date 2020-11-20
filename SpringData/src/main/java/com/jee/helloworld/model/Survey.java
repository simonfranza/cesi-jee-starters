package com.jee.helloworld.model;

import com.jee.helloworld.utils.DateStringConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Convert(converter = DateStringConverter.class)
	private String date;
	private String country;
	private Float magnitude;
}