package com.incture.compositeKey;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class S4_Packaging_CK implements Serializable {
	private String PART_NUM;
	private String PLANT;
	private String SUPPLIER_ID;

	
	
	public S4_Packaging_CK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public S4_Packaging_CK(String pART_NUM, String pLANT, String sUPPLIER_ID) {
		super();
		PART_NUM = pART_NUM;
		PLANT = pLANT;
		SUPPLIER_ID = sUPPLIER_ID;
	}

	public String getPART_NUM() {
		return PART_NUM;
	}

	public void setPART_NUM(String pART_NUM) {
		PART_NUM = pART_NUM;
	}

	public String getPLANT() {
		return PLANT;
	}

	public void setPLANT(String pLANT) {
		PLANT = pLANT;
	}

	public String getSUPPLIER_ID() {
		return SUPPLIER_ID;
	}

	public void setSUPPLIER_ID(String sUPPLIER_ID) {
		SUPPLIER_ID = sUPPLIER_ID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof S4_Packaging_CK))
			return false;
		S4_Packaging_CK that = (S4_Packaging_CK) o;
		return Objects.equals(getPART_NUM(), that.getPART_NUM()) && Objects.equals(getPLANT(), that.getPLANT())
				&& Objects.equals(getSUPPLIER_ID(), that.getSUPPLIER_ID());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPART_NUM(), getPLANT(), getSUPPLIER_ID());
	}
}
