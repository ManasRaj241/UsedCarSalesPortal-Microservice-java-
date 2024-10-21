package com.AuthApi.Manas.dto;

public class AuthResponse {

	private Object result;
    private boolean isSuccess = true;
    private String message;
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public AuthResponse(Object result, boolean isSuccess, String message) {
		super();
		this.result = result;
		this.isSuccess = isSuccess;
		this.message = message;
	}
	public AuthResponse() {
		super();
	}
    
    
}
