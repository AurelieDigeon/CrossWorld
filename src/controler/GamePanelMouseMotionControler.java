package controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.List;

import model.GameManager;
import model.Question;
import view.ImageManager;
import view.ObjetImage;
import view.ReponseImage;

public class GamePanelMouseMotionControler implements MouseMotionListener, MouseListener {

	private ImageManager imageManager;
	private GameManager gameManager;


	public GamePanelMouseMotionControler(ImageManager imageManager, GameManager gameManager) {
		this.imageManager = imageManager;
		this.gameManager = gameManager;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {}

	@Override
	public void mouseMoved(MouseEvent event) {
		HashMap<Integer, ObjetImage> images = imageManager.getImages();
		for (Integer mapKey : images.keySet()) {		
			ObjetImage image = images.get(mapKey);
			//System.out.println("Je bouge idimage ="+ image.getObjetModele().getIdScene()+" et idsceneactu= "+gameManager.getSceneActuelle().getId());

			if (image.getObjetModele().getIdScene() == gameManager.getSceneActuelle().getId() 
					&& !gameManager.getSceneActuelle().isEnPause()
					&& image.getObjetModele().isVisible()
					&& image.contains(event.getPoint())){

				System.out.println("Je suis sur l'object "+image.getObjetModele().getId());
				//	            gamePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			} else {
				//gamePanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

			}
		}


	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent event) {
		HashMap<Integer, ObjetImage> images = imageManager.getImages();
		for (Integer mapKey : images.keySet()) {		
			ObjetImage image = images.get(mapKey);	
			if(!gameManager.getSceneActuelle().isEnPause()) {

				if (image.getObjetModele().getIdScene() == gameManager.getSceneActuelle().getId() 

						&& image.getObjetModele().isVisible()
						&& image.contains(event.getPoint())){

					

					System.out.println("Click");
					System.out.println(image.getObjetModele().getIdAction());
					int type = gameManager.getSceneActuelle().getAction(image.getObjetModele().getIdAction()).getType();
					System.out.println(type);
					switch (type) {
					case 1:
						System.out.println(gameManager.getSceneActuelle().getAction(image.getObjetModele().getIdAction()).getIdCible());
						gameManager.afficherDialogue(gameManager.getSceneActuelle().getAction(image.getObjetModele().getIdAction()).getIdCible());
						return;

					case 2:
						gameManager.getInventaire().prendreObjet(image.getObjetModele());
						break;
					case 3:
						System.out.println("action changement de scene");
						if(gameManager.getSceneActuelle().getId()==10){
							gameManager.setSceneActuelle(gameManager.getScenePrecedente().getAction(image.getObjetModele().getIdAction()).getIdCible());
						}else{
							gameManager.setScenePrecedente(gameManager.getSceneActuelle());
							gameManager.setSceneActuelle(gameManager.getSceneActuelle().getAction(image.getObjetModele().getIdAction()).getIdCible());
						}
						break;
					default:
						break;
					}
				}

			} else {
				System.out.println("est dialogue :" + gameManager.estDialogue());
				if(gameManager.estDialogue()) {
					gameManager.fermerDialogue();
				} else {
					List<ReponseImage> reponses = gameManager.getSceneActuelle().getReponsesImages();
					for(ReponseImage reponse : reponses) {
						if(reponse.contains(event.getPoint())) {
							gameManager.fermerDialogue();
							System.out.println(reponse.getReponseModel().getIdAction());
							int type = gameManager.getSceneActuelle().getAction(reponse.getReponseModel().getIdAction()).getType();
							switch (type) {
							case 1:
								gameManager.afficherDialogue(gameManager.getSceneActuelle().getAction(reponse.getReponseModel().getIdAction()).getIdCible());
								return;
							case 2:
								//								gameManager.getInventaire().prendreObjet(image.getObjetModele());
								System.out.println("On ne peut pas encore ajouter dobjet a linventaire après une bonne réponse !");
								break;
							case 3:
								System.out.println("action changement de scene");
								gameManager.setSceneActuelle(gameManager.getScenePrecedente().getAction(reponse.getReponseModel().getIdAction()).getIdCible());
								break;
							default:
								break;
							}


						}



					}
					
//					
					
				}
			}
		}
	}

}
