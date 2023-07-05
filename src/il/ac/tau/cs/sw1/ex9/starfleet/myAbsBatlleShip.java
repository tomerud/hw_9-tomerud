package il.ac.tau.cs.sw1.ex9.starfleet;
import java.util.List;
import java.util.Set;
public abstract class myAbsBatlleShip extends myAbstractSpaceShip {
    protected List<Weapon> weapons;

    public myAbsBatlleShip(int commissionYear, float maximalSpeed, String name, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
        super (name,commissionYear,maximalSpeed,crewMembers);
        this.weapons=weapons;
    }
    public List<Weapon> getWeapon(){
        return weapons;
    }

    public int getFirePower() {
        int finalFirePower = super.getFirePower();
        int n = this.weapons.size();
        for(int i = 0; i < n; i++){
            int curPower = weapons.get(i).getFirePower();
        }
        for (Weapon curWeapon:this.weapons) {
            finalFirePower+= curWeapon.getFirePower();
        }
        return finalFirePower;
    }

    public abstract int getAnnualMaintenanceCost();
}

