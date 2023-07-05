package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter{


	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
					   List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
	}

	public int getAnnualMaintenanceCost() {
		int finalCost = 3500;
		List<Weapon> list = this.weapons;
		for (Weapon curWeapon:list) {
			int curCost = curWeapon.getAnnualMaintenanceCost();
			finalCost += curCost;
		}
		int crewSize = getCrewMembers().size();
		float maxSpeed = this.maximalSpeed;
		finalCost += crewSize * 500 + maxSpeed *1200;
		return finalCost;
	}

	public String toString() {
		return "CylonRaider\n"+super.toString("CylonRaider");
	}


}
