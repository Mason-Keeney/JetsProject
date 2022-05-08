package com.skilldistillery.jets.entities;

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
			System.out
					.println("It is capable of " + Math.round(tempJet.getMachSpeed() * 100) + "% the speed of sound\n");

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

	public void list() {

		for (Jet jet : jets) {
			System.out.println(jet);
		}

	}

	public void removeJet(Scanner sc, SubMenu submenu) {
		System.out.println("Which jet would you like to remove?");
		submenu.printSelectJetMenu(this);
		Jet removeMe = submenu.selectJet(this, sc);
		for (int index = 0; index < jets.size(); index++) {
			if (jets.get(index).equals(removeMe)) {
				jets.remove(jets.get(index));
			}
		}

	}



	
}
