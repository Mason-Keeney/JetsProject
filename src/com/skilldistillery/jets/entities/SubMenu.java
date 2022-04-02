package com.skilldistillery.jets.entities;

import java.util.Scanner;

public class SubMenu {

	public Jet selectJet(String input, AirField airfield, Scanner sc) {
		boolean isSelecting = true;
		Jet jet = new PassengerJet();
		while (isSelecting) {

			for (int i = 0; i < airfield.getJets().size() - 1; i++) {
				if (input.equals(airfield.getJet(i).getModel()) || input.equals(airfield.getJet(i).getID())) {
					jet = airfield.getJet(i);
					isSelecting = false;
				} else if (i < airfield.getJets().size() - 1) {
					continue;
				} else {
					System.out.println("Please select a different Jet");
					input = sc.nextLine();
					continue;
				}
			}
		}

		return jet;

	}

	void printSelectJetMenu(AirField airfield, Scanner sc) {
		System.out.println("Please type the model or ID Number of the jet you would like to fly: ");
		for (int i = 0; i < airfield.getJets().size() - 1; i++) {
			System.out.println(airfield.getJet(i));
		}

	}

	public Jet newJetSwitch(String input) {
		Jet jet;
		switch (input) {
		case "1":
		case "fighter jet":
		case "fighter":
		case "fighterjet":
			jet = new FighterJet();
		case "2":
		case "cargo plane":
		case "cargo":
		case "cargoplane":
			jet = new CargoPlane();
		case "3":
		case "passenger jet":
		case "passenger":
		case "passengerjet":
			jet = new PassengerJet();
		default:
			jet = new PassengerJet();
		}
		
		
		return jet;
	}

	public Jet setJetValues(Scanner sc, String input, Jet jet) {
		if (input.equals("default") || input.equals("yes") || input.equals("1")) {
			jet.setDefaultValues();
		} else {
			System.out.println("What would is the model name of the jet you are entering?");
			jet.setModel(sc.nextLine());
			System.out.println("What is it's speed in Miles Per Hour?");
			jet.setSpeed(sc.nextDouble());
			sc.nextLine();
			System.out.println("What is it's range in miles?");
			jet.setRange(sc.nextInt());
			sc.nextLine();
			System.out.println("What is the price?");
			jet.setPrice(sc.nextLong());
			sc.nextLine();
		}
		return jet;
	}

	public void printJetMenu() {
		System.out.println("-----------------------------------------------");
		System.out.println("| 1. List Jets in Airfield                    |");
		System.out.println("| 2. Fly a Jet                                |");
		System.out.println("| 3. Fly all Jets                             |");
		System.out.println("| 4. Veiw the Fastest Jet                     |");
		System.out.println("| 5. View the Jet with the Longest Range      |");
		System.out.println("| 6. Load all Cargo Jets                      |");
		System.out.println("| 7. Add a Jet to the Airfield                |");
		System.out.println("| 8. Remove a Jet from the Airfield           |");
		System.out.println("| 9. Show Menu                                |");
		System.out.println("| 10. Return to Main Menu                     |");
		System.out.println("-----------------------------------------------");
	}

	public boolean jetMenuSwitch(AirField airfield, String input, Scanner sc) {
		boolean isSelecting = true;
		while (isSelecting) {

			switch (input) {

			case "1":
			case "list all":
			case "list":
			case "in airfield":
				airfield.list();
				showMenuOption();
				input = sc.nextLine();
				continue;

			case "2":
			case "fly a jet":
			case "fly that jet":
			case "fly jet":
				System.out.println("Which jet would you like to fly?");
				printSelectJetMenu(airfield, sc);
				Jet jet = selectJet(sc.nextLine(), airfield, sc);
				airfield.flyJet(jet);
				showMenuOption();
				input = sc.nextLine();
				continue;

			case "3":
			case "fly all":
			case "fly jets":
				airfield.flyAll();
				showMenuOption();
				input = sc.nextLine();
				continue;

			case "4":
			case "view fastest":
			case "view the fastest":
			case "view the fastest jet":
				airfield.viewJet("fastest");
				showMenuOption();
				input = sc.nextLine();
				continue;

			case "5":
			case "view longest":
			case "view longest distance":
			case "view longest fly time":
				airfield.viewJet("longest");
				showMenuOption();
				input = sc.nextLine();
				continue;

			case "6":
			case "load planes":
			case "load cargo":
			case "load cargo planes":
				airfield.loadCargoPlanes();
				showMenuOption();
				input = sc.nextLine();
				continue;

			case "7":
			case "add jet":
			case "add a jet":
				airfield.addJet(sc, this);
				showMenuOption();
				input = sc.nextLine();
				continue;

			case "8":
			case "remove jet":
			case "remove":
			case "remove a jet":
				airfield.removeJet(sc, this);
				showMenuOption();
				input = sc.nextLine();
				continue;

			case "9":
			case "menu":
			case "options":
			case "show menu":
				printJetMenu();
				input = sc.nextLine();
				continue;

			case "10":
			case "quit":
			case "return":
			case "return to main menu":
				isSelecting = false;
				return isSelecting;
				
			default:
				System.out.print("Invalid Option, please enter a valid option: ");
				input = sc.nextLine();
			}
		}
		return isSelecting;

	}

	public void printPilotMenu() {
		System.out.println("-----------------------------------------------");
		System.out.println("| 1. View a Jet's Pilot                      |");
		System.out.println("| 2. View all current Pilots                 |");
		System.out.println("| 3. Hire a Pilot                            |");
		System.out.println("| 4. Return to Main Menu                     |");
		System.out.println("-----------------------------------------------");
	}

	public boolean pilotMenuSwitch(AirField airfield, String input, Scanner sc) {
		boolean isSelecting = true;

		while (isSelecting) {
			switch (input) {

			case "1":
			case "view a pilot":
			case "view pilot":
				System.out.println("Which jet's pilot do you want to view details on?");
				printSelectJetMenu(airfield, sc);
				Jet jet = selectJet(sc.nextLine(), airfield, sc);
				airfield.viewPilot(jet);
				input = sc.nextLine();
				continue;

			case "2":
			case "view all pilots":
			case "view pilots":
				airfield.viewAllPilots(airfield.getJets());
				input = sc.nextLine();
				continue;

			case "3":
			case "hire pilot":
			case "new pilot":
			case "hire new pilot":
				input = airfield.hirePilot(sc, this);
				continue;

			case "4":
			case "quit":
			case "return":
			case "return to main menu":
				isSelecting = false;
				return isSelecting;
				
			default:
				System.out.print("Invaild Option, please enter a valid option: ");
				input = sc.nextLine();

			}
		}
		return isSelecting;
	}


	private void showMenuOption() {
		System.out.println("(Enter 9 or type \"menu\" to show the menu again)");
	}

}
