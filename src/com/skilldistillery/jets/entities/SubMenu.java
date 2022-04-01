package com.skilldistillery.jets.entities;

import java.util.Scanner;

public class SubMenu {
	

	public boolean selectJet(String input, AirField airfield) {
		boolean isSelecting = true;
		Jet jet = new PassengerJet();
		for (int i = 0; i < airfield.getJets().size() -1; i++) {
			if (input.equals(airfield.getJet(i).getModel()) || input.equals(airfield.getJet(i).getID())) {
				jet = airfield.getJet(i);
				isSelecting = false;
			} else if (i < airfield.getJets().size() -1){
				continue;
			}
			else {
				System.out.println("Please select a different Jet");
				break;
			}
		}
		
		
		airfield.flyJet(jet);
		return isSelecting;
		
	}

	void printJetMenu(AirField airfield, Scanner sc) {
		System.out.println("Please type the model or ID Number of the jet you would like to fly: ");
		for (int i = 0; i < airfield.getJets().size() -1; i++) {
			System.out.println(airfield.getJet(i));
		}
		while(selectJet(sc.nextLine(), airfield)) {}
		
	}

	public void jetOrPilot(AirField airfield) {
		// TODO
		
	}

	public void flyOrFlyAll(AirField airfield) {
		// TODO Auto-generated method stub
		
	}

	public void viewMenu(AirField airfield) {
		// TODO Auto-generated method stub
		
	}

	

}
