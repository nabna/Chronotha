package common;

public class DbObject implements IDbObject {
	
	protected int id;

	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
