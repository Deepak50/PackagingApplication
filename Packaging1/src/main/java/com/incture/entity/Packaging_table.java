package com.incture.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.UpdateTimestamp;

import com.incture.compositeKey.Packaging_table_CK;


@DynamicInsert
@Entity
@Table(name = "Packaging_table")
@FilterDef(name = "partNumFilter", parameters = { @ParamDef(name = "partNum", type = "string") })
@FilterDef(name = "plantFilter", parameters = { @ParamDef(name = "plant", type = "string") })
@FilterDef(name = "supplierIdFilter", parameters = { @ParamDef(name = "supplierId", type = "string") })
@Filter(name = "partNumFilter", condition = "\"Part Num\"= :partNum")
@Filter(name = "plantFilter", condition = "\"Plant\"= :plant")
@Filter(name = "supplierIdFilter", condition = "\"Supplier Id\"= :supplierId")
public class Packaging_table {
	@EmbeddedId
	Packaging_table_CK packaging_table_CK;
	@Column(name = "Created By")
	private String createdBy;
	@CreationTimestamp
	@Column(name = "Created Date", updatable = false)
	private Timestamp createdDate;
	@Column(name = "Height")
	private String height;
	@Column(name = "Length")
	private String length;
	@Column(name = "Max Qty Per Kg")
	private String maxQtyPerKg;
	@Column(name = "Mixed Package")
	private String mixedPackage;
	@Column(name = "Mixed Pallet")
	private String mixedPallet;
	@Column(name = "Packaging Material Id")
	private String packagingMaterialId;
	@Column(name = "Pallet Packaging Material")
	private String palletPackagingMaterial;
	@Column(name = "Part Desc")
	private String partDesc;
	@Column(name = "Pkd Wild Card")
	private String pkdWildCard;
	@Column(name = "Sec Pkg Mat")
	private String secPkgMat;
	@Column(name = "Ships on Pallet")
	private String shipsOnPallet;
	@Column(name = "Status")
	private String status;
	@Column(name = "Updated Height")
	private String updatedHeight;
	@Column(name = "Updated Length")
	private String updatedLength;
	@Column(name = "Updated MaxQtyPerKg")
	private String updatedMaxQtyPerKg;
	@Column(name = "Updated MixedPackage")
	private String updatedMixedPackage;
	@Column(name = "Ppdated MixedPallet")
	private String updatedMixedPallet;
	@Column(name = "Updated PackagingMaterial")
	private String updatedPackagingMaterial;
	@Column(name = "Updated PalletPackagingMaterial")
	private String updatedPalletPackagingMaterial;
	@Column(name = "Updated SecPkgMat")
	private String updatedSecPkgMat;
	@Column(name = "Updated ShipsOnPallet")
	private String updatedShipsOnPallet;
	@Column(name = "Updated Weight")
	private String updatedWeight;
	@Column(name = "Updated Width")
	private String updatedWidth;
	@Column(name = "Updated By")
	private String updatedBy;
	@UpdateTimestamp
	@Column(name = "Updated Date")
	private Timestamp updatedDate;
	@Column(name = "Weight")
	private String weight;
	@Column(name = "Width")
	private String width;
	@Column(name = "Actions")
	private String actions;

	public Packaging_table() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Packaging_table(Packaging_table_CK packaging_table_CK, String createdBy, Timestamp createdDate,
			String height, String length, String maxQtyPerKg, String mixedPackage, String mixedPallet,
			String packagingMaterialId, String palletPackagingMaterial, String partDesc, String pkdWildCard,
			String secPkgMat, String shipsOnPallet, String status, String updatedHeight, String updatedLength,
			String updatedMaxQtyPerKg, String updatedMixedPackage, String updatedMixedPallet,
			String updatedPackagingMaterial, String updatedPalletPackagingMaterial, String updatedSecPkgMat,
			String updatedShipsOnPallet, String updatedWeight, String updatedWidth, String updatedBy,
			Timestamp updatedDate, String weight, String width, String actions) {
		super();
		this.packaging_table_CK = packaging_table_CK;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.height = height;
		this.length = length;
		this.maxQtyPerKg = maxQtyPerKg;
		this.mixedPackage = mixedPackage;
		this.mixedPallet = mixedPallet;
		this.packagingMaterialId = packagingMaterialId;
		this.palletPackagingMaterial = palletPackagingMaterial;
		this.partDesc = partDesc;
		this.pkdWildCard = pkdWildCard;
		this.secPkgMat = secPkgMat;
		this.shipsOnPallet = shipsOnPallet;
		this.status = status;
		this.updatedHeight = updatedHeight;
		this.updatedLength = updatedLength;
		this.updatedMaxQtyPerKg = updatedMaxQtyPerKg;
		this.updatedMixedPackage = updatedMixedPackage;
		this.updatedMixedPallet = updatedMixedPallet;
		this.updatedPackagingMaterial = updatedPackagingMaterial;
		this.updatedPalletPackagingMaterial = updatedPalletPackagingMaterial;
		this.updatedSecPkgMat = updatedSecPkgMat;
		this.updatedShipsOnPallet = updatedShipsOnPallet;
		this.updatedWeight = updatedWeight;
		this.updatedWidth = updatedWidth;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.weight = weight;
		this.width = width;
		this.actions = actions;
	}

