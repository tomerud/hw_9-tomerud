package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter  {


	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
						 List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
	}

	public int getAnnualMaintenanceCost() {
		int finalCost = 4000;
		List<Weapon> list = this.weapons;
		for (Weapon weapon:list) {
			finalCost += weapon.getAnnualMaintenanceCost();
		}
		int crewSize = this.getCrewMembers().size();
		float maxSpeed = this.maximalSpeed;
		finalCost = (int) (finalCost +  crewSize * 500 + maxSpeed *500);
		return finalCost;
	}
	public String toString() {
		return "ColonialViper\n"+super.toString("ColonialViper");
	}

}
