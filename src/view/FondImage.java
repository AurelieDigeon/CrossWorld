package view;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FondImage {

	private ImageIcon image;

	public FondImage(String url) {
		this.image = BoiteAOutils.getImage(url);

	}

	public ImageIcon getImage() {
		return image;
	}



}
