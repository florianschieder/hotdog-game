package game;
import ea.*;

/**
 * Komponente:  ENEMY <br>
 * Typ:         Klasse <br>
 * <br> 
 * Funktion:    Erstellung eines Gegners in der Map <br>
 *  <br>
 * @author Dennis Simontowsky
 */

public class ENEMY extends GRAVITYOBJECT
{
     /**
     * Konstruktor für den Gegner
     *
     * @param x bestimmt xKoordinate
     * @param y bestimmt yKoordinate
     */

    public ENEMY(int xStart,int y) {
       super(xStart,y,33,59,"enemy1");
    }
}
