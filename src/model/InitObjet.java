package model;

import java.sql.ResultSet;
import java.sql.SQLException;


public class InitObjet {
	
	private static ConnexionSingleton connexion;

	public InitObjet(){
		connexion = ConnexionSingleton.getInstance(null);
		createObjet();
		insertObjets();
	}
	
	
	public void createObjet(){
		connexion.executeUpdate("drop table if exists objet");
		connexion.executeUpdate("create table objet (id int,idScene int,coordX int,coordY int,urlImg TEXT,idAction int,visible int)");
	}
	
	public void insertObjets(){
		connexion.executeUpdate("delete from objet");
		

		connexion.executeUpdate("insert into objet values(1,4,884,342, 'Miel.png',0,1)");
		connexion.executeUpdate("insert into objet values(2,5,447,183, 'Personnage.png',17,1)");
		connexion.executeUpdate("insert into objet values(3,6,417,326, 'Personnage1.png',37,1)");
		connexion.executeUpdate("insert into objet values(4,7,460,303, 'Personnage2.png',38,1)");
		connexion.executeUpdate("insert into objet values(5,8,558,70, 'Pokemon1.png',0,1)");
		connexion.executeUpdate("insert into objet values(6,8,86,328, 'Pokemon2.png',0,1)");
		connexion.executeUpdate("insert into objet values(7,8,348,332, 'Pokemon3.png',0,1)");
		connexion.executeUpdate("insert into objet values(8,8,639,338, 'Pokemon4.png',0,1)");
		connexion.executeUpdate("insert into objet values(9,10,0,0, 'Badge1.png',0,1)");
		connexion.executeUpdate("insert into objet values(10,10,0,0, 'Badge2.png',0,1)");
		connexion.executeUpdate("insert into objet values(11,10,0,0, 'Badge3.png',0,1)");
		connexion.executeUpdate("insert into objet values(13,10,0,0, 'Pokemon5.png',0,1)");

		connexion.executeUpdate("insert into objet values(20,1,20,20, 'Bag.png',20,1)");
		connexion.executeUpdate("insert into objet values(21,2,20,20, 'Bag.png',21,1)");
		connexion.executeUpdate("insert into objet values(22,3,20,20, 'Bag.png',22,1)");
		connexion.executeUpdate("insert into objet values(23,4,20,20, 'Bag.png',23,1)");
		connexion.executeUpdate("insert into objet values(24,5,20,20, 'Bag.png',24,1)");
		connexion.executeUpdate("insert into objet values(25,6,20,20, 'Bag.png',25,1)");
		connexion.executeUpdate("insert into objet values(26,7,20,20, 'Bag.png',26,1)");
		connexion.executeUpdate("insert into objet values(27,8,20,20, 'Bag.png',27,1)");
//		connexion.executeUpdate("insert into objet values(28,9,20,20, 'Bag.png', ,1)");
		connexion.executeUpdate("insert into objet values(29,10,20,20, 'Bag.png',28,1)");

	
		connexion.executeUpdate("insert into objet values(14,1,530,70, 'Fleche.png',1,1)");
		connexion.executeUpdate("insert into objet values(15,2,900,350, 'Flechedroite.png',2,1)");
		connexion.executeUpdate("insert into objet values(16,2,448,650, 'Flechebas.png',3,1)");
		connexion.executeUpdate("insert into objet values(17,3,70,320, 'Flechegauche.png',4,1)");
		connexion.executeUpdate("insert into objet values(18,2,305,285, 'Arene1.png',15,1)");
		connexion.executeUpdate("insert into objet values(19,3,430,40, 'Flechehaut.png',16,1)");
		
		connexion.executeUpdate("insert into objet values(12,5,650,650, 'Flechebas.png',33,1)");
		connexion.executeUpdate("insert into objet values(28,4,430,40, 'Flechehaut.png',34,1)");
		connexion.executeUpdate("insert into objet values(30,3,480,650, 'Flechebas.png',32,1)");
		connexion.executeUpdate("insert into objet values(31,4,177,192, 'Maison1.png',35,1)");
		connexion.executeUpdate("insert into objet values(32,4,604,180, 'Maison2.png',36,1)");
		
		connexion.executeUpdate("insert into objet values(33,3,700,115, 'Arene2.png',41,1)");
	}
	
	public static void main(String[] args) {
		InitObjet init = new InitObjet();
	
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
