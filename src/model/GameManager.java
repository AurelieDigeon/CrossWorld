package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

import javax.xml.ws.soap.AddressingFeature.Responses;


public class GameManager extends Observable{




	private GameScene sceneActuelle;
	private GameScene scenePrecedente;
	private List<GameScene> scenes;
	private ConnexionSingleton connexion;
	private Inventaire inventaire;

	public ConnexionSingleton getConnexion() {
		return connexion;
	}


	public GameManager() {

		this.connexion = ConnexionSingleton.getInstance(null);
		this.scenes = new ArrayList<GameScene>();
		this.sceneActuelle = null;
		this.scenePrecedente = null;
		remplirScenes();

		inventaire= new Inventaire(connexion);

	}


	private void remplirScenes() {
		ResultSet rs = connexion.executeQuery("select distinct * from scene");

		try {
			while(rs.next()) {
				if(rs.getInt("id")!=1000){
					int id = rs.getInt("id");
					System.out.println(id);
					this.scenes.add(new GameScene(connexion, id, rs.getInt("idaction")));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		setSceneActuelle(3);
//		setScenePrecedente(sceneActuelle);
		
		for(GameScene scene : scenes) {
			System.out.println(scene);
		}

		//		THIS.SCENES.ADD(NEW GAMESCENE(CONNEXION, ENUMSCENES.ACCUEILSCENE));
		//		THIS.SCENES.ADD(NEW GAMESCENE(CONNEXION, ENUMSCENES.SELECTPERSOSCENE));
		//		THIS.SCENES.ADD(NEW GAMESCENE(CONNEXION, ENUMSCENES.POKEMONSCENE1));
		//		THIS.SCENES.ADD(NEW GAMESCENE(CONNEXION, ENUMSCENES.POKEMONSCENE2));
		//		THIS.SCENES.ADD(NEW GAMESCENE(CONNEXION, ENUMSCENES.POKEMONSCENE3));
		//		THIS.SCENES.ADD(NEW GAMESCENE(CONNEXION, ENUMSCENES.POKEMONSCENE4));
		//		THIS.SCENES.ADD(NEW GAMESCENE(CONNEXION, ENUMSCENES.POKEMONSCENE5));
		//		THIS.SCENES.ADD(NEW GAMESCENE(CONNEXION, ENUMSCENES.POKEMONSCENE6));
		//		THIS.SCENES.ADD(NEW GAMESCENE(CONNEXION, ENUMSCENES.POKEMONSCENE7));
		//		THIS.SCENES.ADD(NEW GAMESCENE(CONNEXION, ENUMSCENES.POKEMONENIGME1));
		//		THIS.SCENES.ADD(NEW GAMESCENE(CONNEXION, ENUMSCENES.POKEMONENIGME2));





	}

	public void afficherDialogue(int idDialogue) {
		getSceneActuelle().viderReponses();
		if(idDialogue >= 1) { 
			ResultSet rs = connexion.executeQuery("select * from dialogue where id = " + idDialogue);
			int id = 0;
			String texte = null;
			int question = 0;
			int bonneReponse = 0;
			int idAction = 0;
			try {
				rs.next();
				id = rs.getInt("id");
				texte = rs.getString("texte");
				question = rs.getInt("question");
				bonneReponse = rs.getInt("idReponse");
				idAction = rs.getInt("idAction");
			} catch (SQLException e1) {
				System.out.println("Erreur lors de la récolte des infos sur le dialogue");
				e1.printStackTrace();
			}

			if(question == 0) {
				Dialogue dialogue = new Dialogue(id, texte, question, bonneReponse, idAction);
				sceneActuelle.afficherDialogue(dialogue);

			} else {
				rs = connexion.executeQuery("select * from reponse where idDialogue = " + id);
				List<Reponse> reponses = new ArrayList<Reponse>();

				try{
					int i = 0;
					sceneActuelle.viderReponses();
					while(rs.next()) {
						int rid = rs.getInt("id");
						int ridDialogue = rs.getInt("idDialogue");
						String rtexte = rs.getString("texte");
						int ridAction = rs.getInt("idAction");

						Reponse rep = new Reponse(rid, ridDialogue, rtexte, ridAction, i);
						reponses.add(rep);
						sceneActuelle.ajouterReponse(rep);

						System.out.println(i);
						i++;
					}
				} catch(SQLException e) {
					System.out.println("erreur lors de la création de la question");
					e.printStackTrace();
				}

				Question questionO = new Question(id, texte, question, reponses, bonneReponse);
				sceneActuelle.afficherDialogue(questionO);
			}
		}





		notifier();
	}

	public void fermerDialogue() {
		int idAction = sceneActuelle.getDialogue().getIdAction();
		this.sceneActuelle.fermerDialogue();
		sceneActuelle.viderReponses();
		if(idAction > 0) {
			int type = getSceneActuelle().getAction(idAction).getType();
			System.out.println(type);
			switch (type) {
			case 1:
				//			System.out.println(getSceneActuelle().getAction(getSceneActuelle().getIdAction()).getIdCible());
				afficherDialogue(getSceneActuelle().getAction(idAction).getIdCible());
				return;

			case 2:
				//			getInventaire().prendreObjet(image.getObjetModele());
				break;
			case 3:
							System.out.println("action changement de scene");
							if(getSceneActuelle().getId()==10){
								setSceneActuelle(getScenePrecedente().getAction(idAction).getIdCible());
							}else{
								setScenePrecedente(getSceneActuelle());
								setSceneActuelle(getSceneActuelle().getAction(idAction).getIdCible());
							}
				break;
			default:
				break;
			}
		}
		notifier();

	}

	public void setSceneActuelle(int id) {
		this.sceneActuelle = scenes.get(id - 1);
		System.out.println("scene actuel :" + sceneActuelle.getId());
//		notifier();
		System.out.println(getSceneActuelle().getIdAction());
		if(getSceneActuelle().getIdAction() > 0) {
			int type = getSceneActuelle().getAction(getSceneActuelle().getIdAction()).getType();
			System.out.println(type);
			switch (type) {
			case 1:
				//			System.out.println(getSceneActuelle().getAction(getSceneActuelle().getIdAction()).getIdCible());
				afficherDialogue(getSceneActuelle().getAction(getSceneActuelle().getIdAction()).getIdCible());
				return;

			case 2:
				//			getInventaire().prendreObjet(image.getObjetModele());
				break;
			case 3:
				//			System.out.println("action changement de scene");
				//			if(gameManager.getSceneActuelle().getId()==10){
				//				gameManager.setSceneActuelle(gameManager.getScenePrecedente().getAction(image.getObjetModele().getIdAction()).getIdCible());
				//			}else{
				//				gameManager.setScenePrecedente(gameManager.getSceneActuelle());
				//				gameManager.setSceneActuelle(gameManager.getSceneActuelle().getAction(image.getObjetModele().getIdAction()).getIdCible());
				//			}
				break;
			default:
				break;
			}
		}
		
		notifier();

	}

	public GameScene getSceneActuelle() {
		return this.sceneActuelle;

	}

	private void notifier() {
		setChanged();
		notifyObservers();

	}

	public List<GameScene> getScenes() {
		return Collections.unmodifiableList(scenes);
	}

	public Inventaire getInventaire(){
		return inventaire;
	}

	public GameScene getScenePrecedente(){
		return scenePrecedente;
	}


	public void setScenePrecedente(GameScene scenePrecedente){
		this.scenePrecedente=scenePrecedente;
		connexion.executeUpdate("update action set idcible = " + scenePrecedente.getId() + " where idaction = " + 28);
	}


	public boolean estDialogue() {
		return !(sceneActuelle.getDialogue() instanceof Question);
	}
}
