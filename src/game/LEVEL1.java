/**
 * Level 1
 *  
 * @author Dennis Simontowsky & Florian Schieder
 */

package game;

public class LEVEL1 extends LEVEL {
	private FLOOR boden1;
	private FLOOR boden2;
	private FLOOR boden3;
	private FLOOR boden4;
	private FLOOR boden5;

	/**
	 * Konstruktur der Klasse LEVEL1.
	 *
	 * @param mode Schwierigkeitsgrad
	 * @param game Referenz auf das Spielobjekt
	 */
	public LEVEL1(MODE mode, HOTDOGGAME game) {
		super(mode, game);

		levelNumber = 1;
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

		this.boden1 = new FLOOR(0, 500, 350, 52);
		this.gameReference.addGameObject(this.boden1);

		this.boden2 = new FLOOR(450, 500, 150, 52);
		this.gameReference.addGameObject(this.boden2);

		this.boden3 = new FLOOR(600, 400, 150, 52);
		this.gameReference.addGameObject(this.boden3);

		this.boden4 = new FLOOR(750, 300, 150, 52);
		this.gameReference.addGameObject(this.boden4);

		this.boden5 = new FLOOR(900, 200, 150, 52);
		this.gameReference.addGameObject(this.boden5);

		this.goal = new GOAL(1000, 100);
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
		this.gameReference.removeGameObject(this.boden3);
		this.gameReference.removeGameObject(this.boden4);
		this.gameReference.removeGameObject(this.boden5);
	}

	/**
	 * Schleife für den Spieler sowie HandleHoldKey
	 */
	@Override
	public void loop() {
		super.loop();
		player.loop();
		player.handleHoldKey();
	}
}