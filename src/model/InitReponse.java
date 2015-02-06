package model;

import java.sql.ResultSet;
import java.sql.SQLException;


public class InitReponse {

	private static ConnexionSingleton connexion;
	
	public InitReponse(){
		connexion = ConnexionSingleton.getInstance(null);
		createReponse();
		insertReponses();
	}
	
	
	public void createReponse(){
		connexion.executeUpdate("drop table  if exists reponse");
		connexion.executeUpdate("create table reponse (id int,idDialogue int, texte TEXT,idAction int)");
	}
	
	public void insertReponses(){
		connexion.executeUpdate("delete from reponse");
		connexion.executeUpdate("insert into reponse values(1,3, 'Pikachu',19)");
		connexion.executeUpdate("insert into reponse values(2,3, 'Abra',19)");
		connexion.executeUpdate("insert into reponse values(3,3, 'Conconfort',18)");
		connexion.executeUpdate("insert into reponse values(4,3, 'Mais qu est ce que j en sais ?!',19)");
		
		connexion.executeUpdate("insert into reponse values(5,5, 'Carabaffe',44)");
		connexion.executeUpdate("insert into reponse values(6,5, 'Chenipan',43)");
		connexion.executeUpdate("insert into reponse values(7,5, 'Magicarpe',43)");
	}
	
	public static void main(String[] args) {
		InitReponse init = new InitReponse();
	
		ResultSet rs = connexion.executeQuery("select * from reponse");
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
