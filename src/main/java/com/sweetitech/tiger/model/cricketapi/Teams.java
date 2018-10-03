  package com.sweetitech.tiger.model.cricketapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Teams {

	Team a;
	Team b;
	public Team getA() {
		return a;
	}
	public void setA(Team a) {
		this.a = a;
	}
	public Team getB() {
		return b;
	}
	public void setB(Team b) {
		this.b = b;
	}
	
}
