/**
 * Level 3
 *  
 * @author Dennis Simontowsky
 */

package game;

public class LEVEL2 extends LEVEL {
    private FLOOR boden1;
    private FLOOR boden2;
    private FLOOR[] stairs;
    
    private ENEMY enemy1;
    private ENEMY enemy2;
    private ENEMY enemy3;
    
     /**
     * Konstruktur der Klasse LEVEL2.
     *
     * @param mode Schwierigkeitsgrad
     * @param game Referenz auf das Spielobjekt
     */
    public LEVEL2(MODE mode, HOTDOGGAME game) {
        super(mode, game);
        
        this.levelNumber = 2;
        this.stairs = new FLOOR[100];
        this.create();
    }
    
     /**
     * Die Methode, die den Level und seine Objekte erstellt.
     */
    @Override
    public void create() {
        super.create();
        
        this.player = new DOG(0, 0, this.gameReference);
        this.gameReference.addGameObject(this.player);
        
        this.boden1 = new FLOOR(0, 812, 1152, 52);
        this.gameReference.addGameObject(this.boden1);
        
        this.boden2 = new FLOOR(152, 700, 800, 52);
        this.gameReference.addGameObject(this.boden2);

        this.enemy1 = new ENEMY((this.mode == MODE.Hard || this.mode == MODE.Extreme) ? 150 +  this.gameReference.zufallsZahl(1000) : 300, 812);
        this.gameReference.addGameObject(this.enemy1);
        
        this.enemy2 = new ENEMY((this.mode == MODE.Hard || this.mode == MODE.Extreme) ? 150 +  this.gameReference.zufallsZahl(1000) : 152, 200);
        this.gameReference.addGameObject(this.enemy2);
        
        this.enemy3 = new ENEMY((this.mode == MODE.Hard || this.mode == MODE.Extreme) ? 150 + this.gameReference.zufallsZahl(1000) : 300, 0);
        this.gameReference.addGameObject(this.enemy3);
        
        for(int i = 0; i < stairs.length; i++) {
            stairs[i] = new FLOOR(300 + 10 * i, 600 - 5 * i, 40, 52);
            this.gameReference.addGameObject(stairs[i]);
        }
        
        this.goal = new GOAL(1100, 0);
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
        if(this.enemy1 != null) this.gameReference.removeGameObject(this.enemy1);
        if(this.enemy2 != null) this.gameReference.removeGameObject(this.enemy2);
        if(this.enemy3 != null) this.gameReference.removeGameObject(this.enemy3);
        
        for(int i = 0; i < stairs.length; i++) {
            this.gameReference.removeGameObject(stairs[i]);
        }
    }
    
    public void limitLoop() {
        super.limitLoop();
        
        if(this.mode == MODE.Hard || this.mode == MODE.Extreme) {
            if(enemy1 != null) enemy1.image.sprung((this.mode == MODE.Extreme) ? this.gameReference.zufallsZahl(20) : 5);
            if(enemy2 != null) enemy2.image.sprung((this.mode == MODE.Extreme) ? this.gameReference.zufallsZahl(20) : 5);
            if(enemy3 != null) enemy3.image.sprung((this.mode == MODE.Extreme) ? this.gameReference.zufallsZahl(20) : 5);
        }
    }
    
     /**
     * Schleife für den Spieler sowie HandleHoldKey
     */
    @Override
    public void loop() {
        super.loop();
        this.player.loop();
        this.player.handleHoldKey();
        
        if(this.player.currentSausage != null && this.enemy1 != null && this.player.currentSausage.collision(this.enemy1)) {
            this.gameReference.removeGameObject(this.enemy1);
            this.enemy1 = null;
            this.gameReference.removeGameObject(this.player.currentSausage);
            this.player.currentSausage = null;
        }
        
        if(this.enemy1 != null && this.player.collision(this.enemy1)) {
            this.lose();
        }
        
        if(this.player.currentSausage != null && this.enemy2 != null && this.player.currentSausage.collision(this.enemy2)) {
            this.gameReference.removeGameObject(this.enemy2);
            this.enemy2 = null;
            this.gameReference.removeGameObject(this.player.currentSausage);
            this.player.currentSausage = null;
        }
        
        if(this.enemy2 != null && this.player.collision(this.enemy2)) {
            this.lose();
        }
        
        if(this.player.currentSausage != null && this.enemy3 != null && this.player.currentSausage.collision(this.enemy3)) {
            this.gameReference.removeGameObject(this.enemy3);
            this.enemy3 = null;
            this.gameReference.removeGameObject(this.player.currentSausage);
            this.player.currentSausage = null;
        }
        
        if(this.enemy3 != null && this.player.collision(this.enemy3)) {
            this.lose();
        }
    }
}
