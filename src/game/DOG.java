/**
 * Klasse für den Spieler
 * 
 * @author Florian Schieder
 */
package game;

import engine.*;

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
                	engine.Sound.play("woof");
                    currentSausage = new SAUSAGE(this, (ref.tasteGedrueckt(Taste.LINKS) ? -1 : 1)); // Copyright Florian Schieder :)
                    ref.addGameObject(currentSausage);
                    sausages--;
                }
                if(sausages == 0) engine.Sound.play("die");
                break;
            case Taste.OBEN:
            	engine.Sound.play("jump");
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
    	engine.Sound.play("die");
    }
}