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
public class Traveller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;

	@OneToMany
	@JoinTable(
			name = "Booking",
			joinColumns = @JoinColumn( name = "flight_id" ),
			inverseJoinColumns = @JoinColumn( name = "traveller_id" )
	)
	private List<Booking> bookings = new ArrayList<>();

	public Traveller(String pFirstName, String pLastName) {
		firstName = pFirstName;
		lastName = pLastName;
	}
}
