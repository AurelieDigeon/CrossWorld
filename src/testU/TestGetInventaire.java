//package testU;
//
//import static org.junit.Assert.*;
//
//import model.ConnexionSingleton;
//import model.Tools;
//
//import org.junit.Before;
//import org.junit.Test;
//
//public class TestGetInventaire {
//
//	private Tools t;
//	private ConnexionSingleton con;
//	@Before
//	
//	public void init(){
//		con=ConnexionSingleton.getInstance("jdbc:sqlite:test.db");
//		new InitObjetsTest();
//		t=new Tools(con);
//		
//
//	}
//	
//	@Test
//	public void test() {
//		int taillelisteInventaire=t.getInventaire().size();
//		assertEquals(3,taillelisteInventaire);
//	}
//
//}
