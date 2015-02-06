package model;

public class Action {
	
	private int idAction;
	private int type;
	private int idCible;
	private int idScene;
	
	public Action(int idAction, int type, int idCible, int idScene) {
		this.idAction=idAction;
		this.type=type;
		this.idCible=idCible;
		this.idScene=idScene;
	}

	public int getIdAction() {
		return idAction;
	}

	public int getType() {
		return type;
	}

	public int getIdCible() {
		return idCible;
	}

	public int getIdScene() {
		return idScene;
	}
	
	

}
