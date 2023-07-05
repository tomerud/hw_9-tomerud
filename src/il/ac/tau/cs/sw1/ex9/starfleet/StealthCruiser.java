package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter {

	private static int numOfStealthCreated=0;

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers,weapons);
		StealthCruiser.numOfStealthCreated++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name,commissionYear,maximalSpeed,crewMembers,new ArrayList<Weapon>(Arrays.asList(new Weapon ("Laser Cannons",10,100))));
	}

	public int getAnnualMaintenanceCost() {
		int finalCost=super.getAnnualMaintenanceCost();
		finalCost+= 50*StealthCruiser.numOfStealthCreated;
		return finalCost;
	}

	public String toString() {
		return "StealthCruiser\n"+super.toString("StealthCruiser");
	}
}

