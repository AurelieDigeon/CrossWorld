package model;
import java.util.Collections;
import java.util.List;


public class Question extends Dialogue{

	private List<Reponse> reponses;

	public Question(int id, String texte, int question, List<Reponse> reponses, int bonneReponse) {
		super(id, texte, question, bonneReponse, 0);
		this.reponses = reponses;
		
	}

	public List<Reponse> getReponses() {
		return Collections.unmodifiableList(this.reponses);
	}

	public boolean estQuestion(){
		return true;
	}

}
