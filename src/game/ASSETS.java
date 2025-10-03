/**
 * Vereinfachter Zugriff auf externe Spielelemente.
 *
 * @author Florian Schieder
 */

package game;

public class ASSETS {
	public static String image(String name) {
		return "assets/images/" + name + ".png";
	}

	public static String sound(String name) {
		return "assets/sounds/" + name + ".wav";
	}
}
