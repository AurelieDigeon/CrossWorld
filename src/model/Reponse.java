package model;

public class Reponse {

	private int id;
	private int idDialogue;
	private String texte;
	private int numero;
	private int x;
	private int y;
	private int idAction;
	
	
	public Reponse(int id, int idDialogue, String texte, int idAction, int numero) {
		this.id = id;
		this.idDialogue = idDialogue;
		this.texte = texte;
		this.idAction = idAction;
		this.numero = numero;
		this.x = 40;
		this.y = 560 + (numero * 30);
	}

	public int getId() {
		return id;
	}

	public int getIdDialogue() {
		return idDialogue;
	}

	public String getTexte() {
		return texte;
	}

	public int getIdAction() {
		return idAction;
	}

	public int getNumero() {
		return numero;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Reponse [id=" + id + ", idDialogue=" + idDialogue + ", texte="
				+ texte + ", numero=" + numero + ", x=" + x + ", y=" + y
				+ ", idAction=" + idAction + "]";
	}
	
	
	

}
