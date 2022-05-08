package com.skilldistillery.jets.entities;

import java.util.Objects;

public abstract class Jet {
	private final String ID = generateID();
	private String model;
	private double speed;
	private int range;
	private long price;
	private Pilot pilot = new Pilot();

	public Jet() {
	}

	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public abstract void fly();

	protected abstract String generateID();

	protected abstract void setDefaultValues();

	public abstract double getMachSpeed();

	public String getModel() {
		return model;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public String getID() {
		return ID;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;

	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ":\t[ID: " + ID + " | Model: " + model + " | Speed: " + speed
				+ " | Range: " + range + " | Price: " + price + "]\n\t" + pilot;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, model, price, range, speed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(model, other.model) && price == other.price
				&& range == other.range && Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed);
	}

}
