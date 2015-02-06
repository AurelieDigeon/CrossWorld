package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import view.ReponseImage;



public class GameScene {

	private int id;
	private String urlFond;
	private Dialogue dialogue;
	private List<ReponseImage> reponsesImages;
	private List<Objet> objets;
	private List<Action> actions;
	private ConnexionSingleton connexion;
	private boolean enPause;
	private int idAction;



	public GameScene(ConnexionSingleton connexion, int id, int idAction) {
		this.id = id;
		this.objets = new ArrayList<Objet>();
		this.connexion = connexion;
		this.reponsesImages = new ArrayList<ReponseImage>();
		this.actions = new ArrayList<Action>();
		this.idAction = idAction;
		chargerDonneesSQL();
	}

	private void chargerDonneesSQL() {
		chargerFond();
		chargerObjets();
		chargerActions();
	}



	private void chargerActions() {
		ResultSet rs = connexion.executeQuery("select * from action where idscene= " + id);

		try {
			while(rs.next()) {
				int idaction = rs.getInt("idaction");
				int idscene = rs.getInt("idscene");
				int type = rs.getInt("type");
				int idcible = rs.getInt("idcible");

				Action action = new Action(idaction, type, idcible, idscene);
				System.out.println("action chargé : " + action);
				this.actions.add(action);
			}
		} catch (SQLException e) {
			System.out.println("Erreur lors du chargement des actions");
			e.printStackTrace();
		}
		
	}

	private void chargerFond() {
		ResultSet rs = connexion.executeQuery("select urlFond from scene where id = " + id);

		try {
			if(rs.next()) {
				this.urlFond = rs.getString("urlFond");
			}
		} catch (SQLException e) {
			System.out.println("Erreur lors de la récuperation du fond");
			e.printStackTrace();

		}


	}

	private void chargerObjets() {
		ResultSet rs = connexion.executeQuery("select * from objet where idScene = " + id);
		try {
			while(rs.next()) {
				int id = rs.getInt("id");
				int idScene = rs.getInt("idScene");
				int coordX = rs.getInt("coordx");
				int coordY = rs.getInt("coordy");
				String url = rs.getString("urlImg");
				int visible = rs.getInt("visible");
				int idAction = rs.getInt("idAction");

				Objet objet = new Objet(id, idScene, coordX, coordY, url, visible, idAction);
				System.out.println("objet chargé : " + objet);
				this.objets.add(objet);
			}
		} catch (SQLException e) {
			System.out.println("Erreur lors du chargement des objets");
			e.printStackTrace();
		}

	}

	
	public void afficherDialogue(Dialogue dialogue) {
		this.dialogue = dialogue;
		this.enPause = true;
		
		
		
	}
	
	public void fermerDialogue() {
		System.out.println(enPause);
		this.enPause = false;
		this.dialogue = null;
		System.out.println(enPause);
		
		
	}
	public void viderReponses() {
		this.reponsesImages.clear();
	}



	public int getId() {
		return id;
	}

	public String getFond() {
		return urlFond;
	}


	public void setFond(String fond) {
		this.urlFond = fond;
	}


	public Dialogue getDialogue() {
		return dialogue;
	}


	public void setDialogue(Dialogue dialogue) {
		this.dialogue = dialogue;
	}

	public List<Objet> getObjets() {
		return Collections.unmodifiableList(this.objets);

	}

	public String getUrlFond() {
		return urlFond;
	}

	public List<Action> getActions() {
		return actions;
	}
	public Action getAction(int id){
		for (int i=0; i< actions.size(); i++){
			if (actions.get(i).getIdAction()==id){
				return actions.get(i);
			}
		}
		return null;
	}

	public ConnexionSingleton getConnexion() {
		return connexion;
	}

	public boolean isEnPause() {
		return enPause;
	}

	public void setEnPause(boolean enPause) {
		this.enPause = enPause;
	}

	public void ajouterReponse(Reponse reponse) {
		this.reponsesImages.add(new ReponseImage(reponse));
		
	}

	public List<ReponseImage> getReponsesImages() {
		return reponsesImages;
	}

	public int getIdAction() {
		return this.idAction;
	}

	@Override
	public String toString() {
		return "GameScene [id=" + id + ", urlFond=" + urlFond + ", dialogue="
				+ dialogue + ", reponsesImages=" + reponsesImages + ", objets="
				+ objets + ", actions=" + actions + ", connexion=" + connexion
				+ ", enPause=" + enPause + ", idAction=" + idAction + "]";
	}
	
	
	
	

	
	




}
