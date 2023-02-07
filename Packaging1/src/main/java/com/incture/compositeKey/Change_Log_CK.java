package com.incture.compositeKey;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Change_Log_CK implements Serializable {
	private String PART_NUM;
	private String SUPPLIER_ID;

	public String getPART_NUM() {
		return PART_NUM;
	}

	public void setPART_NUM(String pART_NUM) {
		PART_NUM = pART_NUM;
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
		if (!(o instanceof Change_Log_CK))
			return false;
		Change_Log_CK that = (Change_Log_CK) o;
		return Objects.equals(getPART_NUM(), that.getPART_NUM())
				&& Objects.equals(getSUPPLIER_ID(), that.getSUPPLIER_ID());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPART_NUM(), getSUPPLIER_ID());
	}

}
