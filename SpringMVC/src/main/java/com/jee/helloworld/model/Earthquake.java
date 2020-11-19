package com.jee.helloworld.model;

import java.util.UUID;

public class Earthquake {
	private UUID id;
	private String city;
	private String country;
	private String date;
	private Integer intensity;

	public Earthquake () {
	}

	public void update(Earthquake pEarthquake) {
		if (this.equals(pEarthquake)) {
			return;
		}

		if (!pEarthquake.getCity().isEmpty()) {
			this.setCity(pEarthquake.getCity());
		}
		if (!pEarthquake.getCountry().isEmpty()) {
			this.setCountry(pEarthquake.getCountry());
		}
		if (!pEarthquake.getDate().isEmpty()) {
			this.setDate(pEarthquake.getDate());
		}
		if (pEarthquake.getIntensity() > 0 && pEarthquake.getIntensity() < 12) {
			this.setIntensity(pEarthquake.getIntensity());
		}
	}

	public UUID getId () {
		return id;
	}

	public void setId (UUID pId) {
		id = pId;
	}

	public String getCity () {
		return city;
	}

	public void setCity (String pCity) {
		city = pCity;
	}

	public String getCountry () {
		return country;
	}

	public void setCountry (String pCountry) {
		country = pCountry;
	}

	public String getDate () {
		return date;
	}

	public void setDate (String pDate) {
		date = pDate;
	}

	public Integer getIntensity () {
		return intensity;
	}

	public void setIntensity (Integer pIntensity) {
		intensity = pIntensity;
	}
}
