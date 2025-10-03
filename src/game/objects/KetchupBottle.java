/**
 * Erstellung einer Ketchupflasche in der Map
 * @author Dennis Simontowsky
 */

package game.objects;

import game.screens.HotdogGame;

public class KetchupBottle extends GameObject {
	public GravityObject Ketchup;
	public HotdogGame g_verweis;

	/**
	 * Konstruktor für KETCHUPBOTTLE
	 *
	 * @param x       bestimmt xKoordinate
	 * @param y       bestimmt yKoordinate
	 * @param verweis Verweis auf das Spiel
	 */

	public KetchupBottle(int x, int y, HotdogGame verweis) {
		super(x, y, 62, 136, "ketchupbottle", true);
		g_verweis = verweis;
	}

	/**
	 * Methode fuer die Erstellung von Ketchup, das aus der Ketchupbottle kommt
	 */

	public void throwKetchup() {
		Ketchup = new GravityObject(
				(int) (image.getX() + image.getBreite() / 2),
				(int) (image.getY() + image.getHoehe()), 6, 69, "ketchup");
		g_verweis.addGameObject(Ketchup);
	}

	/**
	 * Gibt an, ob die Animation in einer Dauerschleife ausgefuehrt werden soll
	 */
	public boolean loop(GameObject object) {
		if (Ketchup != null && Ketchup.image != null
				&& Ketchup.image.schneidet(object.image)) {
			g_verweis.removeRaumObjekt(Ketchup.image);
			return Ketchup.image.schneidet(object.image);
		}

		return false;
	}
}
