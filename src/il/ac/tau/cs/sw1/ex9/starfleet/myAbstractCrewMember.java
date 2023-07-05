package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;

public abstract class myAbstractCrewMember implements CrewMember {
    private String name;

    private int age;

    private int yearsInService;

    public myAbstractCrewMember(int age, int yearsInService, String name){
        this.age=age;
        this.yearsInService=yearsInService;
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getYearsInService() {
        return yearsInService;
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (obj == null) {
            return false;
        }
        myAbstractCrewMember other = (myAbstractCrewMember) obj;
        return Objects.equals(name, other.name);
    }
}

