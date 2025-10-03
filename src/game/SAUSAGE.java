/**
 * Das Würstchen, mit dem der Hund schießt.
 *
 * @author Dennis Simontowsky
 */

package game;

public class SAUSAGE extends GRAVITYOBJECT {
	private int direction;

	/**
	 * Konstruktor für die Klasse
	 *
	 * @param player Referenz auf den Hund
	 * @param d      Richtung ins Positive (+1) oder Negative (-1)
	 */
	public SAUSAGE(DOG player, int d) {
		super((int) (player.image.getX() + (d * player.image.getBreite())),
				(int) player.image.getY(), 32, 12, "sausage");
		this.direction = d;
	}

	/**
	 * Die Methode, die das Würstchen zum Fallen bringt.
	 */
	public void loop() {
		this.image.verschieben(this.direction * 5, 0);
	}
}
