package com.incture.compositeKey;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Packaging_table_CK implements Serializable {
	@Column(name = "Part Num")
	private String partNum;

	@Column(name = "Plant")
	private String plant;

	@Column(name = "Supplier Id")
	private String supplierId;

	public Packaging_table_CK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Packaging_table_CK(String partNum, String plant, String supplierId) {
		super();
		this.partNum = partNum;
		this.plant = plant;
		this.supplierId = supplierId;
	}

	public String getPartNum() {
		return partNum;
	}

	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	@Override
	public String toString() {
		return "Packaging_table_CK [partNum=" + partNum + ", plant=" + plant + ", supplierId=" + supplierId
				+ ", getPartNum()=" + getPartNum() + ", getPlant()=" + getPlant() + ", getSupplierId()="
				+ getSupplierId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Packaging_table_CK))
			return false;
		Packaging_table_CK that = (Packaging_table_CK) o;
		return Objects.equals(getPartNum(), that.getPartNum()) && Objects.equals(getPlant(), that.getPlant())
				&& Objects.equals(getSupplierId(), that.getSupplierId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPartNum(), getPlant(), getSupplierId());
	}

}
