package view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoiteAOutils {
	
	
	
	
	public static ImageIcon getImage(String url) {
		System.out.println("/" + url);
		return new ImageIcon(BoiteAOutils.class.getResource("/" + url));
	}
	
	public static void drawImage(Graphics g, String image, int x, int y, int width, int height) {
		g.drawImage(getImage(image).getImage(), x, y, width, height, null);
	}
	
	public static void drawFond(Graphics g, String fond) {
		g.drawImage(getImage(fond).getImage(), 0, 0, 1024, 728, null);
	}

}
