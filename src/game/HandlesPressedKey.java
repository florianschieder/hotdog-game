package game;
/**
 * Komponente:  HandlesPressedKey <br>
 * Typ:         Interface <br>
 * <br>
 * Funktion:    Methodenimplementierung für HandlesPressedKey <br>
 *  
 * @author Dennis Simontowsky
 */

public interface HandlesPressedKey
{
    /**
     * Behandelt eine "einmalig" gedrückte Taste.
     *
     * @param code Tastencode der gedrückten Taste
     */
    void handlePressedKey(int code);
}
