/**
 * Zielfahne in der Map
 * 
 * @author Dennis Simontowsky
 */

package game;

public class GOAL extends GAMEOBJECT {
	/**
	 * Konstruktor der Klasse GOAL
	 * 
	 * @param x x-Koordinate
	 * @param y y-Koordinate
	 */
	public GOAL(int x, int y) {
		super(x, y, 55, 77, "goal", true);
	}
}
