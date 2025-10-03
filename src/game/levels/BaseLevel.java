/**
 *  Diese Klasse ist eine Oberklasse für alle Level in diesem Spiel, <br>
 *  Sie beinhaltet automatisch "leere" Methoden für die Erstellung <br>
 *  und Entfernung der Game-Objekte. <br>
 *
 * @author Florian Schieder
 */

package game.levels;

import ea.Bild;
import ea.Sound;
import ea.Text;
import ea.internal.phy.Physik;
import game.core.Assets;
import game.core.Mode;
import game.objects.Dog;
import game.objects.Goal;
import game.screens.HotdogGame;
import game.screens.SplashScreen;

public class BaseLevel {
	// Attribute
	public Bild background;
	public int limit;
	public int levelNumber;
	public Dog player;
	public Goal goal;

	public Text anzeige;
	public Mode mode;
	public Text gameover;
	public HotdogGame gameReference;

	private Sound vSound;

	/**
	 * Konstruktur der Klasse LEVEL.
	 *
	 * @param mode Schwierigkeitsgrad
	 * @param game Referenz auf das Spielobjekt
	 */
	public BaseLevel(Mode mode, HotdogGame game) {
		this.mode = mode;
		this.gameReference = game;

		background = new Bild(0, 0, 1152, 864, Assets.image("background"));
		game.addRaumObjekt(background);
	}

	/**
	 * Die Methode, die den Level und seine Objekte erstellt. In der Basisklasse
	 * hat sie keine Funktion.
	 */
	public void create() {
		vSound = new Sound(Assets.sound("victory"));

		switch (mode) {
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
	 * Die Methode, die den Statustext (je nach aktuellem Limit etc.)
	 * zurückgibt.
	 *
	 * @return Der Statustext für die Anzeige
	 */
	public String getStatus() {
		return mode.toString() + " | LEVEL " + String.valueOf(levelNumber)
				+ " | " + String.valueOf(limit) + "s";
	}

	/**
	 * Die Methode, die gekapselt für alle Level Hintergrundbild und
	 * Zeit-/Levelanzeige verwaltet.
	 */
	public final void start() {
		gameReference.tickerAnmelden(gameReference, 20);

		this.goal.image.neutralMachen();
	}

	/**
	 * Die Methode, die die Hauptschleife des Levels bereitstellt. Diese wird
	 * vom Ticker alle 1000ms (1s) aufgerufen.
	 */
	public void limitLoop() {
		if (limit > 0) {
			limit--;
			anzeige.setzeInhalt(getStatus());
		} else {
			lose();
		}
	}

	public void loop() {
		if (this.player.image.getX() > 1152 || this.player.image.getY() > 864) {
			lose();
		}
		if (this.player.currentSausage != null
				&& (this.player.currentSausage.image.getX() > 1152
						|| this.player.currentSausage.image.getY() > 864)) {
			this.player.currentSausage = null;
		}

		if (this.player.collision(this.goal)) {
			if (vSound != null) { // Nötig, da der Sound sonst keine Ahnung wie
									// oft gespielt wird, da die
									// Kollisionsmethode permanent aufgerufen
									// wird ^^
				vSound.play();
				vSound = null;
			}

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
		Physik.neutralize();
		if (this.gameReference.manager.istAngemeldet(this.gameReference)) {
			this.gameReference.manager.alleAbmelden();
		}

		this.gameReference.removeGameObject(player);
		this.gameReference.removeGameObject(goal);
		this.gameReference.removeRaumObjekt(gameover);
		this.gameReference.removeRaumObjekt(anzeige);

		if (this.player.currentSausage != null) {
			this.gameReference.removeGameObject(this.player.currentSausage);
		}
	}

	/**
	 * Die Methode, die die Hauptschleife des Levels "unterbricht" und das
	 * Verlieren des Spielers behandelt.
	 */
	public final void lose() {
		this.player.DieSound();
		this.gameReference.manager.alleAbmelden();
		gameOverScreen();
	}

	public static BaseLevel nextLevel(BaseLevel level) {
		switch (level.levelNumber) {
		case 0:
			return new Level1(level.mode, level.gameReference);
		case 1:
			return new Level2(level.mode, level.gameReference);
		case 2:
			return new Level3(level.mode, level.gameReference);
		case 3:
			return new Level4(level.mode, level.gameReference);
		default:
			return new SplashScreen(level.mode, level.gameReference);
		}
	}
}