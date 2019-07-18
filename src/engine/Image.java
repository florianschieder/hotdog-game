package engine;

import java.awt.*;
import java.awt.image.*;

import ea.*;

/**
 * Abstrahierte Klasse für ein Bildelement
 * 
 * @author Florian Schieder
 *
 */
@SuppressWarnings("serial")
public class Image extends Bild {
	/**
	 * Konstruktor der Klasse Image
	 * 
	 * @param x x-Position
	 * @param y y-Position
	 * @param w Breite
	 * @param h Höhe
	 * @param bezeichner
	 */
	public Image(int x, int y, int w, int h, String bezeichner) {
		super(
			x,
			y,
			Bild.resize(
				(BufferedImage) Toolkit.getDefaultToolkit().getImage("/assets/images/" + bezeichner + ".png"),
				w,
				h
			)
		);
	}
}
