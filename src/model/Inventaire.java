package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Inventaire {
	
	
	public ArrayList<Objet> objets;
	private ConnexionSingleton connexion;
	private ArrayList<Objet> inventaire;
	
	public Inventaire(ConnexionSingleton con) {
		this.connexion=con;
		inventaire=new ArrayList<Objet>();
	}	
	public void prendreObjet(Objet objet) {
		connexion.executeUpdate("update objet set scene=99 where id="+objet.getId());
		inventaire.add(objet);
	}
	public void perdreObjet(Objet objet){
		connexion.executeUpdate("update objet set scene=null where id="+objet.getId());
		inventaire.remove(objet);
	}	
	public ArrayList<Objet> getObjets() {
		return objets;
	}

}