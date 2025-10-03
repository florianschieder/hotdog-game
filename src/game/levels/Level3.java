/**
 * Level 3
 *
 * @author Dennis Simontowsky
 */

package game.levels;

import game.core.Mode;
import game.objects.Dog;
import game.objects.Floor;
import game.objects.Goal;
import game.objects.KetchupBottle;
import game.screens.HotdogGame;

public class Level3 extends BaseLevel {
	private Floor boden1;
	private Floor[] stairs_l;
	private Floor[] stairs_r;
	private KetchupBottle kb;

	/**
	 * Konstruktur der Klasse LEVEL3.
	 *
	 * @param mode Schwierigkeitsgrad
	 * @param game Referenz auf das Spielobjekt
	 */
	public Level3(Mode mode, HotdogGame game) {
		super(mode, game);

		this.stairs_l = new Floor[3];
		this.stairs_r = new Floor[3];

		levelNumber = 3;
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

		this.kb = new KetchupBottle(300, -40, this.gameReference);
		this.gameReference.addGameObject(this.kb);

		this.boden1 = new Floor(0, 812, 100, 52);
		this.gameReference.addGameObject(this.boden1);

		for (int i = 0; i < stairs_l.length; i++) {
			this.stairs_l[i] = new Floor(200, 300 + 250 * i, 100, 52);
			this.gameReference.addGameObject(this.stairs_l[i]);
		}

		for (int i = 0; i < stairs_r.length; i++) {
			this.stairs_r[i] = new Floor(400, 200 + 250 * i, 100, 52);
			this.gameReference.addGameObject(this.stairs_r[i]);
		}

		this.goal = new Goal(450, 110);
		this.gameReference.addGameObject(this.goal);
	}

	/**
	 * Die Methode, die alle Objekte des Levels löscht.
	 */
	@Override
	public void destroy() {
		super.destroy();

		this.gameReference.removeGameObject(this.boden1);

		for (Floor element : stairs_l) {
			this.gameReference.removeGameObject(element);
		}

		for (Floor element : stairs_r) {
			this.gameReference.removeGameObject(element);
		}

		if (this.kb.Ketchup != null) {
			this.gameReference.removeGameObject(this.kb.Ketchup);
		}
	}

	/**
	 * Schleife für den Spieler sowie HandleHoldKey
	 */
	@Override
	public void loop() {
		super.loop();
		if (kb.loop(player)) {
			lose();
		}
		player.loop();
		player.handleHoldKey();
	}

	@Override
	public void limitLoop() {
		super.limitLoop();
		if (this.gameReference.zufallsBoolean()) {
			this.kb.throwKetchup();
		}
	}
}
