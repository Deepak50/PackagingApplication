package com.incture.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import com.incture.compositeKey.S4_Packaging_CK;

@DynamicInsert
@Entity
@Table(name = "S4_Packaging")
public class S4_Packaging {

	@EmbeddedId
	private S4_Packaging_CK s4_Packaging_CK;
	
	@Column
	private String CREATED_BY;
	
	@Column(updatable = false)
	@CreationTimestamp
	private Timestamp CREATED_DATE;
	@Column
	private String HEIGHT;
	@Column
	private String LENGTH;
	@Column
	private String MAX_QTY_PER_KG;
	@Column
	private String MIXED_PACKAGE;
	@Column
	private String MIXED_PALLET;
	@Column
	private String PACKAGING_MATERIAL;
	@Column
	private String PALLET_PACKAGING_MATERIAL;
	@Column
	private String PART_DESC;
	@Column
	private String PKD_WILD_CARD;
	@Column
	private String SEC_PKG_MAT;
	@Column
	private String SHIPS_ON_PALLET;
	@Column
	private String STATUS;
	@Column
	private String UPDATED_BY;
	@Column
	@UpdateTimestamp
	private Timestamp UPDATED_DATE;
	@Column
	private String WEIGHT;
	@Column
	private String WIDTH;

	public S4_Packaging() {

	}

	public S4_Packaging(S4_Packaging_CK s4_Packaging_CK, String cREATED_BY, Timestamp cREATED_DATE, String hEIGHT,
			String lENGTH, String mAX_QTY_PER_KG, String mIXED_PACKAGE, String mIXED_PALLET, String pACKAGING_MATERIAL,
			String pALLET_PACKAGING_MATERIAL, String pART_DESC, String pKD_WILD_CARD, String sEC_PKG_MAT,
			String sHIPS_ON_PALLET, String sTATUS, String uPDATED_BY, Timestamp uPDATED_DATE, String wEIGHT,
			String wIDTH) {
		super();
		this.s4_Packaging_CK = s4_Packaging_CK;
		CREATED_BY = cREATED_BY;
		CREATED_DATE = cREATED_DATE;
		HEIGHT = hEIGHT;
		LENGTH = lENGTH;
		MAX_QTY_PER_KG = mAX_QTY_PER_KG;
		MIXED_PACKAGE = mIXED_PACKAGE;
		MIXED_PALLET = mIXED_PALLET;
		PACKAGING_MATERIAL = pACKAGING_MATERIAL;
		PALLET_PACKAGING_MATERIAL = pALLET_PACKAGING_MATERIAL;
		PART_DESC = pART_DESC;
		PKD_WILD_CARD = pKD_WILD_CARD;
		SEC_PKG_MAT = sEC_PKG_MAT;
		SHIPS_ON_PALLET = sHIPS_ON_PALLET;
		STATUS = sTATUS;
		UPDATED_BY = uPDATED_BY;
		UPDATED_DATE = uPDATED_DATE;
		WEIGHT = wEIGHT;
		WIDTH = wIDTH;
	}

	public S4_Packaging_CK getS4_Packaging_CK() {
		return s4_Packaging_CK;
	}

	public void setS4_Packaging_CK(S4_Packaging_CK s4_Packaging_CK) {
		this.s4_Packaging_CK = s4_Packaging_CK;
	}

	public String getCREATED_BY() {
		return CREATED_BY;
	}

	public void setCREATED_BY(String cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}

	public Timestamp getCREATED_DATE() {
		return CREATED_DATE;
	}

	public void setCREATED_DATE(Timestamp cREATED_DATE) {
		CREATED_DATE = cREATED_DATE;
	}
	
