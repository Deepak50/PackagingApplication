package com.incture.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.dto.Base64Dto;
import com.incture.dto.Change_LogDto;
import com.incture.dto.ExcelDto;
import com.incture.dto.FilterDto;
import com.incture.dto.Packaging_tableDto;
import com.incture.dto.PayloadDto;
import com.incture.dto.ResponseDto;
import com.incture.repository.Packaging_table_Repository;
import com.incture.service.Packaging_table_Service;
import com.incture.utility.S4_Packaging_Utility;

@Service
public class Packaging_table_ServiceImpl implements Packaging_table_Service{

	@Autowired
	S4_Packaging_Utility s4_Packaging_Utility;
	
	@Autowired
	Packaging_table_Repository packaging_table_Repository;
	
	public List<Packaging_tableDto> filter(FilterDto filterDto) {
		return packaging_table_Repository.filter(filterDto);
	}

	public ResponseDto insert(Packaging_tableDto packaging_tableDto) {
		return packaging_table_Repository.insert(packaging_tableDto);
	}

	public HSSFWorkbook convertToWorkbook(byte[] decoded) {
		InputStream bis = new ByteArrayInputStream(decoded);
		HSSFWorkbook wb = null;
		try {
			wb = new HSSFWorkbook(bis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb;
	}
	
	public Packaging_tableDto convertToPackagingTableDto(Row row) {
		Packaging_tableDto packaging_tableDto = new Packaging_tableDto();
		packaging_tableDto.setPartNum(row.getCell(0).toString());
		packaging_tableDto.setPlant(row.getCell(1).toString());
		packaging_tableDto.setSupplierId(row.getCell(2).toString());
		
		if (row.getCell(3) != null)
			packaging_tableDto.setCreatedBy(row.getCell(3).toString());
		if (row.getCell(4) != null)
			packaging_tableDto.setCreatedDate(null);
		if (row.getCell(5) != null)
			packaging_tableDto.setHeight(row.getCell(5).toString());
		if (row.getCell(6) != null)
			packaging_tableDto.setLength(row.getCell(6).toString());
		if (row.getCell(7) != null)
			packaging_tableDto.setMaxQtyPerKg(row.getCell(7).toString());

		if (row.getCell(8) != null)
			packaging_tableDto.setMixedPackage(row.getCell(8).toString());
		if (row.getCell(9) != null)
			packaging_tableDto.setMixedPallet(row.getCell(9).toString());
		if (row.getCell(10) != null)
			packaging_tableDto.setPackagingMaterialId(row.getCell(10).toString());
		if (row.getCell(11) != null)
			packaging_tableDto.setPalletPackagingMaterial(row.getCell(11).toString());
		if (row.getCell(12) != null)
			packaging_tableDto.setPartDesc(row.getCell(12).toString());
		
		if (row.getCell(13) != null)
			packaging_tableDto.setPkdWildCard(row.getCell(13).toString());
		if (row.getCell(14) != null)
			packaging_tableDto.setSecPkgMat(row.getCell(14).toString());
		if (row.getCell(15) != null)
			packaging_tableDto.setShipsOnPallet(row.getCell(15).toString());
		if (row.getCell(16) != null)
			packaging_tableDto.setStatus(row.getCell(16).toString());
		if (row.getCell(17) != null)
			packaging_tableDto.setUpdatedHeight(row.getCell(17).toString());
		
		if (row.getCell(18) != null)
			packaging_tableDto.setUpdatedLength(row.getCell(18).toString());
		if (row.getCell(19) != null)
			packaging_tableDto.setUpdatedMaxQtyPerKg(row.getCell(19).toString());
		if (row.getCell(20) != null)
			packaging_tableDto.setUpdatedMixedPackage(row.getCell(20).toString());
		if (row.getCell(21) != null)
			packaging_tableDto.setUpdatedMixedPallet(row.getCell(21).toString());
		if (row.getCell(22) != null)
			packaging_tableDto.setUpdatedPackagingMaterial(row.getCell(22).toString());
		
		if (row.getCell(23) != null)
			packaging_tableDto.setUpdatedPalletPackagingMaterial(row.getCell(23).toString());
		if (row.getCell(24) != null)
			packaging_tableDto.setUpdatedSecPkgMat(row.getCell(24).toString());
		if (row.getCell(25) != null)
			packaging_tableDto.setUpdatedShipsOnPallet(row.getCell(25).toString());
		if (row.getCell(26) != null)
			packaging_tableDto.setUpdatedWeight(row.getCell(26).toString());
		if (row.getCell(27) != null)
			packaging_tableDto.setUpdatedWidth(row.getCell(27).toString());
		
		if (row.getCell(28) != null)
			packaging_tableDto.setUpdatedBy(row.getCell(28).toString());
		if (row.getCell(29) != null)
			packaging_tableDto.setUpdatedDate(null);
		if (row.getCell(30) != null)
			packaging_tableDto.setWeight(row.getCell(30).toString());
		if (row.getCell(31) != null)
			packaging_tableDto.setWidth(row.getCell(31).toString());
		if (row.getCell(32) != null)
			packaging_tableDto.setActions(row.getCell(32).toString());
		return packaging_tableDto;
	}
	
	public ResponseDto batchInsertTest(Base64Dto base64Dto) {
		
//		Packaging_tableDto packaging_tableDto1 = new Packaging_tableDto("dummy161","dummy","dummy","dummy",null,"dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy",null,"dummy","dummy","dummy");
//		Packaging_tableDto packaging_tableDto2 = new Packaging_tableDto("dummy162","dummy","dummy","dummy",null,"dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy",null,"dummy","dummy","dummy");
//		Packaging_tableDto packaging_tableDto3 = new Packaging_tableDto("dummy163","dummy","dummy","dummy",null,"dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy",null,"dummy","dummy","dummy");
//		Packaging_tableDto packaging_tableDto4 = new Packaging_tableDto("dummy164","dummy","dummy","dummy",null,"dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy",null,"dummy","dummy","dummy");
//		Packaging_tableDto packaging_tableDto5 = new Packaging_tableDto("dummy165","dummy","dummy","dummy",null,"dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy",null,"dummy","dummy","dummy");
//		Packaging_tableDto packaging_tableDto6 = new Packaging_tableDto("dummy166","dummy","dummy","dummy",null,"dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy",null,"dummy","dummy","dummy");
//		Packaging_tableDto packaging_tableDto7 = new Packaging_tableDto("dummy167","dummy","dummy","dummy",null,"dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy",null,"dummy","dummy","dummy");
//		
//		List<Packaging_tableDto> packaging_tableDtoList = new ArrayList<Packaging_tableDto>();
//		packaging_tableDtoList.add(packaging_tableDto1);
//		packaging_tableDtoList.add(packaging_tableDto2);
//		packaging_tableDtoList.add(packaging_tableDto3);
//		packaging_tableDtoList.add(packaging_tableDto4);
//		packaging_tableDtoList.add(packaging_tableDto5);
//		packaging_tableDtoList.add(packaging_tableDto6);
//		packaging_tableDtoList.add(packaging_tableDto7);
		
		byte[] decoded = Base64.getDecoder().decode(base64Dto.getBase64());
		HSSFWorkbook workbook = convertToWorkbook(decoded);
		HSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		Row row0 = sheet.getRow(0);
		int cellCount = row0.getPhysicalNumberOfCells();
		List<Packaging_tableDto> packaging_tableDtoList = new ArrayList<Packaging_tableDto>();
		for (int i = 1; i < rowCount; i++) {
			Row row = sheet.getRow(i);
			Packaging_tableDto packaging_tableDto = convertToPackagingTableDto(row);
			packaging_tableDtoList.add(packaging_tableDto);
		}
		return packaging_table_Repository.batchInsertTest(packaging_tableDtoList);
	}

	public PayloadDto generatePackagingTemplate() {
		List<String> headerList = new ArrayList<String>(Arrays.asList(
		"partNum",
		"plant",
		"supplierId",
		"createdBy",
		"createdDate",
		"height",
		"length",
		"maxQtyPerKg",
		"mixedPackage",
		"mixedPallet",
		"packagingMaterialId",
		"palletPackagingMaterial",
		"partDesc",
		"pkdWildCard",
		"secPkgMat",
		"shipsOnPallet",
		"status",
		"updatedHeight",
		"updatedLength",
		"updatedMaxQtyPerKg",
		"updatedMixedPackage",
		"updatedMixedPallet",
		"updatedPackagingMaterial",
		"updatedPalletPackagingMaterial",
		"updatedSecPkgMat",
		"updatedShipsOnPallet",
		"updatedWeight",
		"updatedWidth",
		"updatedBy",
		"updatedDate",
		"weight",
		"width",
		"actions"
));
		byte[] bytes = s4_Packaging_Utility.generateTemplate(headerList);
		byte[] encoded = Base64.getEncoder().encode(bytes);
		String base64 = new String(encoded);
		return new PayloadDto(base64, "xlsx");
	}
	
	public List<Change_LogDto> getFlag0FromChangeLogTable(){
		return packaging_table_Repository.getFlag0FromChangeLogTable();
	}
}	