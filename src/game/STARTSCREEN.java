/**
 * Startbildschirm
 *  
 * @author Dennis Simontowsky
 */

package game;

public class STARTSCREEN extends LEVEL {
    private FLOOR boden1;
    private FLOOR boden2;
    private ENEMY enemy;
    private HOTDOGSTALL stall;
    private KETCHUPBOTTLE kb;
    
     /**
     * Konstruktur der Klasse STARTSCREEN.
     *
     * @param mode Schwierigkeitsgrad
     * @param game Referenz auf das Spielobjekt
     */
    public STARTSCREEN(MODE mode, HOTDOGGAME game) {
        super(mode, game);
        
        levelNumber = 0;
        create();
    }
    
     /**
     * Die Methode, die den Level und seine Objekte erstellt.
     */
    @Override
    public void create() {
        super.create();
        
        // Hintergrund ändern
        this.gameReference.removeRaumObjekt(this.background);
        this.background = new ea.Bild(0, 0, 1152, 864, ASSETS.image("startscreen"));
        this.gameReference.addRaumObjekt(this.background);
        
        // Text weg
        this.gameReference.removeRaumObjekt(this.anzeige);
        
        this.player = new DOG(0, 0, this.gameReference);
        this.gameReference.addGameObject(this.player);
        
        this.boden1 = new FLOOR(0, 812, 500, 52);
        this.gameReference.addGameObject(this.boden1);
        
        this.boden2 = new FLOOR(575, 812, 450, 52);
        this.gameReference.addGameObject(this.boden2);
        
        this.kb = new KETCHUPBOTTLE(500, 450, this.gameReference);
        this.gameReference.addGameObject(this.kb);
        
        this.enemy = new ENEMY(300, 800);
        this.gameReference.addGameObject(this.enemy);
        
        this.stall = new HOTDOGSTALL(700, 700, this.mode, this.gameReference);
        this.gameReference.addGameObject(this.stall);
        
        this.goal = new GOAL(1000, 700);
        this.gameReference.addGameObject(this.goal);
    }
    
     /**
     * Die Methode, die alle Objekte des Levels löscht.
     */
    @Override
    public void destroy() {
        super.destroy();

        this.gameReference.removeGameObject(this.boden1);
        this.gameReference.removeGameObject(this.boden2);
        this.gameReference.removeGameObject(this.kb);
        this.gameReference.removeGameObject(this.enemy);
        this.gameReference.removeGameObject(this.stall);
        this.gameReference.removeRaumObjekt(this.background);
        
        if(this.kb.Ketchup != null) this.gameReference.removeGameObject(this.kb.Ketchup);
    }
    
     /**
     * Schleife für den Spieler sowie HandleHoldKey
     */
    @Override
    public void loop() {
        super.loop();
        player.loop();
        player.handleHoldKey();
        
        if(kb.Ketchup != null && kb.Ketchup.collision(player)) lose();
        if(enemy != null && enemy.collision(player)) lose();
        if(player.currentSausage != null && enemy != null && enemy.collision(player.currentSausage)) { gameReference.removeGameObject(enemy); enemy = null;}
        if(player.collision(this.stall)) { this.player.sausages += this.stall.grabSausages(); }
    }
    
    
    @Override
    public void limitLoop() {
        // Ticker wird "abgeschalten", also gibt es kein Limit-Verhalten ^^ (da super.limitLoop() nicht aufgerufen wird!)
        if(this.gameReference.zufallsBoolean()) kb.throwKetchup();
    }
}
