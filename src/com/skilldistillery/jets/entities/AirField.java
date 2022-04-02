package com.skilldistillery.jets.entities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {
	private List<Jet> jets = new ArrayList<>();

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
		Jet tempJet = jets.get(0);
		if (selection.equals("fastest")) {
			for (Jet jet : jets) {
				if (jet.getSpeed() > tempJet.getSpeed()) {
					tempJet = jet;
				}
			}
			System.out.println(tempJet);

		} else if (selection.equals("longest")) {
			for (Jet jet : jets) {
				if (jet.getRange() > tempJet.getRange()) {
					tempJet = jet;
				}
			}
			System.out.println(tempJet);

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
		System.out.println("Do you want to create a (1)Fighter Jet, a (2)Cargo Plane or a (3)Passenger Jet?");
		Jet jetType = submenu.newJetSwitch(sc.nextLine().toLowerCase());
		System.out.println("Do you want to use the (1)default values for the remaining fields, or (2)set them?");
		jetType = submenu.setJetValues(sc, sc.nextLine().toLowerCase(), jetType);
		
		jets.add(jetType);
	}

	public void removeJet(Scanner sc, SubMenu submenu) {
		System.out.println("Which jet would you like to remove? (please enter the ID)");
		list();
		Jet removeMe = submenu.selectJet(sc.nextLine().toLowerCase(), this, sc);
		for (int index = 0; index < jets.size(); index++) {
			if (jets.get(index).equals(removeMe)) {
				jets.remove(jets.get(index));
			}
		}

	}

	public boolean createCopy(String fileName) {
		
		try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
			for (Jet jet : jets) {
				pw.println(jet.getClass().getSimpleName() + "\t" + jet.getModel() 
					+ "\t" + jet.getSpeed() + "\t" + jet.getRange()+ "\t" + jet.getPrice() + "\t" + jet.getPilot().getName());
			}
		} catch (IOException e) {
			System.out.println("There was a problem while writing to " +  fileName);
			return false;
		}
		return true;

	}

	public List<Jet> viewAllPilots(List<Jet> jetsList) {
		
		
		for (int i = 0; i < jetsList.size(); i++) {
			System.out.println(jetsList.get(i).getPilot() + " Pilots: " 
					+ jetsList.get(i).getModel() + " ID: " + jetsList.get(i).getID());
		}
		
		return jetsList;

	}

	public void viewPilot(Jet jet) {
		System.out.println(jet.getPilot());
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


}
