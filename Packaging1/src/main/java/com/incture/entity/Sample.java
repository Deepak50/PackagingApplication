package com.incture.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import com.incture.compositeKey.Sample_CK;

@DynamicInsert
@Entity
@Table(name = "Sample")
public class Sample {
	@EmbeddedId
	private Sample_CK sample_CK;
	
	@Column
	private String age;

	public Sample() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Sample(Sample_CK sample_CK, String age) {
		super();
		this.sample_CK = sample_CK;
		this.age = age;
	}



	public Sample_CK getSample_CK() {
		return sample_CK;
	}

	public void setSample_CK(Sample_CK sample_CK) {
		this.sample_CK = sample_CK;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Sample [sample_CK=" + sample_CK + ", age=" + age + ", getSample_CK()=" + getSample_CK() + ", getAge()="
				+ getAge() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	



	

	
	
}