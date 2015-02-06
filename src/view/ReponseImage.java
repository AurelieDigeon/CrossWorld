package view;

import java.awt.Rectangle;

import model.Reponse;

public class ReponseImage extends Rectangle{

	
	private Reponse reponse;
	
	public ReponseImage(Reponse reponse) {
		this.reponse = reponse;
		this.setBounds(reponse.getX(), reponse.getY(), GameFrame.LONGUEUR, 30);
		
	}

	public Reponse getReponseModel() {
		return reponse;
	}
	
	
	

}
