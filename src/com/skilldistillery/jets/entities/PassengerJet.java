package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet {
	private final String defaultModel = "Boeing 747";
	private final double defaultSpeed = 250;
	private final int defaultRange = 1000;
	private final long defaultPrice = 450000;
	
	
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
	
	@Override
	protected void setDefaultValues() {
		this.setModel(defaultModel);
		this.setSpeed(defaultSpeed);
		this.setRange(defaultRange);
		this.setPrice(defaultPrice);
	}
}
