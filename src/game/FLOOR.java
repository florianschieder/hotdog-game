/**
 * Komponente für den den Boden
 *
 * @author Florian Schieder
 */
package game;

public class FLOOR extends GAMEOBJECT {
	/**
	 * Konstruktor der Klasse FLOOR
	 *
	 * @param x x-Position
	 * @param y y-Position
	 * @param w Breite
	 * @param h Höhe
	 */
	public FLOOR(int x, int y, int w, int h) {
		super(x, y, w, h, "floor", true);
	}
}
