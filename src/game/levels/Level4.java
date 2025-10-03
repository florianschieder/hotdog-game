/**
 * Level 4 wie Level 2, nur gemeiner...
 *
 * @author Dennis Simontowsky
 */

package game.levels;

import game.core.Mode;
import game.objects.Dog;
import game.objects.Enemy;
import game.objects.Floor;
import game.objects.Goal;
import game.objects.SausageStall;
import game.screens.HotdogGame;

public class Level4 extends BaseLevel {
	private Floor boden1;
	private Floor boden2;
	private Floor boden3;
	private Floor[] stairs;

	private Enemy enemy1;
	private Enemy enemy2;
	private Enemy enemy3;
	private Enemy enemy4;
	private Enemy enemy5;
	private Enemy enemy6;

	private SausageStall stall;

	/**
	 * Konstruktur der Klasse LEVEL4.
	 *
	 * @param mode Schwierigkeitsgrad
	 * @param game Referenz auf das Spielobjekt
	 */
	public Level4(Mode mode, HotdogGame game) {
		super(mode, game);

		this.levelNumber = 4;
		this.stairs = new Floor[100];
		this.create();
	}

	/**
	 * Die Methode, die den Level und seine Objekte erstellt.
	 */
	@Override
	public void create() {
		super.create();

		this.player = new Dog(0, 0, this.gameReference);
		this.gameReference.addGameObject(this.player);

		this.boden1 = new Floor(0, 812, 1152, 52);
		this.gameReference.addGameObject(this.boden1);

		this.boden2 = new Floor(152, 700, 800, 52);
		this.gameReference.addGameObject(this.boden2);

		this.boden3 = new Floor(60, -10, 58, 12 * 58);
		this.gameReference.addGameObject(this.boden3);

		this.enemy1 = new Enemy(150 + this.gameReference.zufallsZahl(1000),
				812);
		this.gameReference.addGameObject(this.enemy1);

		this.enemy2 = new Enemy(150 + this.gameReference.zufallsZahl(1000),
				200);
		this.gameReference.addGameObject(this.enemy2);

		this.enemy3 = new Enemy(150 + this.gameReference.zufallsZahl(1000), 0);
		this.gameReference.addGameObject(this.enemy3);

		this.enemy4 = new Enemy(150 + this.gameReference.zufallsZahl(1000),
				this.gameReference.zufallsZahl(300));
		this.gameReference.addGameObject(this.enemy4);

		this.enemy5 = new Enemy(150 + this.gameReference.zufallsZahl(1000),
				this.gameReference.zufallsZahl(500));
		this.gameReference.addGameObject(this.enemy5);

		this.enemy6 = new Enemy(150 + this.gameReference.zufallsZahl(1000),
				this.gameReference.zufallsZahl(800));
		this.gameReference.addGameObject(this.enemy6);

		this.stall = new SausageStall(1050, 550, this.mode, this.gameReference);
		this.gameReference.addGameObject(this.stall);

		for (int i = 0; i < stairs.length; i++) {
			stairs[i] = new Floor(300 + 10 * i, 600 - 5 * i, 40, 52);
			this.gameReference.addGameObject(stairs[i]);
		}

		this.goal = new Goal(1100, 0);
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

		if (this.enemy1 != null) {
			this.gameReference.removeGameObject(this.enemy1);
		}
		if (this.enemy2 != null) {
			this.gameReference.removeGameObject(this.enemy2);
		}
		if (this.enemy3 != null) {
			this.gameReference.removeGameObject(this.enemy3);
		}
		if (this.enemy4 != null) {
			this.gameReference.removeGameObject(this.enemy4);
		}
		if (this.enemy5 != null) {
			this.gameReference.removeGameObject(this.enemy5);
		}
		if (this.enemy6 != null) {
			this.gameReference.removeGameObject(this.enemy6);
		}

		this.gameReference.removeGameObject(this.stall);

		for (Floor stair : stairs) {
			this.gameReference.removeGameObject(stair);
		}
	}

