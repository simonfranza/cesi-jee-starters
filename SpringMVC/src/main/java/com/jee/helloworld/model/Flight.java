package com.jee.helloworld.model;

public class Flight {
	private String id;
	private String city;
	private long price;
	private String traveller;

	public Flight () {
	}

	public Flight (String pCity, long pPrice, String pTraveller) {
		city = pCity;
		price = pPrice;
		traveller = pTraveller;
	}

	public void update(Flight pFlight) {
		if (this.equals(pFlight)) {
			return;
		}

		if (!pFlight.getCity().isEmpty()) {
			this.setCity(pFlight.getCity());
		}
		if (pFlight.getPrice() > 0) {
			this.setPrice(pFlight.getPrice());
		}
		if (!pFlight.getTraveller().isEmpty()) {
			this.setTraveller(pFlight.getTraveller());
		}
	}

	public String getId () {
		return id;
	}

	public void setId (String pId) {
		id = pId;
	}

	public String getCity () {
		return city;
	}

	public void setCity (String pCity) {
		city = pCity;
	}

	public long getPrice () {
		return price;
	}

	public void setPrice (long pPrice) {
		price = pPrice;
	}

	public String getTraveller () {
		return traveller;
	}

	public void setTraveller (String pTraveller) {
		traveller = pTraveller;
	}
}
