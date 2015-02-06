package view;



import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import sun.awt.WindowClosingListener;

import controler.GamePanelMouseMotionControler;

import model.Dialogue;
import model.EnumScenes;

public class GameFrame extends JFrame implements WindowListener{
	
	public static final int LONGUEUR = 1024;
	public static final int LARGEUR = 800;
	
	private GamePanel gamePanel;
	
	public GameFrame() {
		super("Cross World");
		
		this.gamePanel = new GamePanel();
		
		this.setContentPane(gamePanel);
		
		this.addWindowListener(this);
		setLocationRelativeTo(null);
		setSize(LONGUEUR, LARGEUR);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		GameFrame game = new GameFrame();
		game.gamePanel.getGameManager().setSceneActuelle(1);
		game.gamePanel.getGameManager().afficherDialogue(1);
		
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		gamePanel.getGameManager().getConnexion().closeConnection();
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowOpened(WindowEvent e) {
//		game.gamePanel.getGameManager().setSceneActuelle(3);	

	}

}
