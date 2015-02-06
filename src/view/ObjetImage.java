package view;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import model.Objet;

public class ObjetImage extends Rectangle {

	private ImageIcon image;
	private Objet objetModele;

	public ObjetImage(Objet objet) {
		this.objetModele = objet;
		this.image = BoiteAOutils.getImage(objet.getUrl());
		this.setBounds(objetModele.getX(), objetModele.getY(), image.getIconWidth(), image.getIconHeight());
	}

	public ImageIcon getImage() {
		return image;
		
	}
	
	

	public Objet getObjetModele() {
		return objetModele;
	}

	@Override
	public String toString() {
		return "ObjetImage [image=" + image + "]";
	}
	
	
	
	
	
	
	
}
