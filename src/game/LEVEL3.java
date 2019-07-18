package game;
/**
 * Komponente:  LEVEL3 <br>
 * Typ:         Klasse <br>
 * <br>
 * Funktion:    Level 3 <br>
 *  
 * @author Dennis Simontowsky
 */

public class LEVEL3 extends LEVEL {
    private FLOOR boden1;
    private FLOOR[] stairs_l;
    private FLOOR[] stairs_r;
    private KETCHUPBOTTLE kb;
    
     /**
     * Konstruktur der Klasse LEVEL3.
     *
     * @param mode Schwierigkeitsgrad
     * @param game Referenz auf das Spielobjekt
     */
    public LEVEL3(MODE mode, HOTDOGGAME game) {
        super(mode, game);
        
        this.stairs_l = new FLOOR[3];
        this.stairs_r = new FLOOR[3];
        
        levelNumber = 3;
        create();
    }
    
     /**
     * Die Methode, die den Level und seine Objekte erstellt.
     */
    @Override
    public void create() {
        super.create();
        
        this.player = new DOG(0, 0, this.gameReference);
        this.gameReference.addGameObject(this.player);
        
        this.kb = new KETCHUPBOTTLE(300, -40, this.gameReference);
        this.gameReference.addGameObject(this.kb);
        
        this.boden1 = new FLOOR(0, 812, 100, 52);
        this.gameReference.addGameObject(this.boden1);
        
        for(int i = 0; i < stairs_l.length; i++) {
            this.stairs_l[i] = new FLOOR(200, 300 + 250 * i, 100, 52);
            this.gameReference.addGameObject(this.stairs_l[i]);
        }
        
        for(int i = 0; i < stairs_r.length; i++) {
            this.stairs_r[i] = new FLOOR(400, 200 + 250 * i, 100, 52);
            this.gameReference.addGameObject(this.stairs_r[i]);
        }
        
        this.goal = new GOAL(450, 110);
        this.gameReference.addGameObject(this.goal);
    }
    
     /**
     * Die Methode, die alle Objekte des Levels löscht.
     */
    @Override
    public void destroy() {
        super.destroy();

        this.gameReference.removeGameObject(this.boden1);
        
        for(int i = 0; i < stairs_l.length; i++) {
            this.gameReference.removeGameObject(stairs_l[i]);
        }
        
        for(int i = 0; i < stairs_r.length; i++) {
            this.gameReference.removeGameObject(stairs_r[i]);
        }
        
        if(this.kb.Ketchup != null) this.gameReference.removeGameObject(this.kb.Ketchup);
    }
    
     /**
     * Schleife für den Spieler sowie HandleHoldKey
     */
    @Override
    public void loop() {
        super.loop();
        if(kb.loop(player)) lose();
        player.loop();
        player.handleHoldKey();
    }
    
    @Override
    public void limitLoop() {
        super.limitLoop();
        if(this.gameReference.zufallsBoolean()) this.kb.throwKetchup();
    }
}
