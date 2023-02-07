package com.incture.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@DynamicInsert
@Entity
@Table(name = "Sample2_table")
public class Sample2 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Some Col")
	private String someCol;

	public Sample2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Sample2(String someCol) {
		super();
		this.someCol = someCol;
	}

	public String getSomeCol() {
		return someCol;
	}

	public void setSomeCol(String someCol) {
		this.someCol = someCol;
	}

	@Override
	public String toString() {
		return "Sample2 [someCol=" + someCol + ", getSomeCol()=" + getSomeCol() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
