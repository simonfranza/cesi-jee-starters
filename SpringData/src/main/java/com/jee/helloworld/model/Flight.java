package com.jee.helloworld.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String city;
	private float price;

	@OneToMany
	@JoinTable(
			name = "Booking",
			joinColumns = @JoinColumn( name = "traveller_id" ),
			inverseJoinColumns = @JoinColumn( name = "flight_id" )
	)
	private List<Booking> bookings = new ArrayList<>();

	public Flight(String pCity, float pPrice) {
		city = pCity;
		price = pPrice;
	}
}
