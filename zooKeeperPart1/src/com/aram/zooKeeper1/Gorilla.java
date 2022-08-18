package com.aram.zooKeeper1;

public class Gorilla extends Mammal {
	public void throwSomething() {
		System.out.println("Look out! The gorilla is about to throw something");
		this.setEnergyLevel(this.getEnergyLevel() - 5);
	}
	
	public void eatBananas() {
		System.out.println("Yep.");
		this.setEnergyLevel(getEnergyLevel() + 10);
	}
	
	public void climb() {
		System.out.println("The gorilla is climbing!");
		this.setEnergyLevel(this.getEnergyLevel() - 10);
	}
	

}
