package com.skilldistillery.jets.entities;

import java.util.Objects;

public class Pilot {
	private String name = setName();
	private final int yearsOfExperience = setYearsOfExperience();
	private final double salary = setSalary();
	
	private double setSalary() {
		double salaryByYears = 0;
		salaryByYears = 67500 + ((yearsOfExperience * 2) * 4000);
		
		return salaryByYears;
	}

	private int setYearsOfExperience() {
		int randomYears = ((int)(Math.random() * 25) + 1);
		return randomYears;
	}

	public String getName() {
		return name;
	}

	public String setName() {
		String[] names = {"Jeff", "Billybob", "Maverick", "Goose", "Iceman", "Viper", "Wolfman", "Merlin", "Hollywood","Pheonix",
				"Slayer", "Warlock", "Earhart", "Cochran", "Coleman", "Quimby"};
		int randomChoice = (int)(Math.random() * (names.length - 1));
		
		String randomName = names[randomChoice];
		
		
		return randomName;
		
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	
	public double getSalary() {
		
		return salary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, salary, yearsOfExperience);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pilot other = (Pilot) obj;
		return Objects.equals(name, other.name)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary)
				&& yearsOfExperience == other.yearsOfExperience;
	}

	@Override
	public String toString() {
		return "Pilot [Name: " + name + " | Flying for: " + yearsOfExperience + " years | Salary: " + salary + "]";
	}
	
	
}
