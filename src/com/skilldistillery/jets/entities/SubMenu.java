package com.skilldistillery.jets.entities;

import java.util.Scanner;

public class SubMenu {

	public Jet selectJet(AirField airfield, Scanner sc) {
		boolean isSelecting = true;
		int numberOfJets = airfield.getJets().size();
		Jet tempJet = new PassengerJet();
		String in = sc.nextLine();

		while (isSelecting) {

			for (int i = 0; i < numberOfJets; i++) {

				if (in.equals((i + 1 + "")) || in.equals(airfield.getJet(i).getID())) {
					tempJet = airfield.getJet(i);
					isSelecting = false;
					break;

				} else if (i < numberOfJets - 1) {
					continue;

				} else {
					System.out.println("Please select a different Jet");
					in = sc.nextLine();
					continue;
				}
			}
		}

		return tempJet;

	}

	void printSelectJetMenu(AirField airfield) {
		for (int i = 0; i < airfield.getJets().size(); i++) {
			System.out.println((i + 1) + ": " + airfield.getJet(i));

			if (i != (airfield.getJets().size() - 1)) {
				System.out.println();
			}
		}

	}

	public Jet newJetSwitch(Scanner sc) {
		Jet jet = new PassengerJet();
		String input = sc.nextLine().toLowerCase();
		boolean isSelecting = true;
		while (isSelecting) {

			switch (input) {

			case "1":
			case "fighter jet":
			case "fighter":
			case "fighterjet":
				jet = new FighterJet();
				isSelecting = false;
				break;
			case "2":
			case "cargo plane":
			case "cargo":
			case "cargoplane":
				jet = new CargoPlane();
				isSelecting = false;
				break;
			case "3":
			case "passenger jet":
			case "passenger":
			case "passengerjet":
				jet = new PassengerJet();
				isSelecting = false;
				break;
			default:
				System.out.println("Invalid Selection, please choose a valid Jet");
				input = sc.nextLine();

			}
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
		System.out.println("-----------------------------------------------------------------");
		System.out.println("|                          Select an Option                     |");
		System.out.println("| 1. List Jets in Airfield         |    6. Load all Cargo Jets  |");
		System.out.println("| 2. Fly a Jet                     |    7. Add a Jet            |");
		System.out.println("| 3. Fly all Jets                  |    8. Remove a Jet         |");
		System.out.println("| 4. Veiw the Fastest              |    9. Show Menu            |");
		System.out.println("| 5. View the highest Range        |    10. Return to Main Menu |");
		System.out.println("-----------------------------------------------------------------");
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
				System.out.println("Which jet would you like to fly? (Enter the ID number)");
				printSelectJetMenu(airfield);
				Jet jet = selectJet(airfield, sc);
				jet.fly();
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

	private void showMenuOption() {
		System.out.println("(Enter 9 or type \"menu\" to show the menu again)");
	}

}
