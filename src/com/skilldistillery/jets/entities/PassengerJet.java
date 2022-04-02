package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet {
	private final String defaultModel = "Boeing 747";
	private final double defaultSpeed = 250;
	private final int defaultRange = 1000;
	private final long defaultPrice = 450000;
	private static int idShift = 1;

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
		System.out.println("You hear it in the distance, a low rumble. The " + this.getModel() + " passes.");
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
