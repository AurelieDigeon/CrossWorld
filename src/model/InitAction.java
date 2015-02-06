package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InitAction {
	
private static ConnexionSingleton connexion;
	
	public InitAction(){
		connexion = ConnexionSingleton.getInstance(null);
		createAction();
		insertAction();
	}
	
	
	public void createAction(){
		connexion.executeUpdate("drop table if exists action");
		connexion.executeUpdate("create table action (idaction int,type int, idcible int, idscene int)");
	}
	
	public void insertAction(){
		connexion.executeUpdate("delete from action");
		connexion.executeUpdate("insert into action values(1 , 3 , 2, 1)");
		connexion.executeUpdate("insert into action values(2 , 3 , 3, 2)");
		connexion.executeUpdate("insert into action values(3 , 3 , 1, 2)");
		connexion.executeUpdate("insert into action values(4 , 3 , 2, 3)");
		//action du sac
		connexion.executeUpdate("insert into action values(20 , 3 , 10, 1)");
		connexion.executeUpdate("insert into action values(21 , 3 , 10, 2)");
		connexion.executeUpdate("insert into action values(22 , 3 , 10, 3)");
		connexion.executeUpdate("insert into action values(23 , 3 , 10, 4)");
		connexion.executeUpdate("insert into action values(24 , 3 , 10, 5)");
		connexion.executeUpdate("insert into action values(25 , 3 , 10, 6)");
		connexion.executeUpdate("insert into action values(26 , 3 , 10, 7)");
		connexion.executeUpdate("insert into action values(27 , 3 , 10, 8)");
//		connexion.executeUpdate("insert into action values(5 , 3 , 10, 9)");
		connexion.executeUpdate("insert into action values(28 , 3 , 0, 10)");
		//fin action sac
		
		
		
		connexion.executeUpdate("insert into action values(6 , 3 , 2, 3)");
		connexion.executeUpdate("insert into action values(7 , 3 , 3, 3)");
		connexion.executeUpdate("insert into action values(8 , 3 , 4, 3)");
		connexion.executeUpdate("insert into action values(9 , 3 , 5, 3)");
		connexion.executeUpdate("insert into action values(10 , 3 ,6, 3)");
		connexion.executeUpdate("insert into action values(11, 3 , 7, 3)");
		connexion.executeUpdate("insert into action values(12, 3 , 8, 3)");
		connexion.executeUpdate("insert into action values(13, 3 , 9, 3)");
//		connexion.executeUpdate("insert into action values(14, 3 , 10, 3)");
		connexion.executeUpdate("insert into action values(15, 3 , 9, 2)");
		connexion.executeUpdate("insert into action values(16, 3 , 5, 3)");
		connexion.executeUpdate("insert into action values(17, 1 , 6, 5)");
		
		connexion.executeUpdate("insert into action values(18, 1 , 12, 9)"); //bonne reponse coconfort 
		connexion.executeUpdate("insert into action values(19, 1 , 13, 9)"); //mauvaise reponse coconfort 
		
		//Personnage
		connexion.executeUpdate("insert into action values(29, 1 , 9, 5)");
		
		connexion.executeUpdate("insert into action values(30, 1 , 3, 9)"); //afficher enigme 1
		connexion.executeUpdate("insert into action values(31, 3 , 2, 9)"); //redirige vers scene 2
		
		connexion.executeUpdate("insert into action values(32, 3 , 4, 3)"); //redirige vers scene 4
		connexion.executeUpdate("insert into action values(33, 3 , 3, 5)"); //redirige vers scene 3
		connexion.executeUpdate("insert into action values(34, 3 , 3, 4)"); //redirige vers scene 3

		//maison de la scene 4
		connexion.executeUpdate("insert into action values(35, 3 , 6, 4)");
		connexion.executeUpdate("insert into action values(36, 3 , 7, 4)");
		
		connexion.executeUpdate("insert into action values(37, 1 , 9, 6)"); //bonnome gauche
		connexion.executeUpdate("insert into action values(38, 1 , 10, 7)"); //bonnome gauche
		
		connexion.executeUpdate("insert into action values(39, 3 , 4, 6)"); //bonnome gauche
		connexion.executeUpdate("insert into action values(40, 3 , 4, 7)"); //bonnome gauche
		
		connexion.executeUpdate("insert into action values(41, 3 , 8, 3)");
		connexion.executeUpdate("insert into action values(42, 1 , 5, 8)"); //enigme 2
		
		connexion.executeUpdate("insert into action values(44, 1 , 14, 8)"); //bonne reponse carabaffe 
		connexion.executeUpdate("insert into action values(43, 1 , 15, 8)"); //mauvaise reponse carabaffe 
		
		connexion.executeUpdate("insert into action values(45, 3 , 3, 8)"); 
		connexion.executeUpdate("insert into action values(46, 1 , 5, 8)"); //bonne reponse carabaffe 
		
		connexion.executeUpdate("insert into action values(28, 3 , 0, 10)");

	}
	
	public static void main(String[] args) {
		InitAction init = new InitAction();
	
		ResultSet rs = connexion.executeQuery("select * from action");
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
