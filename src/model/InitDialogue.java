package model;

import java.sql.ResultSet;
import java.sql.SQLException;


public class InitDialogue {
	
	private static ConnexionSingleton connexion;
	
	public InitDialogue(){
		connexion = ConnexionSingleton.getInstance(null);
		createDialogue();
		insertDialogues();
	}
	
	
	public void createDialogue(){
		connexion.executeUpdate("drop table  if exists dialogue");
		connexion.executeUpdate("create table dialogue (id int,texte TEXT, question int, idReponse int, idAction int)");
	}
	
	public void insertDialogues(){
		connexion.executeUpdate("delete from dialogue");
		connexion.executeUpdate("insert into dialogue values(1,'Bienvenue dans le monde de CrossWorld, tu es ici pour vivre une aventure hors du \ncommun, sauras-tu resoudre les enigmes pour pouvoir rentrer chez toi ? Bonne chance \ndans le monde de CrossWorld.', 0,0, 0)");
		connexion.executeUpdate("insert into dialogue values(2,'Tu ne peux pas encore aller par la, il te faut au moins un badge, va voir du cote de l arene.', 0,0, 0)");
		connexion.executeUpdate("insert into dialogue values(3,'Pour obtenir ton premier badge il te faut resoudre cette enigme : Quel Pokemon manque-t-il ?',1,3, 0)");
		connexion.executeUpdate("insert into dialogue values(4,'Tu ne peux pas encore aller par la, il te faut au moins deux badges, va voir du cote de l arene.',0,0, 0)");
		connexion.executeUpdate("insert into dialogue values(5,'Quel Pokemon sera le plus apte a battre ce Caninos ?',1,0, 0)");
		connexion.executeUpdate("insert into dialogue values(6,'Reviens me voir quand tu auras trois badges !',0,0, 0)");
		connexion.executeUpdate("insert into dialogue values(7,'Bravo tu as reussi a reunir trois badges. Tu peux donc continuer ton aventure a travers les mondes de CrossWorld !',0,0, 0)");
		connexion.executeUpdate("insert into dialogue values(8,'Le miel a ete rajoute a votre inventaire.',0,0, 0)");
		connexion.executeUpdate("insert into dialogue values(9,'Bonjour, si tu me ramene un Pikachu je te donnerai un badge !',0,0, 39)");
		connexion.executeUpdate("insert into dialogue values(10,'Bonjour si tu me ramene du miel je te donnerai un Pikachu !',0,0, 40)");
		connexion.executeUpdate("insert into dialogue values(11,'Pikachu a ete rajoute a votre inventaire.',0,0, 0)");
		connexion.executeUpdate("insert into dialogue values(12,'Un badge a ete rajoute a votre inventaire.',0,0, 31)");
		connexion.executeUpdate("insert into dialogue values(13,'Mauvaise reponse a l enigme !', 0, 0, 30)");
		
		connexion.executeUpdate("insert into dialogue values(14,'Un badge a ete rajoute a votre inventaire.',0,0, 45)");
		connexion.executeUpdate("insert into dialogue values(15,'Mauvaise reponse a l enigme !', 0, 0, 46)");
	}
	
	public static void main(String[] args) {
		InitDialogue init = new InitDialogue();
	
		ResultSet rs = connexion.executeQuery("select * from dialogue");
		try {
			while(rs.next()) {
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				System.out.print(rs.getObject(i) + "\t");
				}
			
			System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		connexion.closeConnection();
	}
}
