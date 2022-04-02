package com.skilldistillery.jets.entities;

import java.util.Scanner;

public class MainMenu {
	private SubMenu submenu = new SubMenu();

	public void printMenu() {
		System.out.println("-----------------------------------------------");
		System.out.println("|                Select a Number              |");
		System.out.println("| 1. View Jet Menu     |   4. Show Menu       |");
		System.out.println("| 2. DOGFIIIIIGHT!!    |   5. Print a Copy    |");
		System.out.println("| 3. Hire a new Pilot  |   6. Quit            |");
		System.out.println("-----------------------------------------------");

	}

	public boolean menuSwitch(AirField airfield, String input, Scanner sc) {
		boolean isSelecting = true;
		switch (input) {

		case "1":
		case "jet menu":
		case "view jet menu":
			submenu.printJetMenu();
			while (submenu.jetMenuSwitch(airfield, sc.nextLine(), sc))
				;
			printMenu();
			break;

		case "2":
		case "dogfight":
		case "dogfiiiiiight!!":
		case "fight":
		case "fight!":
			airfield.dogfight();
			printMenu();
			break;

		case "3":
		case "hire pilot":
		case "new pilot":
		case "hire new pilot":
			airfield.hirePilot(sc, submenu);
			printMenu();
			break;

		case "4":
		case "menu":
		case "options":
		case "show menu":
			printMenu();
			break;

		case "5":
		case "print":
		case "create copy":
		case "print to file":
		case "copy":
			System.out.println("What is the name of the file? (Please do not use the name jets.txt)");
			String fileName = sc.nextLine();
			if (airfield.createCopy(fileName)) {
				System.out.println("Printed to: " + fileName);
			}
			printMenu();
			break;

		case "6":
		case "quit":
		case "done":
		case "finished":
			isSelecting = false;
			return isSelecting;

		default:
			System.out.print("Invalid Option, please enter a valid option: ");

		}

		return isSelecting;

	}

}
