package com.incture.dto;

public class Base64Dto {
	String base64;
	String type;

	public Base64Dto() {
		super();
	}

	public Base64Dto(String base64, String type) {
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

	@Override
	public String toString() {
		return "Base64Dto [base64=" + base64 + ", type=" + type + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
