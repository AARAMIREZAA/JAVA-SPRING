package com.aram.zooKeeper1;

public class Mammal {
	private int energyLevel;
	
	public Mammal() {
		energyLevel = 100;
	}
	
	//getters
	public int getEnergyLevel() {
		return energyLevel;
	}

	//setters
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}


	public void displayEnergyLevel() {
		System.out.println(energyLevel);
	}

}