	@Override
	public void limitLoop() {
		super.limitLoop();

		if (this.mode == Mode.Hard || this.mode == Mode.Extreme) {
			if (enemy1 != null) {
				enemy1.image.sprung((this.mode == Mode.Extreme)
						? this.gameReference.zufallsZahl(20)
						: 5);
			}
			if (enemy2 != null) {
				enemy2.image.sprung((this.mode == Mode.Extreme)
						? this.gameReference.zufallsZahl(20)
						: 5);
			}
			if (enemy3 != null) {
				enemy3.image.sprung((this.mode == Mode.Extreme)
						? this.gameReference.zufallsZahl(20)
						: 5);
			}
			if (enemy4 != null) {
				enemy4.image.sprung((this.mode == Mode.Extreme)
						? this.gameReference.zufallsZahl(20)
						: 5);
			}
			if (enemy5 != null) {
				enemy5.image.sprung((this.mode == Mode.Extreme)
						? this.gameReference.zufallsZahl(20)
						: 5);
			}
			if (enemy6 != null) {
				enemy6.image.sprung((this.mode == Mode.Extreme)
						? this.gameReference.zufallsZahl(20)
						: 5);
			}
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

		if (this.player.currentSausage != null && this.enemy1 != null
				&& this.player.currentSausage.collision(this.enemy1)) {
			this.gameReference.removeGameObject(this.enemy1);
			this.enemy1 = null;
			this.gameReference.removeGameObject(this.player.currentSausage);
			this.player.currentSausage = null;
		}

		if (this.enemy1 != null && this.player.collision(this.enemy1)) {
			this.lose();
		}

		if (this.player.currentSausage != null && this.enemy2 != null
				&& this.player.currentSausage.collision(this.enemy2)) {
			this.gameReference.removeGameObject(this.enemy2);
			this.enemy2 = null;
			this.gameReference.removeGameObject(this.player.currentSausage);
			this.player.currentSausage = null;
		}

		if (this.enemy2 != null && this.player.collision(this.enemy2)) {
			this.lose();
		}

		if (this.player.currentSausage != null && this.enemy3 != null
				&& this.player.currentSausage.collision(this.enemy3)) {
			this.gameReference.removeGameObject(this.enemy3);
			this.enemy3 = null;
			this.gameReference.removeGameObject(this.player.currentSausage);
			this.player.currentSausage = null;
		}

		if (this.enemy3 != null && this.player.collision(this.enemy3)) {
			this.lose();
		}

		if (this.player.currentSausage != null && this.enemy4 != null
				&& this.player.currentSausage.collision(this.enemy4)) {
			this.gameReference.removeGameObject(this.enemy4);
			this.enemy4 = null;
			this.gameReference.removeGameObject(this.player.currentSausage);
			this.player.currentSausage = null;
		}

		if (this.enemy4 != null && this.player.collision(this.enemy4)) {
			this.lose();
		}

		if (this.player.currentSausage != null && this.enemy5 != null
				&& this.player.currentSausage.collision(this.enemy5)) {
			this.gameReference.removeGameObject(this.enemy5);
			this.enemy5 = null;
			this.gameReference.removeGameObject(this.player.currentSausage);
			this.player.currentSausage = null;
		}

		if (this.enemy5 != null && this.player.collision(this.enemy5)) {
			this.lose();
		}

		if (this.player.currentSausage != null && this.enemy6 != null
				&& this.player.currentSausage.collision(this.enemy6)) {
			this.gameReference.removeGameObject(this.enemy6);
			this.enemy6 = null;
			this.gameReference.removeGameObject(this.player.currentSausage);
			this.player.currentSausage = null;
		}

		if (this.enemy6 != null && this.player.collision(this.enemy6)) {
			this.lose();
		}

		if (player.collision(this.stall)) {
			this.player.sausages += this.stall.grabSausages();
		}
	}
}
