package com.incture.dto;

public class ResponseDto {
	private String message;
	private String statusCode;
	private String status;

	
	
	public ResponseDto() {
		super();
	}

	public ResponseDto(String message, String statusCode, String status) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
