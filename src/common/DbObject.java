package common;

import java.io.Serializable;

public class DbObject implements IDbObject, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected Integer id;

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
