package com.jee.helloworld.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@PrimaryKeyJoinColumn(name="flight_id", referencedColumnName="id")
	public Flight flight;
	@ManyToOne
	@PrimaryKeyJoinColumn(name="traveller_id", referencedColumnName="id")
	public Traveller traveller;

	public Booking() {
		flight = new Flight();
		traveller = new Traveller();
	}
}
