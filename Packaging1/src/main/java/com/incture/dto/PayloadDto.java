package com.incture.dto;

public class PayloadDto {
	String base64;
	String type;
	
	public PayloadDto(String base64, String type) {
		super();
		this.base64 = base64;
		this.type = type;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
