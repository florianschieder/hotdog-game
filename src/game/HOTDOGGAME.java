/**
 *  Diese Klasse verwaltet zentral alle Eingaben (Tastatur, Maus, ...)<br>
 *  und leitet diese ggf. an die jeweiligen Event-Handler weiter. Zudem<br>
 *  verwaltet sie die Level.<br>
 *  
 * @author Dennis Simontowsky & Florian Schieder
 */

package game;
import ea.*;
import ea.internal.phy.*;

@SuppressWarnings("serial")
public class HOTDOGGAME
    extends Game
    implements Ticker
    {	
	public LEVEL currentLevel;
    private int ticker = 0;
    public Physik physics;
    private Sound backgroundSound;
    
    /**
     * Konstruktor der Klasse HOTDOGGAME.<br>
     *<br>
     * @param mode Wert, der den Schwierigkeitsgrad angibt (ein Wert der Aufzählung MODE)<br>
     */
    public HOTDOGGAME(MODE mode)
    {
        super(
            1152, 864,         // Auflösung
            "HOTDOG - " + mode.toString(), // Titel
            false,              // Vollbild
            true,               // ESC beendet das Spiel
            0, 0                // Sicherheitshalber das Fenster oben im Eck positionieren
        );
        
        backgroundSound = new Sound(ASSETS.sound("bg"));
        backgroundSound.loop();
        
        physics = Physik.getPhysik();
        
        currentLevel = new STARTSCREEN(mode, this);
        currentLevel.start();
        
        this.rechenintensiveArbeitSetzen(false);
    }
        
    /**
     * Ändert das Level.
     */
    public void nextLevel(LEVEL level) {
        currentLevel.destroy();
        currentLevel = LEVEL.nextLevel(level);
        currentLevel.start();
    }
    
    /**
     * Die Methode der engine-Alpha, die den Ticker ("Hintergrund-Schleife") ausführt.
     */
    @Override
    public void tick(){
        // Dieser Hintergrundzähler muss mitlaufen
        ticker++;
        
        // Level-Schleife
        currentLevel.loop();
        
        // Dieser Block wird zwingend benötigt, damit die Level-Schleife korrekt funktioniert.
        if(this.ticker % 50 == 0) {
            currentLevel.limitLoop();
        }
    }
    
    /**
     * Die Methode der engine-Alpha, die auf Tasteneingaben reagiert.
     */
    @Override
    public void tasteReagieren(int code){ 
        switch(code) {
            case Taste.R:
                currentLevel.destroy();
                currentLevel.create();
                currentLevel.start();
                break;
        }
            
        if(this.manager.istAngemeldet(this)) {
            currentLevel.player.handlePressedKey(code);
        }
    }
    
    /**
     * Die Erweiterungsmethode, die ein Objekt auf das Fenster legt.
     */
    public void addRaumObjekt(Raum r){
        wurzel.add(r);
    }
    
    /**
     * Die Erweiterungsmethode, die ein Objekt vom Fenster entfernt.
     */
    public void removeRaumObjekt(Raum r){
        wurzel.entfernen(r);
    }
    
    /**
     * Die Erweiterungsmethode, die ein GAMEOBJECT auf das Fenster legt.
     */
    public void addGameObject(GAMEOBJECT obj) {
        addRaumObjekt(obj.image);
    }
    
    /**
     * Die Erweiterungsmethode, die ein GAMEOBJECT vom Fenster entfernt.
     */
    public void removeGameObject(GAMEOBJECT obj) {
        if(obj != null) removeRaumObjekt(obj.image);
    }
}