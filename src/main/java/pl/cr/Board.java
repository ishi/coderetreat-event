package pl.cr;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toSet;

/**
 * Created by Radoslaw_Zielinski on 11/14/2015.
 */
class Board {

	private Set<Coordinates> coordinatesOfOnlyLiveCells;

	public Board() {
		coordinatesOfOnlyLiveCells = new HashSet<>();
	}

	public void addCell(Coordinates coordinates) {
		this.coordinatesOfOnlyLiveCells.add(coordinates);
	}

	public void transformToNextGeneration() {
		Set<Coordinates> newGeneration = coordinatesOfOnlyLiveCells.stream()
				.filter(willSurvived())
				.collect(toSet());

		coordinatesOfOnlyLiveCells = newGeneration;
	}



	private boolean willReproduce(Coordinates c) {
		return coordinatesOfOnlyLiveCells.stream().filter(pn -> pn.isNeighbour(c)).count() == 2;
	}

	private Predicate<Coordinates> willSurvived() {
		return c -> {
			long count = coordinatesOfOnlyLiveCells.stream().filter(pn -> pn.isNeighbour(c)).count();
			return count > 1 && count < 4;
		};
	}

	public boolean isCellAlive(Coordinates coordinates) {
		return this.coordinatesOfOnlyLiveCells.contains(coordinates);
	}

	public Set<Coordinates> deadCellsNeighbouringAliveCells() {
		return coordinatesOfOnlyLiveCells;
	}
}
