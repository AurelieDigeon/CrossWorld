package testU;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.ConnexionSingleton;

public class InitDialogueTest {
	
	private static ConnexionSingleton connexion;
	
	public InitDialogueTest(){
		connexion = ConnexionSingleton.getInstance(null);
		createDialogue();
		insertDialogues();
	}
	
	
	public void createDialogue(){
		connexion.executeUpdate("create table dialogue (id int,texte TEXT, question int, idReponse int)");
	}
	
	public void insertDialogues(){
		connexion.executeUpdate("insert into dialogue values(1,'Bienvenue dans le monde de CrossWorld, tu es ici pour vivre une aventure hors du commun, sauras-tu resoudre les enigmes pour pouvoir rentrer chez toi ? Bonne chance dans le monde de CrossWorld.', 0,0)");
		connexion.executeUpdate("insert into dialogue values(2,'Tu ne peux pas encore aller par la, il te faut au moins un badge, va voir du cote de l arene.', 0,0)");
		connexion.executeUpdate("insert into dialogue values(3,'Pour obtenir ton premier badge il te faut resoudre cette enigme : Quel Pokemon manque-t-il ?',1,3)");
		connexion.executeUpdate("insert into dialogue values(4,'Tu ne peux pas encore aller par la, il te faut au moins deux badges, va voir du cote de l arene.',0,0)");
		connexion.executeUpdate("insert into dialogue values(5,'Pour obtenir ton second badge il te faut resoudre cette enigme : Quel Pokemon sera le plus apte a battre ce Caninos ?',0,0)");
		connexion.executeUpdate("insert into dialogue values(6,'Reviens me voir quand tu auras trois badges !',0,0)");
		connexion.executeUpdate("insert into dialogue values(7,'Bravo tu as reussi a reunir trois badges. Tu peux donc continuer ton aventure a travers les mondes de CrossWorld !',0,0)");
		connexion.executeUpdate("insert into dialogue values(8,'Le miel a ete rajoute a votre inventaire.',0,0)");
		connexion.executeUpdate("insert into dialogue values(9,'Bonjour, si tu me ramene un Pikachu je te donnerai un badge !',0,0)");
		connexion.executeUpdate("insert into dialogue values(10,'Bonjour si tu me ramene du miel je te donnerai un Pikachu !',0,0)");
		connexion.executeUpdate("insert into dialogue values(11,'Pikachu a ete rajoute a votre inventaire.',0,0)");
		connexion.executeUpdate("insert into dialogue values(12,'Un badge a ete rajoute a votre inventaire.',0,0)");
	}
	
	public static void main(String[] args) {
	
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
