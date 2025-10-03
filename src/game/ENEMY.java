/**
 * Erstellung eines Gegners in der Map
 *
 * @author Dennis Simontowsky
 */
package game;

public class ENEMY extends GRAVITYOBJECT {
	/**
	 * Konstruktor für den Gegner
	 *
	 * @param x bestimmt xKoordinate
	 * @param y bestimmt yKoordinate
	 */

	public ENEMY(int xStart, int y) {
		super(xStart, y, 33, 59, "enemy1");
	}
}
