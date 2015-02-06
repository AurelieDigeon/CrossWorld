package testU;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.ConnexionSingleton;

public class InitReponsesTest {

	private static ConnexionSingleton connexion;
	
	public InitReponsesTest(){
		connexion = ConnexionSingleton.getInstance(null);
		createReponse();
		insertReponses();
	}
	
	
	public void createReponse(){
		connexion.executeUpdate("create table reponse (id int,idDialogue int, texte TEXT,idAction int)");
	}
	
	public void insertReponses(){
		connexion.executeUpdate("insert into reponse values(1,3, 'Pikachu',0)");
		connexion.executeUpdate("insert into reponse values(2,3, 'Abra',0)");
		connexion.executeUpdate("insert into reponse values(3,3, 'Conconfort',0)");
		connexion.executeUpdate("insert into reponse values(4,3, 'Mais qu est ce que j en sais ?!',0)");
	}
	
	public static void main(String[] args) {
	
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
