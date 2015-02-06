package testU;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.ConnexionSingleton;

public class InitObjetsTest {
	
	private static ConnexionSingleton connexion;

	public InitObjetsTest(){
		connexion = ConnexionSingleton.getInstance("jdbc:sqlite:test.db");
		createObjet();
		insertObjets();
	}
	
	
	public void createObjet(){
		connexion.executeUpdate("create table objet (id int,idScene int,coordX int,coordY int,urlImg TEXT,idAction int,visible int,inventaire int)");
	}
	
	public void insertObjets(){
		connexion.executeUpdate("insert into objet values(1,4,884,342, 'Miel.png',0,0,1)");
		connexion.executeUpdate("insert into objet values(2,5,447,183, 'Personnage.png',0,0,1)");
		connexion.executeUpdate("insert into objet values(3,6,417,326, 'Personnage1.png',0,0,1)");
		connexion.executeUpdate("insert into objet values(4,7,460,303, 'Personnage2.png',0,0,0)");
		connexion.executeUpdate("insert into objet values(5,8,558,70, 'Pokemon1.png',0,0,0)");
		connexion.executeUpdate("insert into objet values(6,8,86,328, 'Pokemon2.png',0,0,0)");
		connexion.executeUpdate("insert into objet values(7,8,348,332, 'Pokemon3.png',0,0,0)");
		connexion.executeUpdate("insert into objet values(8,8,639,338, 'Pokemon4.png',0,0,0)");
	//	ConnexionSingleton.executeUpdate("insert into objet values(9,10,0,0, 'Pokemon5.png',0,0)");
	}
	
	public static void main(String[] args) {
	
		ResultSet rs = connexion.executeQuery("select * from objet");
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
