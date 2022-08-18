package com.aram.zooKeeper1;

public class BatTest {
	
	public static void main (String[] args) {
		Bat bat = new Bat();
		bat.attackTown();
		bat.attackTown();
		bat.attackTown();
		
		bat.eatHumans();
		bat.eatHumans();
		
		bat.fly();
		bat.fly();
		
		bat.displayEnergyLevel();
	}

}
