/**
 * Zielfahne in der Map
 *
 * @author Dennis Simontowsky
 */

package game.objects;

public class Goal extends GameObject {
	/**
	 * Konstruktor der Klasse GOAL
	 *
	 * @param x x-Koordinate
	 * @param y y-Koordinate
	 */
	public Goal(int x, int y) {
		super(x, y, 55, 77, "goal", true);
	}
}
