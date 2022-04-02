package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoLoadable {
	private final String defaultModel = "Boeing 757-200F";
	private final double defaultSpeed = 250;
	private final int defaultRange = 500;
	private final long defaultPrice = 500000;
	private static int idShift = 1;

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

	@Override
	public double getMachSpeed() {
		double machSpeed = (this.getSpeed() * 0.001130332);
		return machSpeed;

	}

	@Override
	protected String generateID() {
		String newId = "";
		StringBuilder sb = new StringBuilder();
		sb.append(((idShift) % 21) + "-");

		for (int i = 1; i < 7; i++) {
			int random = (int) Math.round(Math.random() * (idShift + 3));
			sb.append(((random * (i + idShift)) % 10));
			if (i % 3 == 0 && i != 6) {
				sb.append('-');
			}
		}

//	INCREMENT IDSHIFT	
		idShift++;

//	BUILD NEWID WITH STRINGBUILDER
		newId = sb.toString();
		return newId;
	}

}
