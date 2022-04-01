package com.skilldistillery.jets.entities;

import java.util.Scanner;

public class MainMenu {
	private SubMenu submenu = new SubMenu();

	
	public void printMenu() {
		System.out.println("-----------------------------------------------");
		System.out.println("| 1. List Jets in Airfield                    |");
		System.out.println("| 2. Fly a Jet                                |");
		System.out.println("| 3. Fly all Jets                             |");
		System.out.println("| 4. View all Jets                            |");
		System.out.println("| 5. Veiw the Fastest Jet                     |");
		System.out.println("| 6. View the Jet with the Longest Range      |");
		System.out.println("| 7. Load all Cargo Jets                      |");
		System.out.println("| 8. DOGFIIIIIGHT!!                           |");
		System.out.println("| 9. Add a Jet to the Airfield                |");
		System.out.println("| 10. Remove a Jet from the Airfield          |");
		System.out.println("| 11. Create a copy of the current airfield   |");
		System.out.println("| 12. View a Jet's Pilot                      |");
		System.out.println("| 13. View all current Pilots                 |");
		System.out.println("| 14. Hire a Pilot                            |");
		System.out.println("| 15. Quit                                    |");
		System.out.println("| 16. Show Menu                               |");
		System.out.println("-----------------------------------------------");
		
	}

	
	public boolean menuSwitch(AirField airfield, String input, Scanner sc) {
		boolean isSelecting = true;
		switch (input) {
		
		case "1":
		case "list all":
		case "list": 
		case "in airfield":
			airfield.list();
			showMenuOption();
			break;
			
		case "2":
		case "fly a jet":
		case "fly that jet":
		case "fly jet":
			System.out.println("Which jet would you like to fly?");
			submenu.printJetMenu(airfield, sc);
			showMenuOption();
			break;
			
		case "3":
		case "fly all":
		case "fly jets":
			airfield.flyAll();
			showMenuOption();
			break;
			
		case "4":
		case "view all":
		case "view fleet":
			airfield.viewAll();
			
		case "5":
		case "view fastest":
		case "view the fastest":
		case "view the fastest jet":
			airfield.viewJet("fastest");
			showMenuOption();
			break;
		
		case "6":
		case "view longest":
		case "view longest distance":
		case "view longest fly time":
			airfield.viewJet("longest");
			showMenuOption();
			break;
		
		case "7":
		case "load planes":
		case "load cargo":
		case "load cargo planes":
			airfield.loadCargoPlanes();
			showMenuOption();
			break;
		
		case "8":
		case "dogfight":
		case "dogfiiiiiight!!":
		case "fight":
		case "fight!":
			airfield.dogfight();
			showMenuOption();
			break;
			
		case "9":
		case "add jet":
		case "add a jet":
			airfield.addJet();
			showMenuOption();
			break;
			
		case "10":
		case "remove jet":
		case "remove":
		case "remove a jet":
			airfield.removeJet();
			showMenuOption();
			break;
			
		case "11":
		case "print":
		case "create copy":
		case "print to file":
		case "copy":
			airfield.createCopy();
			showMenuOption();
			break;
			
			
		case "12":
		case "view a pilot":
		case "view pilot":
			airfield.viewPilots();
			showMenuOption();
			break;
			
		case "13":
		case "view all pilots":
		case "view pilots":
			airfield.viewAllPilots();
			showMenuOption();
			break;
			
		case "14":
		case "hire pilot":
		case "new pilot":
		case "hire new pilot":
			airfield.hirePilot();
			showMenuOption();
			break;
			
		case "15":
		case "quit":
		case "done":
		case "finished":
			isSelecting = false;
			return isSelecting;
			
		case "16":
		case "menu":
		case "options":
		case "show menu":
			printMenu();
			break;
			
		case "hire":
		case "add":
			requestClarification(sc, airfield, "hire");
			break;
		case "fly":
			requestClarification(sc, airfield, "fly");
			break;
		case "view":
			requestClarification(sc, airfield, "view");
			break;
	
			
			
		
		
		
			
		}
				
		
		
		
		return isSelecting;
		
	}


	private void requestClarification(Scanner sc, AirField airfield, String needsClarity) {
		switch (needsClarity) {
		case "hire":
			System.out.println("Do you want to add a new jet or a new pilot?");
			submenu.jetOrPilot(airfield);
			break;
		case "fly":
			System.out.println("Do you want to fly all the jets or a specific one?");
			submenu.flyOrFlyAll(airfield);
			break;
		case "view":
			System.out.println("What would you like to view?");
			submenu.viewMenu(airfield);
		}
			
		
	}


	private void showMenuOption() {
		System.out.println("(Press 15 or type \"menu\" to show the menu again)");
	}


}
