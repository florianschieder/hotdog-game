package game;
import ea.*;

/**
 * Komponente:  DOG <br>
 * Typ:         Klasse <br>
 * <br>
 * Funktion:    Klasse für den Spieler (den Hund) <br>
 * 
 * @author Florian Schieder
 */

public class DOG
    extends GRAVITYOBJECT
    implements HandlesHoldKey, HandlesPressedKey
{
    private HOTDOGGAME ref;
    public SAUSAGE currentSausage;
    public int sausages = 3;
    
    private Sound woofSound;
    private Sound dieSound;
    private Sound jumpSound;
    
    /**
     * Konstruktor für die Klasse DOG.
     *
     * @param x x-Position
     * @param y y-Position
     */
    public DOG(int x, int y, HOTDOGGAME gameref) {
        super(x, y, 58, 37, "hotdog_r0");
        ref = gameref;
        
        woofSound = new Sound(ASSETS.sound("woof"));
        dieSound = new Sound(ASSETS.sound("die"));
        jumpSound = new Sound(ASSETS.sound("jump"));
    }
   
     /**
     * Methode für die Reaktion bei Gedrueckthalten der rechten oder linken Pfeiltaste
     */

    public void handleHoldKey() {
        if(ref.tasteGedrueckt(Taste.RECHTS)) {
            image.verschieben(4, 0);
            image.gibDrehung();
        }
        if(ref.tasteGedrueckt(Taste.LINKS)) {
            image.verschieben(-4, 0);
            image.gibDrehung();
        }
    }
    
     /**
     * Methode für die Reaktion bei Druecken der Leertaste oder der oberen Pfeiltaste
     */

    public void handlePressedKey(int code) {
        switch(code) {
            case Taste.LEERTASTE:
                if(sausages > 0 && currentSausage == null) {
                    woofSound.play();
                    currentSausage = new SAUSAGE(this, (ref.tasteGedrueckt(Taste.LINKS) ? -1 : 1)); // Copyright Florian Schieder :)
                    ref.addGameObject(currentSausage);
                    sausages--;
                }
                if(sausages == 0) dieSound.play();
                break;
            case Taste.OBEN:
                jumpSound.play();
                image.sprung(8);
                break;
        }
    }
    
     /**
     * Schleife die angibt, ob der Spieler Wuerstchen hat oder nicht
     */
    public void loop() {
        if(currentSausage != null) currentSausage.loop();
    }
    
    public void DieSound() {
        dieSound.play();
    }
}