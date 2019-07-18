/**
 *  Diese Klasse ist eine Oberklasse für alle Level in diesem Spiel, <br>
 *  Sie beinhaltet automatisch "leere" Methoden für die Erstellung <br>
 *  und Entfernung der Game-Objekte. <br>
 *  
 * @author Florian Schieder
 */

package game;

import ea.*;
import engine.*;

public class LEVEL {
    // Attribute
    public Image background;
    public int limit;
    public int levelNumber;
    public DOG player;
    public GOAL goal;
    
    public Text anzeige;
    public MODE mode;
    public Text gameover;
    public HOTDOGGAME gameReference;
    
    private engine.Sound vSound;

    /**
     * Konstruktur der Klasse LEVEL.
     *
     * @param mode Schwierigkeitsgrad
     * @param game Referenz auf das Spielobjekt
     */
    public LEVEL(MODE mode, HOTDOGGAME game) {
        this.mode = mode;
        this.gameReference = game;

        background = new Image(0, 0, 1152, 864, "background");
        game.addRaumObjekt(background);
    }
    
    /**
     * Die Methode, die den Level und seine Objekte erstellt. In der Basisklasse hat sie keine Funktion.
     */
    public void create() {
        switch(mode) {
            case Easy:
                limit = 60;
                break;
            case Normal:
                limit = 45;
                break;
            case Hard:
                limit = 30;
                break;
            case Extreme:
                limit = 20;
                break;
        }
        
        anzeige = new Text(0, 0, getStatus());
        gameReference.addRaumObjekt(anzeige);
    }
    
    /**
     * Die Methode, die den Statustext (je nach aktuellem Limit etc.) zurückgibt.
     * @return Der Statustext für die Anzeige
     */
    public String getStatus() {
        return mode.toString() + " | LEVEL " + String.valueOf(levelNumber) + " | " + String.valueOf(limit) + "s";
    }
    
    /**
     * Die Methode, die gekapselt für alle Level Hintergrundbild und Zeit-/Levelanzeige verwaltet.
     */
    public final void start() {
        gameReference.tickerAnmelden(gameReference, 20);
        
        this.goal.image.neutralMachen();
    }
    
    /**
     * Die Methode, die die Hauptschleife des Levels bereitstellt. Diese wird vom Ticker alle 1000ms (1s) aufgerufen.
     */
    public void limitLoop() {
        if(limit > 0) {
            limit--;
            anzeige.setzeInhalt(getStatus());
        } else {
            lose();
        }
    }
    
    public void loop() {
        if(this.player.image.getX() > 1152 || this.player.image.getY() > 864) lose();
        if(this.player.currentSausage != null && (this.player.currentSausage.image.getX() > 1152 || this.player.currentSausage.image.getY() > 864)) this.player.currentSausage = null;
        
        if(this.player.collision(this.goal)) {
        	engine.Sound.play("victory");
            
            destroy();
            gameReference.nextLevel(this);
        }
    }
    
    /**
     * Die Methode, die den Game-Over-Text einblendet
     */
    public final void gameOverScreen() {
        gameover = new Text(0, 0, "GAME OVER (R)");
        gameover.mittelpunktSetzen(player.image.mittelPunkt());
        gameover.farbeSetzen("rot");
        gameReference.addRaumObjekt(gameover);
    }
    
    /**
     * Die Methode, die alle Objekte des Levels löscht.
     */
    @SuppressWarnings("static-access")
	public void destroy() {
        this.gameReference.physics.neutralize();
        if(this.gameReference.manager.istAngemeldet(this.gameReference)) this.gameReference.manager.alleAbmelden();
        
        this.gameReference.removeGameObject(player);
        this.gameReference.removeGameObject(goal);
        this.gameReference.removeRaumObjekt(gameover);
        this.gameReference.removeRaumObjekt(anzeige);
        
        if(this.player.currentSausage != null) this.gameReference.removeGameObject(this.player.currentSausage);
    }
    
    /**
     * Die Methode, die die Hauptschleife des Levels "unterbricht" und das Verlieren des Spielers behandelt.
     */
    public final void lose() {
        this.player.DieSound();
        this.gameReference.manager.alleAbmelden();
        gameOverScreen();
    }
    
    public static LEVEL nextLevel(LEVEL level) {
        switch(level.levelNumber) {
            case 0:
                return new LEVEL1(level.mode, level.gameReference);
            case 1:
                return new LEVEL2(level.mode, level.gameReference);
            case 2:
                return new LEVEL3(level.mode, level.gameReference);
            case 3:
                return new LEVEL4(level.mode, level.gameReference);
            default:
                return new STARTSCREEN(level.mode, level.gameReference);
        }
    }
}