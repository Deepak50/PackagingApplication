package com.incture.dto;

import java.sql.Timestamp;

public class SampleDto {
	private String id;
	private String name;
	private String age;
	//private Timestamp ts;
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public Timestamp getTs() {
//		return ts;
//	}
//	public void setTs(Timestamp ts) {
//		this.ts = ts;
//	}
	
}