package com.skilldistillery.jets.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.MainMenu;
import com.skilldistillery.jets.entities.PassengerJet;

public class JetsApplication {

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.run();
		

	}
	public void run() {
		boolean isRunning;
		MainMenu menu = new MainMenu();
		Scanner sc = new Scanner(System.in);
		AirField airfield = new AirField();
		List<Jet> jets = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			jets.add(new PassengerJet());
		}
		airfield.setJets(jets);
		
		menu.printMenu();
		while( (isRunning = menu.menuSwitch(airfield, sc.nextLine().toLowerCase(), sc)) ) {}
		if(!isRunning) {
			sc.close();
		}
		
	}
}
