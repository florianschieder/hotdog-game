/**
 * Basisklasse für jedes einzelne Objekt innerhalb des Spiels.
 *
 * @author Dennis Simontowsky
 */

package game.objects;

import ea.Bild;
import game.core.Assets;

public class GameObject {
	public Bild image;
	private boolean isFix;

	/**
	 * Liefert den Wert des geschützten isFix Attributs.
	 *
	 * @return wert von isFix
	 */
	public boolean checkIsFix() {
		return isFix;
	}

	/**
	 * Konstruktor von GAMEOBJECT
	 *
	 * @param x              x-Position
	 * @param y              y-Position
	 * @param w              Breite
	 * @param h              Höhe
	 * @param bildBezeichner Name des Bilds ohne Erweiterung (nur der Name)
	 * @param fix            Ist das Objekt fixiert oder nicht?
	 */
	public GameObject(int x, int y, int w, int h, String bildBezeichner,
			boolean fix) {
		image = new Bild(x, y, w, h, Assets.image(bildBezeichner), true);
		isFix = fix;

		if (isFix) {
			image.passivMachen();
		} else {
			image.aktivMachen();
		}
	}

	/**
	 * Kollisions-Checker
	 *
	 * @param obj Objekt, auf das Kollision überprüft werden soll
	 */

	public boolean collision(GameObject obj) {
		return image.schneidet(obj.image);
	}
}