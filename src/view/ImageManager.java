package view;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

import model.GameManager;
import model.GameScene;
import model.Objet;

public class ImageManager {
	
	private HashMap<Integer, FondImage> fonds;
	private HashMap<Integer, ObjetImage> images;
	private GameManager gameManager;
	
	public ImageManager(GameManager gameManager) {
		this.gameManager = gameManager;
		this.fonds = new HashMap<Integer, FondImage>();
		this.images = new HashMap<Integer, ObjetImage>();
		chargerImages();
		
		afficherImage();
		
	}

	private void afficherImage() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Objet affiché n° " + i + ": " + images.get(i));
			
		}
		
		
	}
	
	private void chargerImages() {
		for(GameScene scene : gameManager.getScenes()) {
			
			fonds.put(scene.getId(), new FondImage(scene.getFond()));
			for(Objet objet : scene.getObjets()) {
				this.images.put(objet.getId(), new ObjetImage(objet));
//				System.out.println(images.get("Objet Image chargé :"  + objet.getId()));
			}
		}
	}
	
	
	public ImageIcon getImage(int id) {
		return this.images.get(id).getImage();
	}
	
	public ImageIcon getFond(int id) {
		return this.fonds.get(id).getImage();
	}

	public HashMap<Integer, ObjetImage> getImages() {
		return images;
	}
	
	
	

}
