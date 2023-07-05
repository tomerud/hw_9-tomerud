package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.*;
import java.util.stream.Collectors;

public class StarfleetManager {

	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear(Collection<Spaceship> fleet) {
		return fleet.stream()
				.sorted(Comparator.comparingInt(Spaceship::getFirePower)
						.reversed()
						.thenComparingInt(Spaceship::getCommissionYear)
						.reversed()
						.thenComparing(Spaceship::getName))
				.map(Spaceship::toString)
				.collect(Collectors.toList());
	}

	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> instanceMap = new HashMap<>();
		for (Spaceship ship : fleet) {
			String className = ship.getClass().getSimpleName();
			instanceMap.put(className, instanceMap.getOrDefault(className, 0) + 1);
		}
		return instanceMap;
	}

	public static int getTotalMaintenanceCost(Collection<Spaceship> fleet) {
		return fleet.stream()
				.mapToInt(Spaceship::getAnnualMaintenanceCost)
				.sum();
	}

	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> weaponNames = new HashSet<>();

		for (Spaceship ship : fleet) {
			if (ship instanceof Fighter) {
				List<Weapon> fighterWeapons = ((Fighter) ship).getWeapon();
				addWeaponNames(weaponNames, fighterWeapons);
			} else if (ship instanceof Bomber) {
				List<Weapon> bomberWeapons = ((Bomber) ship).getWeapon();
				addWeaponNames(weaponNames, bomberWeapons);
			}
		}

		return weaponNames;
	}

	private static void addWeaponNames(Set<String> weaponNames, List<Weapon> weapons) {
		for (Weapon weapon : weapons) {
			weaponNames.add(weapon.getName());
		}
	}

	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		return fleet.stream()
				.mapToInt(ship -> ship.getCrewMembers().size())
				.sum();
	}

	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int totalOfficers = 0;
		int sumOfOfficersAge = 0;

		for (Spaceship ship : fleet) {
			for (CrewMember crewMember : ship.getCrewMembers()) {
				if (crewMember instanceof Officer) {
					totalOfficers++;
					sumOfOfficersAge += crewMember.getAge();
				}
			}
		}

		return (float) sumOfOfficersAge / totalOfficers;
	}

	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> highestRankingOfficers = new HashMap<>();
		for (Spaceship ship : fleet) {
			Officer highestRankingOfficer = ship.getCrewMembers().stream()
					.filter(member -> member instanceof Officer)
					.map(member -> (Officer) member)
					.max(Comparator.comparing(Officer::getRank))
					.orElse(null);
			if (highestRankingOfficer != null) {
				highestRankingOfficers.put(highestRankingOfficer, ship);
			}
		}
		return highestRankingOfficers;
	}

	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> rankPopularity = new HashMap<>();
		for (Spaceship ship : fleet) {
			for (CrewMember crewMember : ship.getCrewMembers()) {
				if (crewMember instanceof Officer) {
					OfficerRank rank = ((Officer) crewMember).getRank();
					rankPopularity.put(rank, rankPopularity.getOrDefault(rank, 0) + 1);
				}
			}
		}
		List<Map.Entry<OfficerRank, Integer>> sortedRanks = new ArrayList<>(rankPopularity.entrySet());
		sortedRanks.sort(Comparator.comparing(Map.Entry::getValue));
		return sortedRanks;
	}
}
