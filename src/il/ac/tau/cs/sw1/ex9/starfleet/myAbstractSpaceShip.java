package il.ac.tau.cs.sw1.ex9.starfleet;
import java.util.Objects;
import java.util.Set;

public abstract class myAbstractSpaceShip implements Spaceship{
    private String name;
    private int commissionYear;
    protected float maximalSpeed;
    private Set<? extends CrewMember> crewMembers;
    private static final int BASICFIREPOWER = 10;


    public myAbstractSpaceShip(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers){
        this.name=name;
        this.commissionYear=commissionYear;
        this.maximalSpeed=maximalSpeed;
        this.crewMembers=crewMembers;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getCommissionYear(){
        return commissionYear;
    }

    @Override
    public float getMaximalSpeed() {
        return maximalSpeed;
    }

    @Override
    public int getFirePower() {
        return myAbstractSpaceShip.BASICFIREPOWER;
    }

    @Override
    public Set<? extends CrewMember> getCrewMembers() {
        return crewMembers;
    }

    public abstract int getAnnualMaintenanceCost();

    public String toString() {
        return "\tName="+this.getName()+ "\n\tCommissionYear="+this.getCommissionYear() + "\n\tMaximalSpeed="+this.getMaximalSpeed()+ "\n\tFirePower="+this.getFirePower()+ "\n\tCrewMembers="+this.getCrewMembers().size()+ "\n\tAnnualMaintenanceCost="+this.getAnnualMaintenanceCost();
    }


    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        myAbstractSpaceShip other = (myAbstractSpaceShip) obj;
        return Objects.equals(name, other.name);
    }

    public int compareTo(Spaceship other) {
        if(this.getFirePower()==other.getFirePower()) {
            if(this.getCommissionYear()==other.getCommissionYear()) {
                return this.getName().compareTo(other.getName());
            }
            else {
                return ((Integer)other.getCommissionYear()).compareTo((Integer)this.getCommissionYear());
            }
        }
        else {
            return ((Integer)other.getFirePower()).compareTo((Integer)this.getFirePower());
        }
    }
}

