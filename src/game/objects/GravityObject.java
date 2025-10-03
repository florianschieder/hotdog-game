/**
 * Basisklasse für jedes einzelne fallende Objekt innerhalb des Spiels.
 * @author Dennis Simontowsky
 */

package game.objects;

public class GravityObject extends GameObject {

	/**
	 * Konstruktor für GRAVITYOBJECT
	 *
	 * @param x              x-Position
	 * @param y              y-Position
	 * @param w              Breite
	 * @param h              Höhe
	 * @param bildBezeichner Name des Bilds ohne Erweiterung (nur der Name)
	 */
	public GravityObject(int x, int y, int w, int h, String bildBezeichner) {
		super(x, y, w, h, bildBezeichner, false);
		this.image.schwerkraftSetzen(5);
	}

}
