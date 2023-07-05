package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends myAbstractSpaceShip {

	private int cargoCapacity;
	private int passengerCapacity;


	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name,commissionYear,maximalSpeed,crewMembers);
		this.cargoCapacity=cargoCapacity;
		this.passengerCapacity=passengerCapacity;
	}

	public int getCargoCapacity(){
		return cargoCapacity;
	}

	public int getPassengerCapacity(){
		return passengerCapacity;
	}

	public int getAnnualMaintenanceCost(){
		return 3000 + 5*this.cargoCapacity + 3*this.passengerCapacity;
	}

	public String toString() {
		return "TransportShip\n"+super.toString()+ "\n\tCargoCapacity="+this.getCargoCapacity()+ "\n\tPassengerCapacity="+this.getPassengerCapacity();
	}
}

