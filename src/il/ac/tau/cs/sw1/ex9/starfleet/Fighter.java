package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends myAbsBatlleShip {


	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons) {
		super(commissionYear, maximalSpeed, name, crewMembers, weapons);
	}


	public int getAnnualMaintenanceCost() {
		int floorSpeed = (int) Math.floor(1000 * this.getMaximalSpeed());
		int finalCost = 2500 + floorSpeed;
		for (Weapon curWeapon : this.weapons) {
			int curCost = curWeapon.getAnnualMaintenanceCost();
			finalCost += curCost;
		}
		return finalCost;
	}

	public String toString() {
		return "Fighter\n" + toString("Fighter");
	}

	public String toString(String battleShipType){
		String str =  this.getWeapon().toString();
		return super.toString()+System.lineSeparator()+ "\tWeaponArray="+str;
	}
}
