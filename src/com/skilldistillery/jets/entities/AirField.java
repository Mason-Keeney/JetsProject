package com.skilldistillery.jets.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {
	private List<Jet> jets;
	private MainMenu menu = new MainMenu();

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
		for (Jet jet : jets) {
			jet.fly();
		}

	}

	public void flyJet(Jet jet) {
		jet.fly();

	}

	public void list() {

		for (Jet jet : jets) {
			System.out.println(jet);
		}

	}

	public void loadCargoPlanes() {
		for (Jet jet : jets) {
			if (jet instanceof CargoLoadable) {
				boolean cargoIsReady = ((CargoLoadable) jet).readyCargo();
				if (cargoIsReady) {
					((CargoLoadable) jet).loadup();
				}
			}
		}

	}

	public void dogfight() {
		for (Jet jet : jets) {
			if (jet instanceof BattleReady) {
				boolean readyToFight = ((BattleReady) jet).loadoutIsReady();
				if (readyToFight) {
					((BattleReady) jet).fight();
				}
			}
		}

	}

	public void addJet(Scanner sc, SubMenu submenu) {
		System.out.println("Do you want to create a Fighter Jet, a Cargo Plane or a Passenger Jet?");
		Jet jetType = submenu.newJetMenu(sc.nextLine());
		System.out.println("What is the model name of the jet?");
		jetType.setModel(sc.nextLine());
		System.out.println("Do you want to use the default values for the remaining fields, or set them?");
		jetType = submenu.setJetValues(sc, jetType.getModel());
		
		jets.add(jetType);
	}

	public void removeJet(Scanner sc, SubMenu submenu) {
		System.out.println("Which jet would you like to remove?");
		list();
		Jet removeMe = submenu.removeJet(sc.nextLine());
		for (int index = 0; index < jets.size(); index++) {
			if (jets.get(index).equals(removeMe)) {
				jets.remove(jets.get(index));
			}
		}

	}

	public void createCopy() {
		// TODO Auto-generated method stub

	}

	public List<Jet> viewAllPilots(List<Jet> jetsList) {
		
		
		for (int i = 0; i < jetsList.size(); i++) {
			System.out.println(jetsList.get(i).getPilot() + " Pilots: " 
					+ jetsList.get(i).getModel() + " ID: " + jetsList.get(i).getID());
		}
		
		return jetsList;

	}

	public String viewPilot(Scanner sc, SubMenu submenu) {
		

		submenu.printPilotMenu();
		return sc.nextLine();

	}

	public String hirePilot(Scanner sc, SubMenu submenu) {
		Pilot toHire = new Pilot();
		Pilot[] pilotArr = new Pilot[5];
		for (int i = 0; i < 5; i++) {
			pilotArr[i] = new Pilot();
		}
		
		System.out.println("Which pilot do you want to hire?");
		
		for (int i = 0; i < pilotArr.length; i++) {
			System.out.println((i+1) + ": " + pilotArr[i]);
		}
		
		int input = sc.nextInt();
		switch (input) {
		case 1:
			toHire = pilotArr[0];
			break;
		case 2:
			toHire = pilotArr[1];
			break;
		case 3: 
			toHire = pilotArr[2];
			break;
		case 4:
			toHire = pilotArr[3];
			break;
		case 5:
			toHire = pilotArr[4];
		}
		sc.nextLine();
		
		System.out.println("Type the ID of the jet you want to hire them for");
		List<Jet> replaceArr = viewAllPilots(jets);
		
		String pilotOut = sc.nextLine();
		for (int i = 0; i < replaceArr.size(); i++) {
			if ( pilotOut.equals( replaceArr.get(i).getID() ) ) {
				replaceArr.get(i).setPilot(toHire);
			}
			
			
		}
		
		submenu.printPilotMenu();
		return sc.nextLine();
		

	}

	public void viewAll() {
		// TODO Auto-generated method stub

	}
}
