package ua.training.repairagency.model.entities;

public abstract class AbstractEntity implements Entity {
	
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
