package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.BattleReady;
import com.skilldistillery.jets.entities.CargoLoadable;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.MainMenu;
import com.skilldistillery.jets.entities.PassengerJet;
import com.skilldistillery.jets.entities.Pilot;
import com.skilldistillery.jets.entities.SubMenu;

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
		while ((isRunning = menu.menuSwitch(airfield, sc.nextLine().toLowerCase(), sc, this)));

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

	public void loadCargoPlanes() {
		for (Jet jet : airfield.getJets()) {
			if (jet instanceof CargoLoadable) {
				boolean cargoIsReady = ((CargoLoadable) jet).readyCargo();
				if (cargoIsReady) {
					((CargoLoadable) jet).loadup();
				}
			}
		}

	}

	public void dogfight() {
		for (Jet jet : airfield.getJets()) {
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
		Jet jetType = submenu.newJetSwitch(sc);
		System.out.println("Do you want to use the (1)default values for the remaining fields, or (2)set them?");
		jetType = submenu.setJetValues(sc, sc.nextLine().toLowerCase(), jetType);

		airfield.addJet(jetType);
	}

	public boolean createCopy(String fileName) {

		try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
			for (Jet jet : airfield.getJets()) {
				pw.println(jet.getClass().getSimpleName() + "\t" + jet.getModel() + "\t" + jet.getSpeed() + "\t"
						+ jet.getRange() + "\t" + jet.getPrice() + "\t" + jet.getPilot().getName());
			}
		} catch (IOException e) {
			System.out.println("There was a problem while writing to " + fileName);
			return false;
		}
		return true;

	}

	public void hirePilot(Scanner sc, SubMenu submenu) {
		Pilot toHire = new Pilot();
		Pilot[] pilotArr = new Pilot[5];
		for (int i = 0; i < 5; i++) {
			pilotArr[i] = new Pilot();
		}

		System.out.println("Which pilot do you want to hire?\n");

		for (int i = 0; i < pilotArr.length; i++) {
			System.out.println((i + 1) + ": " + pilotArr[i]);
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

		System.out.println("Select the jet you want to hire them for\n");
		submenu.printSelectJetMenu(airfield);
		Jet pilotOut = submenu.selectJet(airfield, sc);

		for (Jet jet : airfield.getJets()) {
			if (pilotOut.equals(jet)) {
				jet.setPilot(toHire);
			}
		}

	}

}
