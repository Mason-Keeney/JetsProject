package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements BattleReady{
	private final String defaultModel = "F16";
	private final double defaultSpeed = 790;
	private final int defaultRange = 250;
	private final long defaultPrice = 10000000;

	public FighterJet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fight() {
		System.out.println(this.getModel() + " fires it's full loadout!");
		int hitCalc = (int)(Math.random() * 10);
		boolean doesHit = false;
			if (hitCalc > 2) {
				doesHit = true;
			}
		if (doesHit) {
			System.out.println("It hits the target!");
		} else {
			System.out.println("It misses");
		}
	}

	@Override
	public boolean loadoutIsReady() {
		// someday, I might write fun code here.
		return true;
	}

	@Override
	public void fly() {
		System.out.println("Engines roar overhead, the deep roar turns to a crack of thunder " + this.getModel() + " breaks the sound barrier");
		
	}

	@Override
	protected void setDefaultValues() {
		this.setModel(defaultModel);
		this.setSpeed(defaultSpeed);
		this.setRange(defaultRange);
		this.setPrice(defaultPrice);
	}

}
