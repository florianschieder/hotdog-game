/**
 * Erstellung eines Hotdogstands in der Map
 * @author Dennis Simontowsky
 */

package game;

public class HOTDOGSTALL extends GAMEOBJECT
{
    private boolean hasSausages = true;
    public int sausages;
    
    /**
     * Konstruktor für den Hotdogstall
     *
     * @param x bestimmt xKoordinate
     * @param y bestimmt yKoordinate
     * @param mode Modus
     * @param gameReference Referenz, die nur einmal für die Random Zahl gebrauch t wird
     */

    public HOTDOGSTALL(int x, int y, MODE mode, HOTDOGGAME gameReference)
    {
        super (x,y,102,86,"hotdogstall",true);
        this.image.neutralMachen();
        switch(mode) {
            case Easy:
                sausages = 4;
                break;
            case Normal:
                sausages = 3;
                break;
            case Hard:
                sausages = 2;
                break;
            case Extreme:
                sausages = gameReference.zufallsZahl(5);
                break;
            }
    }
    
     /**
     * Die Methode, die das Einsammeln von Wuerstchen behandelt
     */
    public int grabSausages() {
        if(hasSausages) {
            int ret = sausages;
            sausages = 0;
            hasSausages = false;
            return ret;
        } else {
            return 0;
        }
    }
}