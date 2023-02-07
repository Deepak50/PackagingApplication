package com.incture.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import com.incture.compositeKey.Change_Log_CK;

@DynamicInsert
@Entity
@Table(name = "Change_Log")
public class Change_Log {

	@EmbeddedId
	private Change_Log_CK change_Log_CK;

	@Column
	private String FLAG;

	@Column
	private String UPDATED_BY;

	@Column
	@UpdateTimestamp
	private Timestamp UPDATED_DATE;

	public Change_Log() {
	}

	public Change_Log(Change_Log_CK change_Log_CK, String fLAG, String uPDATED_BY, Timestamp uPDATED_DATE) {
		super();
		this.change_Log_CK = change_Log_CK;
		FLAG = fLAG;
		UPDATED_BY = uPDATED_BY;
		UPDATED_DATE = uPDATED_DATE;
	}

	public Change_Log_CK getChange_Log_CK() {
		return change_Log_CK;
	}

	public void setChange_Log_CK(Change_Log_CK change_Log_CK) {
		this.change_Log_CK = change_Log_CK;
	}

	public String getFLAG() {
		return FLAG;
	}

	public void setFLAG(String fLAG) {
		FLAG = fLAG;
	}

	public String getUPDATED_BY() {
		return UPDATED_BY;
	}

	public void setUPDATED_BY(String uPDATED_BY) {
		UPDATED_BY = uPDATED_BY;
	}

	public Timestamp getUPDATED_DATE() {
		return UPDATED_DATE;
	}

	public void setUPDATED_DATE(Timestamp uPDATED_DATE) {
		UPDATED_DATE = uPDATED_DATE;
	}

	@Override
	public String toString() {
		return "Change_Log [change_Log_CK=" + change_Log_CK + ", FLAG=" + FLAG + ", UPDATED_BY=" + UPDATED_BY
				+ ", UPDATED_DATE=" + UPDATED_DATE + ", getChange_Log_CK()=" + getChange_Log_CK() + ", getFLAG()="
				+ getFLAG() + ", getUPDATED_BY()=" + getUPDATED_BY() + ", getUPDATED_DATE()=" + getUPDATED_DATE()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
