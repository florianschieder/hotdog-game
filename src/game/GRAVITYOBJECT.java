/**
 * Basisklasse für jedes einzelne fallende Objekt innerhalb des Spiels.
 * @author Dennis Simontowsky
 */

package game;

public class GRAVITYOBJECT extends GAMEOBJECT {

	/**
	 * Konstruktor für GRAVITYOBJECT
	 *
	 * @param x              x-Position
	 * @param y              y-Position
	 * @param w              Breite
	 * @param h              Höhe
	 * @param bildBezeichner Name des Bilds ohne Erweiterung (nur der Name)
	 */
	public GRAVITYOBJECT(int x, int y, int w, int h, String bildBezeichner) {
		super(x, y, w, h, bildBezeichner, false);
		this.image.schwerkraftSetzen(5);
	}

}
