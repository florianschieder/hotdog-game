package game;
/**
 * Komponente:  GRAVITYOBJECT <br>
 * Typ:         Klasse <br>
 * <br>
 * Funktion:    Basisklasse für jedes einzelne fallende Objekt innerhalb des Spiels.<br>
 *  <br>
 * @author Dennis Simontowsky<br>
 */

import ea.*;

public class GRAVITYOBJECT extends GAMEOBJECT {
    
    /**
     * Konstruktor für GRAVITYOBJECT
     *
     * @param x x-Position
     * @param y y-Position
     * @param w Breite
     * @param h Höhe
     * @param bildBezeichner Name des Bilds ohne Erweiterung (nur der Name)
     */
    public GRAVITYOBJECT(int x, int y, int w, int h, String bildBezeichner) {
        super(x, y, w, h, bildBezeichner, false);
        this.image.schwerkraftSetzen(5);
    }
    
}
