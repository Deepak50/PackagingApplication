package com.incture.dto;

public class ExcelDto {
	private String partNo;
	private String supplierId;
	private String partDescription;
	private String plant;
	private String partWeight;
	private String partlength;
	private String partHeight;
	private String partWidth;

	public ExcelDto() {
		super();
	}

	public ExcelDto(String partNo, String supplierId, String partDescription, String plant, String partWeight,
			String partlength, String partHeight, String partWidth) {
		super();
		this.partNo = partNo;
		this.supplierId = supplierId;
		this.partDescription = partDescription;
		this.plant = plant;
		this.partWeight = partWeight;
		this.partlength = partlength;
		this.partHeight = partHeight;
		this.partWidth = partWidth;
	}

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getPartWeight() {
		return partWeight;
	}

	public void setPartWeight(String partWeight) {
		this.partWeight = partWeight;
	}

	public String getPartlength() {
		return partlength;
	}

	public void setPartlength(String partlength) {
		this.partlength = partlength;
	}

	public String getPartHeight() {
		return partHeight;
	}

	public void setPartHeight(String partHeight) {
		this.partHeight = partHeight;
	}

	public String getPartWidth() {
		return partWidth;
	}

	public void setPartWidth(String partWidth) {
		this.partWidth = partWidth;
	}
}
