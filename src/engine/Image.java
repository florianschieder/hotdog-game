package engine;

import java.awt.*;
import java.awt.image.*;

import javax.imageio.ImageIO;

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
			prepareImage(bezeichner, w, h)
		);
	}
	
	public static BufferedImage prepareImage(String bezeichner, int width, int height) {
		try {
			BufferedImage img = (BufferedImage) ImageIO.read(Image.class.getResourceAsStream("/assets/images/" + bezeichner + ".png"));
			GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsConfiguration gc = env.getDefaultScreenDevice().getDefaultConfiguration();

			BufferedImage resize = gc.createCompatibleImage(width, height, img.getTransparency());
			Graphics2D g = resize.createGraphics();

			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.drawImage(img, 0, 0, width, height, 0, 0, img.getWidth(), img.getHeight(), null);
			g.dispose();

			return resize;
		} catch(Exception e) {
			return null;
		}
	}
}
