package engine;

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
	
	public static java.awt.image.BufferedImage prepareImage(String bezeichner, int width, int height) {
		try {
			java.awt.image.BufferedImage img = (java.awt.image.BufferedImage) javax.imageio.ImageIO.read(Image.class.getResourceAsStream("/assets/images/" + bezeichner + ".png"));
			java.awt.GraphicsEnvironment env = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
			java.awt.GraphicsConfiguration gc = env.getDefaultScreenDevice().getDefaultConfiguration();

			java.awt.image.BufferedImage resize = gc.createCompatibleImage(width, height, img.getTransparency());
			java.awt.Graphics2D g = resize.createGraphics();
			
			g.setRenderingHint(java.awt.RenderingHints.KEY_INTERPOLATION, java.awt.RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			
			if(width > img.getWidth() || height > img.getHeight()) {
				for(int w = 0; w <= (int)(width / img.getWidth()); w++) {
					for(int h = 0; h <= (int)(height / img.getHeight()); h++) {
						g.drawImage(img, w * img.getWidth(), h * img.getHeight(), (w * img.getWidth())+img.getWidth(), (h * img.getHeight())+img.getHeight(), 0, 0, img.getWidth(), img.getHeight(), null);
					}
				}
			} else {
				g.drawImage(img, 0, 0, width, height, 0, 0, img.getWidth(), img.getHeight(), null);
			}
			g.dispose();

			return resize;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
