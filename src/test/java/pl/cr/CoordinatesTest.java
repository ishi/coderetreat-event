package pl.cr;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Radoslaw_Zielinski on 11/14/2015.
 */
public class CoordinatesTest {

	@Test
	public void cellsNextToOneAnotherOn_X_AxisAreNeighbors(){
		Coordinates one = new Coordinates(1, 1);
		Coordinates two = new Coordinates(2, 1);

		assertThat(one.isNeighbour(two), is(true));
	}

	@Test
	public void cellsThatAre_2_pointsAwayFromOneAnother_OnXAxis_AreNotNeighbours(){
		Coordinates one = new Coordinates(1, 1);
		Coordinates two = new Coordinates(3, 1);

		assertThat(one.isNeighbour(two), is(false));
	}
}