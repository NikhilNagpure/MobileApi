package com.heniktechnology.mobile_api.pojo.return_type;

public class Return {

	private boolean succsess;
	private String message;
	private Object object;

	public Return() {
		super();
	}

	public Return(boolean succsess) {
		super();
		this.succsess = succsess;
	}

	public Return(boolean succsess, String message) {
		super();
		this.succsess = succsess;
		this.message = message;
	}

	public Return(boolean succsess, String message, Object object) {
		super();
		this.succsess = succsess;
		this.message = message;
		this.object = object;
	}

	public boolean isSuccsess() {
		return succsess;
	}

	public void setSuccsess(boolean succsess) {
		this.succsess = succsess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "Return [succsess=" + succsess + ", message=" + message + ", object=" + object + "]";
	}

}
