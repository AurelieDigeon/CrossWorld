package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.Dialogue;
import model.GameManager;
import model.GameScene;
import model.Objet;
import model.Question;
import model.Reponse;
import controler.GamePanelMouseMotionControler;

public class GamePanel extends JPanel implements Observer{

	private GameManager gameManager;
	private ImageManager imageManager;

	public GamePanel() {
		this.gameManager = new GameManager();
		gameManager.addObserver(this);
		imageManager = new ImageManager(gameManager);
		this.addMouseMotionListener(new GamePanelMouseMotionControler(imageManager, gameManager));
		this.addMouseListener(new GamePanelMouseMotionControler(imageManager, gameManager));

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		GameScene sceneActuelle = gameManager.getSceneActuelle();

		g.drawImage(imageManager.getFond(sceneActuelle.getId()).getImage(), 0, 0, 1024, 768, null);


		if(sceneActuelle.getId()==10){
			int i=0;

			for(Objet objet : sceneActuelle.getObjets()) {
				ImageIcon image = imageManager.getImage(objet.getId());
				if(objet.getId()>=20&&objet.getId()<=29){
					g.drawImage(image.getImage() , objet.getX(), objet.getY(), image.getIconWidth(), image.getIconHeight(), null);
				}else{
					if(i<=2){
						g.drawImage(image.getImage() , 340+(i*120), 245, 100, 100, null);
					}else if(i<=5){
						g.drawImage(image.getImage() , 340+(i%3*120), 350, 100, 100, null);

					}else{
						g.drawImage(image.getImage() , 340+(i%3*120), 455, 100, 100, null);

					}
				}
				i++;
			}



		}else{
			for(Objet objet : sceneActuelle.getObjets()) {
				if(objet.isVisible()){
					ImageIcon image = imageManager.getImage(objet.getId());
					g.drawImage(image.getImage() , objet.getX(), objet.getY(), image.getIconWidth(), image.getIconHeight(), null);
				}
			}

			//			Objet sac=sceneActuelle.getObjets().get(12);
			//			ImageIcon image = imageManager.getImage(sac.getId());
			//
			//			g.drawImage(image.getImage() , sac.getX(), sac.getY(), image.getIconWidth(), image.getIconHeight(), null);


			//			

		}

		GameScene actuel = gameManager.getSceneActuelle();
		if(actuel.isEnPause() && actuel.getDialogue() != null) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setFont(new Font("Serif", Font.BOLD, 25));
//			g2.setPaint(Color.black);
//			drawString(g2,"Line 1\nLine 2", 120, 120);
			
			
			Dialogue dialogue = gameManager.getSceneActuelle().getDialogue();
			System.out.println(dialogue.getTexte());
			
			g2.setPaint(new Color(249, 232, 248));
			g.fillRect(0, 500, GameFrame.LONGUEUR, 300);
			g2.setPaint(Color.black);
			ImageIcon dial = BoiteAOutils.getImage("DialogueHaut.png");
			g.drawImage(dial.getImage(), 0, 500, dial.getIconWidth(), dial.getIconHeight(), null);
			dial = BoiteAOutils.getImage("Dialoguecote.png");
			g.drawImage(dial.getImage(), 0, 554, dial.getIconWidth() + 12, dial.getIconHeight(), null);
			g.drawImage(dial.getImage(), 978, 554, dial.getIconWidth() +11, dial.getIconHeight(), null);
			dial = BoiteAOutils.getImage("DialogueBas.png");
			g.drawImage(dial.getImage(), 0, 700, dial.getIconWidth(), dial.getIconHeight(), null);
			
			if(gameManager.estDialogue()){
				drawString(g2, dialogue.getTexte(), 40, 530);
				//			actuel.setEnPause(false);
				//			actuel.setDialogue(null);
			} else {
				g2.setFont(new Font("Serif", Font.BOLD, 23));
				Question quest = (Question) sceneActuelle.getDialogue();
				List<Reponse> reponses = quest.getReponses();
				
				drawString(g2, quest.getTexte(), 40, 530);
				
				for(Reponse reponse : reponses) {
					System.out.println(reponse.getX());
					System.out.println(reponse.getY());
					drawString(g2, reponse.getTexte(), reponse.getX(), reponse.getY());
				}
				
				
				
			}
		}



	}

	
	private void drawString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\n"))
			g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}

	private void drawtabString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\t"))
			g.drawString(line, x += g.getFontMetrics().getHeight(), y);
	}


	

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();

	}



	public GameManager getGameManager() {
		return gameManager;
	}



}
