package model;

public class Dialogue{


	protected int id;
	protected String texte;
	protected int question;
	protected int bonneReponse;
	private int idAction;
	
	
	public Dialogue(int id, String texte, int question, int bonneReponse, int idAction){
		this.texte=texte;
		this.id = id;
		this.idAction = idAction;
	}
	
	
	
	public int getId() {
		return id;
	}



	public int getQuestion() {
		return question;
	}



	public int getBonneReponse() {
		return bonneReponse;
	}



	public boolean estQuestion(){
		return false;
	}

	public String getTexte() {
		return texte;
	}



	public int getIdAction() {
		return idAction;
	}
	
	

}