	public String getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(String hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public String getLENGTH() {
		return LENGTH;
	}

	public void setLENGTH(String lENGTH) {
		LENGTH = lENGTH;
	}

	public String getMAX_QTY_PER_KG() {
		return MAX_QTY_PER_KG;
	}

	public void setMAX_QTY_PER_KG(String mAX_QTY_PER_KG) {
		MAX_QTY_PER_KG = mAX_QTY_PER_KG;
	}

	public String getMIXED_PACKAGE() {
		return MIXED_PACKAGE;
	}

	public void setMIXED_PACKAGE(String mIXED_PACKAGE) {
		MIXED_PACKAGE = mIXED_PACKAGE;
	}

	public String getMIXED_PALLET() {
		return MIXED_PALLET;
	}

	public void setMIXED_PALLET(String mIXED_PALLET) {
		MIXED_PALLET = mIXED_PALLET;
	}

	public String getPACKAGING_MATERIAL() {
		return PACKAGING_MATERIAL;
	}

	public void setPACKAGING_MATERIAL(String pACKAGING_MATERIAL) {
		System.out.println("Lets see what its printing.."+ pACKAGING_MATERIAL);
		PACKAGING_MATERIAL = pACKAGING_MATERIAL;
	}

	public String getPALLET_PACKAGING_MATERIAL() {
		return PALLET_PACKAGING_MATERIAL;
	}

	public void setPALLET_PACKAGING_MATERIAL(String pALLET_PACKAGING_MATERIAL) {
		PALLET_PACKAGING_MATERIAL = pALLET_PACKAGING_MATERIAL;
	}

	public String getPART_DESC() {
		return PART_DESC;
	}

	public void setPART_DESC(String pART_DESC) {
		PART_DESC = pART_DESC;
	}

	public String getPKD_WILD_CARD() {
		return PKD_WILD_CARD;
	}

	public void setPKD_WILD_CARD(String pKD_WILD_CARD) {
		PKD_WILD_CARD = pKD_WILD_CARD;
	}

	public String getSEC_PKG_MAT() {
		return SEC_PKG_MAT;
	}

	public void setSEC_PKG_MAT(String sEC_PKG_MAT) {
		SEC_PKG_MAT = sEC_PKG_MAT;
	}

	public String getSHIPS_ON_PALLET() {
		return SHIPS_ON_PALLET;
	}

	public void setSHIPS_ON_PALLET(String sHIPS_ON_PALLET) {
		SHIPS_ON_PALLET = sHIPS_ON_PALLET;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
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

	public String getWEIGHT() {
		return WEIGHT;
	}

	public void setWEIGHT(String wEIGHT) {
		WEIGHT = wEIGHT;
	}

	public String getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(String wIDTH) {
		WIDTH = wIDTH;
	}

	@Override
	public String toString() {
		return "S4_Packaging [s4_Packaging_CK=" + s4_Packaging_CK + ", CREATED_BY=" + CREATED_BY + ", CREATED_DATE="
				+ CREATED_DATE + ", HEIGHT=" + HEIGHT + ", LENGTH=" + LENGTH + ", MAX_QTY_PER_KG=" + MAX_QTY_PER_KG
				+ ", MIXED_PACKAGE=" + MIXED_PACKAGE + ", MIXED_PALLET=" + MIXED_PALLET + ", PACKAGING_MATERIAL="
				+ PACKAGING_MATERIAL + ", PALLET_PACKAGING_MATERIAL=" + PALLET_PACKAGING_MATERIAL + ", PART_DESC="
				+ PART_DESC + ", PKD_WILD_CARD=" + PKD_WILD_CARD + ", SEC_PKG_MAT=" + SEC_PKG_MAT + ", SHIPS_ON_PALLET="
				+ SHIPS_ON_PALLET + ", STATUS=" + STATUS + ", UPDATED_BY=" + UPDATED_BY + ", UPDATED_DATE="
				+ UPDATED_DATE + ", WEIGHT=" + WEIGHT + ", WIDTH=" + WIDTH + ", getS4_Packaging_CK()="
				+ getS4_Packaging_CK() + ", getCREATED_BY()=" + getCREATED_BY() + ", getCREATED_DATE()="
				+ getCREATED_DATE() + ", getHEIGHT()=" + getHEIGHT() + ", getLENGTH()=" + getLENGTH()
				+ ", getMAX_QTY_PER_KG()=" + getMAX_QTY_PER_KG() + ", getMIXED_PACKAGE()=" + getMIXED_PACKAGE()
				+ ", getMIXED_PALLET()=" + getMIXED_PALLET() + ", getPACKAGING_MATERIAL()=" + getPACKAGING_MATERIAL()
				+ ", getPALLET_PACKAGING_MATERIAL()=" + getPALLET_PACKAGING_MATERIAL() + ", getPART_DESC()="
				+ getPART_DESC() + ", getPKD_WILD_CARD()=" + getPKD_WILD_CARD() + ", getSEC_PKG_MAT()="
				+ getSEC_PKG_MAT() + ", getSHIPS_ON_PALLET()=" + getSHIPS_ON_PALLET() + ", getSTATUS()=" + getSTATUS()
				+ ", getUPDATED_BY()=" + getUPDATED_BY() + ", getUPDATED_DATE()=" + getUPDATED_DATE() + ", getWEIGHT()="
				+ getWEIGHT() + ", getWIDTH()=" + getWIDTH() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}