package model;

public class Objet {

	protected int id;
	protected int idScene;
	protected int x;
	protected int y;
	protected String url;
	protected int visible;
	protected int idAction;

	public Objet(int id, int idScene, int x, int y, String url, int visible, int idAction) {
		this.id = id;
		this.idScene=idScene;
		this.x=x;
		this.y=y;
		this.url=url;
		this.visible=visible;
		this.idAction=idAction;
		
	}

	public int getIdScene() {
		return idScene;
		
	}

	public int getX() {
		return x;
		
	}

	public int getY() {
		return y;
		
	}

	public String getUrl() {
		return url;
		
	}

	public boolean isVisible() {
		return visible >= 1;
		
	}

	public int getIdAction() {
		return idAction;
		
	}

	public Integer getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Objet [id=" + id + ", idScene=" + idScene + ", x=" + x + ", y="
				+ y + ", url=" + url + ", visible=" + visible + ", idAction="
				+ idAction + "]";
	}

	
	

}
