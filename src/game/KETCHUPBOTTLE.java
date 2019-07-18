package game;
import ea.*;

/**
 * Komponente:  KETCHUPBOTTLE <br>
 * Typ:         Klasse <br>
 * <br>
 * Funktion:    Erstellung einer Ketchupflasche in der Map <br>
 * @author Dennis Simontowsky
 */

public class KETCHUPBOTTLE extends GAMEOBJECT
{
    public GRAVITYOBJECT Ketchup;
    public HOTDOGGAME g_verweis;
   
     /**
     * Konstruktor für KETCHUPBOTTLE
     *
     * @param x bestimmt xKoordinate
     * @param y bestimmt yKoordinate
     * @param verweis Verweis auf das Spiel
     */

    public KETCHUPBOTTLE(int x, int y, HOTDOGGAME verweis)
    {
        super (x,y,62,136,"ketchupbottle",true);
        g_verweis = verweis;
    }

     /**
     * Methode fuer die Erstellung von Ketchup, das aus der Ketchupbottle kommt
     */

    public void throwKetchup() {
        Ketchup = new GRAVITYOBJECT((int)(image.getX() + image.getBreite()/2), (int)(image.getY() + image.getHoehe()), 6,69,"ketchup");
        g_verweis.addGameObject(Ketchup);
    }
    
     /**
     * Gibt an, ob die Animation in einer Dauerschleife ausgefuehrt werden soll
     */
    public boolean loop(GAMEOBJECT object) {
        if(Ketchup != null && Ketchup.image != null && Ketchup.image.schneidet(object.image)) {
            g_verweis.removeRaumObjekt(Ketchup.image);
            return Ketchup.image.schneidet(object.image);
        }
        
        return false;
    }
}
