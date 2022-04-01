package com.skilldistillery.jets.entities;

import java.util.Objects;

public abstract class Jet {
	private final String ID = generateID();
	private int idShift = 1;
	private String model;
	private double speed;
	private int range;
	private long price;
	
	
	public abstract void fly();
	
	public String getModel() {
		return model;
	}
	
	
	private String generateID() {
		String newId = "";
		StringBuilder sb = new StringBuilder();
		sb.append(((idShift + 1) % 10) + "-");
		

		for (int i = 1; i < 10; i++) {
			int random = (int)Math.round(Math.random() * (idShift + 3));
				sb.append(((random * (i + idShift)) % 10));	
				if (i % 3 == 0 && i != 9) {
					sb.append('-');
				}
		}
		
//	INCREMENT IDSHIFT	
		idShift++;
		
//	BUILD NEWID WITH STRINGBUILDER
		newId = sb.toString();
		return newId;
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
		return "Jet [ID: " + ID + " | Model: " + model + " | Speed: " + speed + " | Range: " + range + "| Price: " + price + "]";
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
