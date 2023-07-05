package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends myAbsBatlleShip {

	private int numOfTechs;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(commissionYear, maximalSpeed, name, crewMembers, weapons);
		this.numOfTechs=numberOfTechnicians;

	}

	public int getNumberOfTechnicians(){
		return numOfTechs;
	}

	public int getAnnualMaintenanceCost() {
		int numOfTechs = this.getNumberOfTechnicians();
		int MaintainWeaponsCost = 0;
		List<Weapon> weapons = this.weapons;
		for (Weapon curWeapon : weapons) {
			MaintainWeaponsCost+= curWeapon.getAnnualMaintenanceCost();
		}
		if (numOfTechs > 0) {
			int MaintenanceCost = Math.round(MaintainWeaponsCost*numOfTechs/10);
			return MaintenanceCost + 5000;
		}
		return MaintainWeaponsCost + 5000;
		}


	public String toString() {
		return "Bomber\n"+ super.toString()+ System.lineSeparator()+ "\tAnnualMaintenanceCost="+this.getAnnualMaintenanceCost()+System.lineSeparator()+  "\tAnnualMaintenanceCost="+this.getAnnualMaintenanceCost()+System.lineSeparator()+ "\tWeaponArray="+this.getWeapon().toString()+ "\tNumberOfTechnicians="+this.getNumberOfTechnicians();
	}
}
