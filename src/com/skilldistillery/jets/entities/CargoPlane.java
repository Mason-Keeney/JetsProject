package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoLoadable {
	private final String defaultModel = "Boeing 757-200F";
	private final double defaultSpeed = 250;
	private final int defaultRange = 500;
	private final long defaultPrice = 500000;
	
	
	public CargoPlane() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void loadup() {
		System.out.println("The last of the cargo is loaded into the " + this.getModel());
		
	}

	@Override
	public boolean readyCargo() {
		// someday, i might do something fun with this code
		return true;
	}

	@Override
	public void fly() {
		System.out.println("A deep vibration fills the air as the " + this.getModel() + " passes overhead.");
		
	}
	@Override
	protected void setDefaultValues() {
		this.setModel(defaultModel);
		this.setSpeed(defaultSpeed);
		this.setRange(defaultRange);
		this.setPrice(defaultPrice);
	}

}
