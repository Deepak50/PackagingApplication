package com.incture.dto;

public class FilterDto {
	private String partNum;
	private String plant;
	private String supplierId;
	private String pageNo;
	private String count;

	public FilterDto() {
		super();
	}

	public FilterDto(String partNum, String plant, String supplierId, String pageNo, String count) {
		super();
		this.partNum = partNum;
		this.plant = plant;
		this.supplierId = supplierId;
		this.pageNo = pageNo;
		this.count = count;
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

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "FilterDto [partNum=" + partNum + ", plant=" + plant + ", supplierId=" + supplierId + ", pageNo="
				+ pageNo + ", count=" + count + ", getPartNum()=" + getPartNum() + ", getPlant()=" + getPlant()
				+ ", getSupplierId()=" + getSupplierId() + ", getPageNo()=" + getPageNo() + ", getCount()=" + getCount()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
