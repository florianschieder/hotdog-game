/**
 * Level 1
 *
 * @author Dennis Simontowsky & Florian Schieder
 */

package game.levels;

import game.core.Mode;
import game.objects.Dog;
import game.objects.Floor;
import game.objects.Goal;
import game.screens.HotdogGame;

public class Level1 extends BaseLevel {
	private Floor boden1;
	private Floor boden2;
	private Floor boden3;
	private Floor boden4;
	private Floor boden5;

	/**
	 * Konstruktur der Klasse LEVEL1.
	 *
	 * @param mode Schwierigkeitsgrad
	 * @param game Referenz auf das Spielobjekt
	 */
	public Level1(Mode mode, HotdogGame game) {
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

		this.player = new Dog(0, 0, this.gameReference);
		this.gameReference.addGameObject(this.player);

		this.boden1 = new Floor(0, 500, 350, 52);
		this.gameReference.addGameObject(this.boden1);

		this.boden2 = new Floor(450, 500, 150, 52);
		this.gameReference.addGameObject(this.boden2);

		this.boden3 = new Floor(600, 400, 150, 52);
		this.gameReference.addGameObject(this.boden3);

		this.boden4 = new Floor(750, 300, 150, 52);
		this.gameReference.addGameObject(this.boden4);

		this.boden5 = new Floor(900, 200, 150, 52);
		this.gameReference.addGameObject(this.boden5);

		this.goal = new Goal(1000, 100);
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