package com.skilldistillery.jets.entities;

import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> jets;
	
	

	public List<Jet> getJets() {
		return jets;
	}

	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}
	public Jet getJet(int index) {
		return jets.get(index);
	}
	
	public boolean addJet(Jet jet) {
	
		return (jets.add(jet)); 
		
	}

	public void viewJet(String selection) {
		if (selection.equals("fastest")) {
			
		} else if (selection.equals("longest")) {
			
		}
		
	}

	public void flyAll() {
		// TODO Auto-generated method stub
		
	}

	public void flyJet(Jet jet) {
		jet.fly();
		
	}

	public void list() {
		// TODO Auto-generated method stub
		
	}

	public void loadCargoPlanes() {
		// TODO Auto-generated method stub
		
	}

	public void dogfight() {
		// TODO Auto-generated method stub
		
	}

	public void addJet() {
		// TODO Auto-generated method stub
		
	}

	public void removeJet() {
		// TODO Auto-generated method stub
		
	}

	public void createCopy() {
		// TODO Auto-generated method stub
		
	}

	public void viewPilots() {
		// TODO Auto-generated method stub
		
	}

	public void viewAllPilots() {
		// TODO Auto-generated method stub
		
	}

	public void hirePilot() {
		// TODO Auto-generated method stub
		
	}

	public void viewAll() {
		// TODO Auto-generated method stub
		
	}
}
