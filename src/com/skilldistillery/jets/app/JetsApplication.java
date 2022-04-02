package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.MainMenu;
import com.skilldistillery.jets.entities.PassengerJet;

public class JetsApplication {
	private AirField airfield = new AirField();

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.run();

	}

	public void run() {
		boolean isRunning;
		MainMenu menu = new MainMenu();
		Scanner sc = new Scanner(System.in);

		populateAirfield("jets.txt");

		menu.printMenu();
		while ((isRunning = menu.menuSwitch(airfield, sc.nextLine().toLowerCase(), sc))) {
		}
		if (!isRunning) {
			sc.close();
		}

	}

	private void populateAirfield(String fileName) {
		List<Jet> tempJets = new ArrayList<>(5);
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				
				String[] splitComma = line.split(",");
				String model = splitComma[1];
				double speed = Double.parseDouble(splitComma[2]);
				int range = Integer.parseInt(splitComma[3]);
				long price = Long.parseLong(splitComma[4]);

					if (splitComma[0].equals("FighterJet")) {
						tempJets.add(new FighterJet(model, speed, range, price));

					} else if (splitComma[0].equals("CargoPlane")) {
						tempJets.add(new CargoPlane(model, speed, range, price));

					} else if (splitComma[0].equals("PassengerJet")) {
						tempJets.add(new PassengerJet(model, speed, range, price));
					}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Unable to find: " + fileName);
		} catch (IOException e) {
			System.out.println("Problem while reading: " + fileName);
		}
		
		airfield.setJets(tempJets);

	}
}
