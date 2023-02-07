package com.incture.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "AutoGen5")
public class AutoGen {

	
	@Id
//	@GenericGenerator(name = "UseExistingIdOtherwiseGenerateUsingIdentity", strategy = "com.incture.entity.UseExistingIdOtherwiseGenerateUsingIdentity")
//	@GeneratedValue(generator = "UseExistingIdOtherwiseGenerateUsingIdentity")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID",unique = true, nullable = false)
	protected Integer id;
	
//	@Id
//	@Column(name = "ID", nullable = false)
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;

	@Column
	private String name;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AutoGen [id=" + id + ", name=" + name + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
