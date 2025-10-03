/**
 * Erstellung eines Gegners in der Map
 *
 * @author Dennis Simontowsky
 */
package game.objects;

public class Enemy extends GravityObject {
	/**
	 * Konstruktor für den Gegner
	 *
	 * @param x bestimmt xKoordinate
	 * @param y bestimmt yKoordinate
	 */

	public Enemy(int xStart, int y) {
		super(xStart, y, 33, 59, "enemy1");
	}
}
