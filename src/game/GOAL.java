package game;
/**
 * Komponente:  GOAL <br>
 * Typ:         Klasse <br>
 * <br>
 * Funktion:    Erstellung eines Ziel-Elements in der Map <br>
 * <br>
 * @author Dennis Simontowsky
 */

public class GOAL extends GAMEOBJECT
{
    /**
     * Konstruktor der Klasse GOAL <br>
     * <br>
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    public GOAL(int x, int y)
    {
        super(x, y, 55, 77, "goal", true);
    }
}