	public Packaging_table_CK getPackaging_table_CK() {
		return packaging_table_CK;
	}

	public void setPackaging_table_CK(Packaging_table_CK packaging_table_CK) {
		this.packaging_table_CK = packaging_table_CK;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getMaxQtyPerKg() {
		return maxQtyPerKg;
	}

	public void setMaxQtyPerKg(String maxQtyPerKg) {
		this.maxQtyPerKg = maxQtyPerKg;
	}

	public String getMixedPackage() {
		return mixedPackage;
	}

	public void setMixedPackage(String mixedPackage) {
		this.mixedPackage = mixedPackage;
	}

	public String getMixedPallet() {
		return mixedPallet;
	}

	public void setMixedPallet(String mixedPallet) {
		this.mixedPallet = mixedPallet;
	}

	public String getPackagingMaterialId() {
		return packagingMaterialId;
	}

	public void setPackagingMaterialId(String packagingMaterialId) {
		this.packagingMaterialId = packagingMaterialId;
	}

	public String getPalletPackagingMaterial() {
		return palletPackagingMaterial;
	}

	public void setPalletPackagingMaterial(String palletPackagingMaterial) {
		this.palletPackagingMaterial = palletPackagingMaterial;
	}

	public String getPartDesc() {
		return partDesc;
	}

	public void setPartDesc(String partDesc) {
		this.partDesc = partDesc;
	}

	public String getPkdWildCard() {
		return pkdWildCard;
	}

	public void setPkdWildCard(String pkdWildCard) {
		this.pkdWildCard = pkdWildCard;
	}

	public String getSecPkgMat() {
		return secPkgMat;
	}

	public void setSecPkgMat(String secPkgMat) {
		this.secPkgMat = secPkgMat;
	}

	public String getShipsOnPallet() {
		return shipsOnPallet;
	}

	public void setShipsOnPallet(String shipsOnPallet) {
		this.shipsOnPallet = shipsOnPallet;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdatedHeight() {
		return updatedHeight;
	}

	public void setUpdatedHeight(String updatedHeight) {
		this.updatedHeight = updatedHeight;
	}

	public String getUpdatedLength() {
		return updatedLength;
	}

	public void setUpdatedLength(String updatedLength) {
		this.updatedLength = updatedLength;
	}

	public String getUpdatedMaxQtyPerKg() {
		return updatedMaxQtyPerKg;
	}

	public void setUpdatedMaxQtyPerKg(String updatedMaxQtyPerKg) {
		this.updatedMaxQtyPerKg = updatedMaxQtyPerKg;
	}

	public String getUpdatedMixedPackage() {
		return updatedMixedPackage;
	}

	public void setUpdatedMixedPackage(String updatedMixedPackage) {
		this.updatedMixedPackage = updatedMixedPackage;
	}

	public String getUpdatedMixedPallet() {
		return updatedMixedPallet;
	}

	public void setUpdatedMixedPallet(String updatedMixedPallet) {
		this.updatedMixedPallet = updatedMixedPallet;
	}

	public String getUpdatedPackagingMaterial() {
		return updatedPackagingMaterial;
	}

	public void setUpdatedPackagingMaterial(String updatedPackagingMaterial) {
		this.updatedPackagingMaterial = updatedPackagingMaterial;
	}

	public String getUpdatedPalletPackagingMaterial() {
		return updatedPalletPackagingMaterial;
	}

	public void setUpdatedPalletPackagingMaterial(String updatedPalletPackagingMaterial) {
		this.updatedPalletPackagingMaterial = updatedPalletPackagingMaterial;
	}

	public String getUpdatedSecPkgMat() {
		return updatedSecPkgMat;
	}

	public void setUpdatedSecPkgMat(String updatedSecPkgMat) {
		this.updatedSecPkgMat = updatedSecPkgMat;
	}

	public String getUpdatedShipsOnPallet() {
		return updatedShipsOnPallet;
	}

	public void setUpdatedShipsOnPallet(String updatedShipsOnPallet) {
		this.updatedShipsOnPallet = updatedShipsOnPallet;
	}

	public String getUpdatedWeight() {
		return updatedWeight;
	}

	public void setUpdatedWeight(String updatedWeight) {
		this.updatedWeight = updatedWeight;
	}

	public String getUpdatedWidth() {
		return updatedWidth;
	}

	public void setUpdatedWidth(String updatedWidth) {
		this.updatedWidth = updatedWidth;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getActions() {
		return actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}

	@Override
	public String toString() {
		return "Packaging_table [packaging_table_CK=" + packaging_table_CK + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", height=" + height + ", length=" + length + ", maxQtyPerKg="
				+ maxQtyPerKg + ", mixedPackage=" + mixedPackage + ", mixedPallet=" + mixedPallet
				+ ", packagingMaterialId=" + packagingMaterialId + ", palletPackagingMaterial="
				+ palletPackagingMaterial + ", partDesc=" + partDesc + ", pkdWildCard=" + pkdWildCard + ", secPkgMat="
				+ secPkgMat + ", shipsOnPallet=" + shipsOnPallet + ", status=" + status + ", updatedHeight="
				+ updatedHeight + ", updatedLength=" + updatedLength + ", updatedMaxQtyPerKg=" + updatedMaxQtyPerKg
				+ ", updatedMixedPackage=" + updatedMixedPackage + ", updatedMixedPallet=" + updatedMixedPallet
				+ ", updatedPackagingMaterial=" + updatedPackagingMaterial + ", updatedPalletPackagingMaterial="
				+ updatedPalletPackagingMaterial + ", updatedSecPkgMat=" + updatedSecPkgMat + ", updatedShipsOnPallet="
				+ updatedShipsOnPallet + ", updatedWeight=" + updatedWeight + ", updatedWidth=" + updatedWidth
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", weight=" + weight + ", width="
				+ width + ", actions=" + actions + ", getPackaging_table_CK()=" + getPackaging_table_CK()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getCreatedDate()=" + getCreatedDate() + ", getHeight()="
				+ getHeight() + ", getLength()=" + getLength() + ", getMaxQtyPerKg()=" + getMaxQtyPerKg()
				+ ", getMixedPackage()=" + getMixedPackage() + ", getMixedPallet()=" + getMixedPallet()
				+ ", getPackagingMaterialId()=" + getPackagingMaterialId() + ", getPalletPackagingMaterial()="
				+ getPalletPackagingMaterial() + ", getPartDesc()=" + getPartDesc() + ", getPkdWildCard()="
				+ getPkdWildCard() + ", getSecPkgMat()=" + getSecPkgMat() + ", getShipsOnPallet()=" + getShipsOnPallet()
				+ ", getStatus()=" + getStatus() + ", getUpdatedHeight()=" + getUpdatedHeight()
				+ ", getUpdatedLength()=" + getUpdatedLength() + ", getUpdatedMaxQtyPerKg()=" + getUpdatedMaxQtyPerKg()
				+ ", getUpdatedMixedPackage()=" + getUpdatedMixedPackage() + ", getUpdatedMixedPallet()="
				+ getUpdatedMixedPallet() + ", getUpdatedPackagingMaterial()=" + getUpdatedPackagingMaterial()
				+ ", getUpdatedPalletPackagingMaterial()=" + getUpdatedPalletPackagingMaterial()
				+ ", getUpdatedSecPkgMat()=" + getUpdatedSecPkgMat() + ", getUpdatedShipsOnPallet()="
				+ getUpdatedShipsOnPallet() + ", getUpdatedWeight()=" + getUpdatedWeight() + ", getUpdatedWidth()="
				+ getUpdatedWidth() + ", getUpdatedBy()=" + getUpdatedBy() + ", getUpdatedDate()=" + getUpdatedDate()
				+ ", getWeight()=" + getWeight() + ", getWidth()=" + getWidth() + ", getActions()=" + getActions()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
