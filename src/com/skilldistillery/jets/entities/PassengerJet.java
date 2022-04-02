package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet {

	
	
	public PassengerJet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PassengerJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		System.out.println("I'm flying!");
	}
}
