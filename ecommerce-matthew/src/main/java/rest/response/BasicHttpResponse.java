package rest.response;

import java.io.Serializable;

public class BasicHttpResponse implements Serializable {
	
	private int responseCode;
	private String msg;
	private boolean hasError;
	public BasicHttpResponse()
	{
		
	}
	
	public BasicHttpResponse(int responseCode, String msg, boolean hasError) {
		super();
		this.responseCode = responseCode;
		this.msg = msg;
		this.hasError = hasError;
	}

	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isHasError() {
		return hasError;
	}
	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}
	

}
