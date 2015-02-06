//package model;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//
//public class Tools {
//	String texte;
//	private Inventaire data;
//	public ArrayList<String> reponses;
//
//
//	public Tools(ConnexionSingleton c){
//		data.connexion=c;
//	}
//	
//
//
//	public Dialogue getDialog(int id){
//		ResultSet rs1=data.connexion.executeQuery("select * from dialogue where id="+id);
//		try {
//			rs1.next();
//			if(rs1.getInt("question")==0){
//				texte=rs1.getString("texte");
//				return new Dialogue(texte);
//			}
//			else{
//				ResultSet rs2=data.connexion.executeQuery("select * from reponses where idDialogue="+id);
//				texte=rs1.getString("texte");
//				while(rs2.next()){
//					reponses.add(rs2.getString("texte"));
//					
//				}
//				return new Questions(texte,reponses);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//
//	}
//
//
//	public void prendreObjet(int id) {
//		data.connexion.executeUpdate("update objet set inventaire=1 where id="+id);
//	}
//	
//	public void perdreObjet(int id){
//		data.connexion.executeUpdate("update objet set inventaire=0 where id="+id);
//
//	}
//	
//	public ArrayList<Objet> getInventaire(){
//		ArrayList<Objet> inventaire=new ArrayList<Objet>();
//		ResultSet rs=data.connexion.executeQuery("select * from objet where inventaire=1");
//		try {
//			while(rs.next()){
//				inventaire.add(new Objet(rs.getInt("id"), rs.getInt("idScene"), rs.getInt("coordX"), rs.getInt("coordY"), rs.getString("urlImg"), rs.getBoolean("idAction"), rs.getInt("visible")));
//			}
//		} catch (SQLException e) {
//			System.out.println("Erreur sur le resultSet : "+e.getMessage());
//		}
//
//		return inventaire;
//	}
//	
//	
//	
//	
//
//}
