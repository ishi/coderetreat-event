package pl.cr;

/**
 * Created by Radoslaw_Zielinski on 11/14/2015.
 */
class Coordinates {
	private final int x;
	private final int y;

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Coordinates that = (Coordinates) o;

		if (x != that.x) return false;
		return y == that.y;

	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}

	boolean isNeighbour(Coordinates c) {
		return Math.abs(c.x - x) == 1 || Math.abs(c.y - y) == 1;
	}
}
