package com.skilldistillery.jets.entities;

import java.util.Scanner;

public class SubMenu {

	public boolean selectJet(String input, AirField airfield) {
		boolean isSelecting = true;
		Jet jet = new PassengerJet();
		for (int i = 0; i < airfield.getJets().size() - 1; i++) {
			if (input.equals(airfield.getJet(i).getModel()) || input.equals(airfield.getJet(i).getID())) {
				jet = airfield.getJet(i);
				isSelecting = false;
			} else if (i < airfield.getJets().size() - 1) {
				continue;
			} else {
				System.out.println("Please select a different Jet");
				break;
			}
		}

		airfield.flyJet(jet);
		return isSelecting;

	}

	void printJetMenu(AirField airfield, Scanner sc) {
		System.out.println("Please type the model or ID Number of the jet you would like to fly: ");
		for (int i = 0; i < airfield.getJets().size() - 1; i++) {
			System.out.println(airfield.getJet(i));
		}
		while (selectJet(sc.nextLine(), airfield)) {
		}

	}

	public Jet newJetMenu(String nextLine) {
		// TODO Auto-generated method stub
		return null;
	}

	public Jet setJetValues(Scanner sc, String model) {
		// TODO Auto-generated method stub
		return null;
	}

	public Jet removeJet(String nextLine) {
		// TODO Auto-generated method stub
		return null;
	}

	public void printJetMenu() {
		System.out.println("-----------------------------------------------");
		System.out.println("| 1. List Jets in Airfield                    |");
		System.out.println("| 2. Fly a Jet                                |");
		System.out.println("| 3. Fly all Jets                             |");
		System.out.println("| 4. View all Jets                            |");
		System.out.println("| 5. Veiw the Fastest Jet                     |");
		System.out.println("| 6. View the Jet with the Longest Range      |");
		System.out.println("| 7. Load all Cargo Jets                      |");
		System.out.println("| 8. Add a Jet to the Airfield                |");
		System.out.println("| 9. Remove a Jet from the Airfield           |");
		System.out.println("| 10. Show Menu                               |");
		System.out.println("| 11. Return to Main Menu                     |");
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
				printJetMenu(airfield, sc);
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
			case "view all":
			case "view fleet":
				airfield.viewAll();
				showMenuOption();
				input = sc.nextLine();
				continue;

			case "5":
			case "view fastest":
			case "view the fastest":
			case "view the fastest jet":
				airfield.viewJet("fastest");
				showMenuOption();
				input = sc.nextLine();
				continue;

			case "6":
			case "view longest":
			case "view longest distance":
			case "view longest fly time":
				airfield.viewJet("longest");
				showMenuOption();
				input = sc.nextLine();
				continue;

			case "7":
			case "load planes":
			case "load cargo":
			case "load cargo planes":
				airfield.loadCargoPlanes();
				showMenuOption();
				input = sc.nextLine();
				continue;

			case "8":
			case "add jet":
			case "add a jet":
				airfield.addJet(sc, this);
				showMenuOption();
				input = sc.nextLine();
				continue;

			case "9":
			case "remove jet":
			case "remove":
			case "remove a jet":
				airfield.removeJet(sc, this);
				showMenuOption();
				input = sc.nextLine();
				continue;
			
			case "10":
			case "menu":
			case "options":
			case "show menu":
				printJetMenu();
				input = sc.nextLine();
				continue;
				

			case "11":
			case "quit":
			case "return":
			case "return to main menu":
				isSelecting = false;
				return isSelecting;
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
				input = airfield.viewPilot(sc, this);
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

			}
		}
		return isSelecting;
	}
	
	private void showMenuOption() {
		System.out.println("(Enter 10 or type \"menu\" to show the menu again)");
	}

}
