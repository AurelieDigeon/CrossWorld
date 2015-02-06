//package testU;
//
//import model.ConnexionSingleton;
//import model.Questions;
//import model.Tools;
//
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class TestGetDialogue {
//
//	private Tools t;
//	private ConnexionSingleton con;
//	
//	@Before
//	public void init(){
//		con=ConnexionSingleton.getInstance("jdbc:sqlite:test.db");
//		new InitDialogueTest();
//		new InitReponsesTest();
//		t=new Tools(con);
//		
//
//	}
//	@Test
//	public void testDialogue() {
//		String s1=t.getDialog(1).getText();
//		String dialogue1="Bienvenue dans le monde de CrossWorld, tu es ici pour vivre une aventure hors du commun, sauras-tu resoudre les enigmes pour pouvoir rentrer chez toi ? Bonne chance dans le monde de CrossWorld.";
//		assertEquals(dialogue1, s1);
//		String s2=t.getDialog(2).getText();
//		String dialogue2="Tu ne peux pas encore aller par la, il te faut au moins un badge, va voir du cote de l arene.";
//		assertEquals(dialogue2, s2);
//		
//	}
//	
//	public void testQuestion(){
//		String s=t.getDialog(3).getText();
//		String dialogue="Pour obtenir ton premier badge il te faut resoudre cette enigme : Quel Pokemon manque-t-il ?";
//		assertEquals(dialogue, s);
//		String r1=((Questions)t.getDialog(3)).getReponses().get(1);
//		String r2=((Questions)t.getDialog(3)).getReponses().get(2);
//		String r3=((Questions)t.getDialog(3)).getReponses().get(3);
//
//		assertEquals("Pikachu",r1);
//		assertEquals("Abra",r2);
//		assertEquals("Coconfort",r3);
//	}
//
//}
