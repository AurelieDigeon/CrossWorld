package model;

import java.sql.ResultSet;
import java.sql.SQLException;


public class InitScene {
	
	private static ConnexionSingleton connexion;
	
	public InitScene(){
		connexion = ConnexionSingleton.getInstance(null);
		createScene();
		insertScenes();
	}
	
	public void createScene(){
		connexion.executeUpdate("drop table  if exists scene");
		connexion.executeUpdate("create table scene(id int, urlFond TEXT, idaction int)");
	}
	
	public void insertScenes(){
		connexion.executeUpdate("delete from scene");
		connexion.executeUpdate("insert into scene values(1, 'Scene1.png', 0)");
		connexion.executeUpdate("insert into scene values(2, 'Scene2.png', 0)");
		connexion.executeUpdate("insert into scene values(3, 'Scene3.png', 0)");
		connexion.executeUpdate("insert into scene values(4, 'Scene4.png', 0)");
		connexion.executeUpdate("insert into scene values(5, 'Scene5.png', 0)");
		connexion.executeUpdate("insert into scene values(6, 'Scene6.png', 0)");
		connexion.executeUpdate("insert into scene values(7, 'Scene7.png', 0)");
		connexion.executeUpdate("insert into scene values(8, 'Enigme2.png', 42)");
		connexion.executeUpdate("insert into scene values(9, 'Enigme1.png', 30)");	
		connexion.executeUpdate("insert into scene values(10, 'Inventaire.png', 0)");
	}
	
	
	public static void main(String[] args) {
		InitScene init = new InitScene();
		
		ResultSet rs = connexion.executeQuery("select * from scene");
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
