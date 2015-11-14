package pl.cr;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Radoslaw_Zielinski on 11/14/2015.
 */
public class CellTest {
	Board seededBoard = new Board();

	@Before
	public void seed() {
		seededBoard.addCell(new Coordinates(1, 1));
		seededBoard.addCell(new Coordinates(1, 2));
		seededBoard.addCell(new Coordinates(1, 3));
	}

	@Test
	public void coordinatesCanBeCompared() {
		assertThat(new Coordinates(1, 1).equals(new Coordinates(1, 1)), is(true));
		assertThat(new Coordinates(1, 1).equals(new Coordinates(1, 2)), is(false));
	}

	@Test
	public void whenNoNeighbours_shouldDie() {
		Board board = new Board();
		board.addCell(new Coordinates(1, 1));

		assertThat(board.isCellAlive(new Coordinates(1, 1)), is(true));

		board.transformToNextGeneration();

		assertThat(board.isCellAlive(new Coordinates(1, 1)), is(false));
	}

	@Test
	public void whenTwoNeighbours_shouldSurvive() {

		seededBoard.transformToNextGeneration();

		assertThat(seededBoard.isCellAlive(new Coordinates(1, 1)), is(false));
		assertThat(seededBoard.isCellAlive(new Coordinates(1, 2)), is(true));
		assertThat(seededBoard.isCellAlive(new Coordinates(1, 3)), is(false));
	}


	@Ignore
	@Test
	public void whenThreeNeighbours_shouldNewCellBeBorn() {
		seededBoard.transformToNextGeneration();

		assertThat(seededBoard.isCellAlive(new Coordinates(2, 2)), is(true));
	}

	@Test
	public void boardIsAbleToGenerateListOfDeadCellsWithAliveNeighbours() {
		Set<Coordinates> deadCells = seededBoard.deadCellsNeighbouringAliveCells();

		assertThat(deadCells.size(), is(2));
	}
}
