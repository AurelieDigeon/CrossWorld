package model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnexionSingleton {

	
	private Connection connection = null;
	//private final static String USERBDD="dropthebmvbdd";
	//private final static String MDPBDD="CrossWorld11";
	private String urlbdd="jdbc:sqlite:crossworld.db";
	private ResultSet rs;
	private Statement st;
	private static ConnexionSingleton connexion;
	
	private ConnexionSingleton(String url){
		if(url!=null){
			urlbdd = url;
			
		}
		createConnection();
	}
	
	public static ConnexionSingleton getInstance(String url){
		if (connexion == null){
			connexion = new ConnexionSingleton(url);
		}
		return connexion;
	}
	
	private Connection createConnection(){
		if(connection==null){
			try {
				System.out.println(urlbdd);
				Class.forName("org.sqlite.JDBC");
				connection=DriverManager.getConnection(urlbdd);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e){
				e.printStackTrace();
			}
			
		}
		return connection;
	}
	
	public  ResultSet executeQuery(String query){
		try {
			System.out.println(query);
			st=connection.createStatement();
			rs=st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public  void executeUpdate(String query){
		try {
			st=connection.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  void closeConnection(){
		if(connection!=null){
			try {
				connection.close();
				System.out.println("Connexion fermée");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
//	public static void main(String[] args) {
//		createConnection();
//		rs=executeQuery("SELECT name FROM sqlite_master WHERE type='table'");
//		int i=1;
//		try {
//			while(rs.next()){
//				
//				i++;
//			}
//			if(i==1){
//				executeUpdate("create table dialogue (id INTEGER AUTO_INCREMENT,text TEXT,question INTEGER)");	
//				executeUpdate("create table scenes (id INTEGER AUTO_INCREMENT,urlFond TEXT)");		
//				executeUpdate("create table objets (id INTEGER AUTO_INCREMENT,idScene INTEGER,coordX INTEGER,coordY INTEGER,urlImg TEXT,idAction Integer,visible INTEGER)");
//
//			}
//			remplirTableObjets();
//			remplirTableScenes();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		closeConnection();
//	}
//	
//	public static void remplirTableObjets(){
//		executeUpdate("insert into objets(idScene, coordX, coordY, urlImg, idAction, visible) values (1 , 10 , 10 , '/minionmon.jpg', 1 , 1)");
//	}
//	public static void remplirTableScenes(){
//		executeUpdate("insert into scenes(urlFond) values ('/Scene1.png')");
//	}
	
	

}