/**
 * Schnittstelle für gedrückte Taste
 *
 * @author Dennis Simontowsky
 */

package game.core;

public interface HandlesPressedKey {
	/**
	 * Behandelt eine "einmalig" gedrückte Taste.
	 *
	 * @param code Tastencode der gedrückten Taste
	 */
	void handlePressedKey(int code);
}
