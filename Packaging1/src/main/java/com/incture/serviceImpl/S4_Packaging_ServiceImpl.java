package com.incture.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.incture.dto.ExcelDto;
import com.incture.dto.PayloadDto;
import com.incture.dto.ResponseDto;
import com.incture.dto.S4_PackagingDto;
import com.incture.entity.Sample;
import com.incture.repository.S4_Packaging_Repository;
import com.incture.service.S4_Packaging_Service;
import com.incture.utility.S4_Packaging_Utility;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
//Experiment 2
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;

@Service
public class S4_Packaging_ServiceImpl implements S4_Packaging_Service {

	@Autowired
	private S4_Packaging_Repository mr;

	@Autowired(required = true)
	private S4_Packaging_Utility mu;

	public String test() {
		return mr.test();
	}

	public String insertFromPostman(S4_PackagingDto s4_PackagingDto) {
		return mr.insertFromPostman(s4_PackagingDto);
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

	public PayloadDto generateTemplate() {
		List<String> headerList = new ArrayList<String>(Arrays.asList("Part Num", "Supplier Id", "Part Description",
				"Plant", "Part Weight", "Part Length", "Part Height", "Part Width"));
		byte[] bytes = mu.generateTemplate(headerList);
		byte[] encoded = Base64.getEncoder().encode(bytes);
		String base64 = new String(encoded);
		return new PayloadDto(base64, "xlsx");
	}

	public ExcelDto convertToExcelDto(Row row) {
		ExcelDto excelDto = new ExcelDto();
		excelDto.setPartNo(row.getCell(0).toString());
		excelDto.setSupplierId(row.getCell(1).toString());
		excelDto.setPlant(row.getCell(3).toString());
		if (row.getCell(2) != null)
			excelDto.setPartDescription(row.getCell(2).toString());
		if (row.getCell(4) != null)
			excelDto.setPartWeight(row.getCell(4).toString());
		if (row.getCell(5) != null)
			excelDto.setPartlength(row.getCell(5).toString());
		if (row.getCell(6) != null)
			excelDto.setPartHeight(row.getCell(6).toString());
		if (row.getCell(7) != null)
			excelDto.setPartWidth(row.getCell(7).toString());
		return excelDto;
	}

	public ResponseDto insertFromExcel(String base64Str) {
		byte[] decoded = Base64.getDecoder().decode(base64Str);
		HSSFWorkbook workbook = convertToWorkbook(decoded);
		HSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		Row row0 = sheet.getRow(0);
		int cellCount = row0.getPhysicalNumberOfCells();
		for (int i = 1; i < rowCount; i++) {
			Row row = sheet.getRow(i);
			ExcelDto excelDto = convertToExcelDto(row);
			mr.insertFromExcel(excelDto);
		}
		ResponseDto responseDto = new ResponseDto("Inserting from excel successful", "200", "Success");
		return responseDto;
	}

	// @Override
	public PayloadDto downloadExcel() {
		List<String> headerList = new ArrayList<String>(Arrays.asList("Part Num", "Plant", "Supplier Id", "Created By",
				"Created Date", "Part Height", "Part Length", "Max Qty Per KG", "Mixed Package", "Mixed Pallet",
				"Packaging Material", "Pallet Packaging Material", "Part Description", "Pkd Wild Card", "Sec Pkg Mat",
				"Ships on Pallet", "Status", "Updated By", "Updated Date", "Part Weight", "Part Width"));
		List<S4_PackagingDto> s4_PackagingDtoList = new ArrayList<S4_PackagingDto>();
		s4_PackagingDtoList = mr.getAllRecords();

		HSSFWorkbook workbook = mu.prepareWorkbook(headerList);
		HSSFSheet sheet = workbook.getSheetAt(0);
		int rownum = 1;
		for (S4_PackagingDto s4_PackagingDto : s4_PackagingDtoList) {
			Row row = sheet.createRow(rownum++);
			Cell cell0 = row.createCell(0);
			cell0.setCellValue(s4_PackagingDto.getPartNum());
			Cell cell1 = row.createCell(1);
			cell1.setCellValue(s4_PackagingDto.getPlant());
			Cell cell2 = row.createCell(2);
			cell2.setCellValue(s4_PackagingDto.getSupplierId());
			Cell cell3 = row.createCell(3);
			cell3.setCellValue(s4_PackagingDto.getCreatedBy());
			Cell cell4 = row.createCell(4);
			cell4.setCellValue(s4_PackagingDto.getCreatedDate());
			Cell cell5 = row.createCell(5);
			cell5.setCellValue(s4_PackagingDto.getHeight());
			Cell cell6 = row.createCell(6);
			cell6.setCellValue(s4_PackagingDto.getLength());
			Cell cell7 = row.createCell(7);
			cell7.setCellValue(s4_PackagingDto.getMaxQtyPerKg());
			Cell cell8 = row.createCell(8);
			cell8.setCellValue(s4_PackagingDto.getMixedPackage());
			Cell cell9 = row.createCell(9);
			cell9.setCellValue(s4_PackagingDto.getMixedPallet());
			Cell cell10 = row.createCell(10);
			cell10.setCellValue(s4_PackagingDto.getPackagingMaterial());
			Cell cell11 = row.createCell(11);
			cell11.setCellValue(s4_PackagingDto.getPalletPackagingMaterial());
			Cell cell12 = row.createCell(12);
			cell12.setCellValue(s4_PackagingDto.getPartDesc());
			Cell cell13 = row.createCell(13);
			cell13.setCellValue(s4_PackagingDto.getPkdWildCard());
			Cell cell14 = row.createCell(14);
			cell14.setCellValue(s4_PackagingDto.getSecPkgMat());
			Cell cell15 = row.createCell(15);
			cell15.setCellValue(s4_PackagingDto.getShipsOnPallet());
			Cell cell16 = row.createCell(16);
			cell16.setCellValue(s4_PackagingDto.getStatus());
			Cell cell17 = row.createCell(17);
			cell17.setCellValue(s4_PackagingDto.getUpdatedBy());
			Cell cell18 = row.createCell(18);
			cell18.setCellValue(s4_PackagingDto.getUpdatedDate());
			Cell cell19 = row.createCell(19);
			cell19.setCellValue(s4_PackagingDto.getWeight());
			Cell cell20 = row.createCell(20);
			cell20.setCellValue(s4_PackagingDto.getWidth());
		}

		OutputStream fileOut;
		try {
			fileOut = new FileOutputStream("C:\\ExcelSheets\\DownloadedExcel.xlsx");
			workbook.write(fileOut);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
		}

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			workbook.write(bos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			bos.close();
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		byte[] bytes = bos.toByteArray();
		byte[] encoded = Base64.getEncoder().encode(bytes);
		String base64 = new String(encoded);
		return new PayloadDto(base64, "xlsx");
	}

	public String sampleInsert(Sample sample) {
		return mr.sampleInsert(sample);
	}

	public PayloadDto pdfConvert() {
		// Step-1 Creating a PdfDocument object
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		PdfDocument pdfDoc = null;
		pdfDoc = new PdfDocument(new PdfWriter(bos));

		// Step-2 Creating a Document object
		Document doc = new Document(pdfDoc, PageSize.B2);

		List<String> headerList = new ArrayList<String>(Arrays.asList("Part Num", "Plant", "Supplier Id", "Created By",
				"Created Date", "Part Height", "Part Length", "Max Qty Per KG", "Mixed Package", "Mixed Pallet",
				"Packaging Material", "Pallet Packaging Material", "Part Description", "Pkd Wild Card", "Sec Pkg Mat",
				"Ships on Pallet", "Status", "Updated By", "Updated Date", "Part Weight", "Part Width"));
		List<S4_PackagingDto> s4_PackagingDtoList = new ArrayList<S4_PackagingDto>();
		s4_PackagingDtoList = mr.getAllRecords();
		Table table = new Table(headerList.size());
		table = mu.prepareTable(table, headerList);

		for (S4_PackagingDto s4_PackagingDto : s4_PackagingDtoList) {
			table.addCell(s4_PackagingDto.getPartNum().toString());

			table.addCell(s4_PackagingDto.getPlant().toString());

			table.addCell(s4_PackagingDto.getSupplierId().toString());

			if (s4_PackagingDto.getCreatedBy() != null)
				table.addCell(s4_PackagingDto.getCreatedBy());
			else
				table.addCell("");

			if (s4_PackagingDto.getCreatedDate() != null)
				table.addCell(s4_PackagingDto.getCreatedDate().toString());
			else
				table.addCell("");

			if (s4_PackagingDto.getHeight() != null)
				table.addCell(s4_PackagingDto.getHeight().toString());
			else
				table.addCell("");

			if (s4_PackagingDto.getLength() != null)
				table.addCell(s4_PackagingDto.getLength().toString());
			else
				table.addCell("");

			if (s4_PackagingDto.getMaxQtyPerKg() != null)
				table.addCell(s4_PackagingDto.getMaxQtyPerKg().toString());
			else
				table.addCell("");

			if (s4_PackagingDto.getMixedPackage() != null)
				table.addCell(s4_PackagingDto.getMixedPackage().toString());
			else
				table.addCell("");

			if (s4_PackagingDto.getMixedPallet() != null)
				table.addCell(s4_PackagingDto.getMixedPallet().toString());
			else
				table.addCell("");

			if (s4_PackagingDto.getPackagingMaterial() != null)
				table.addCell(s4_PackagingDto.getPackagingMaterial().toString());
			else
				table.addCell("");

			if (s4_PackagingDto.getPalletPackagingMaterial() != null)
				table.addCell(s4_PackagingDto.getPalletPackagingMaterial().toString());
			else
				table.addCell("");

			if (s4_PackagingDto.getPartDesc() != null)
				table.addCell(s4_PackagingDto.getPartDesc().toString());
			else
				table.addCell("");

			if (s4_PackagingDto.getPkdWildCard() != null)
				table.addCell(s4_PackagingDto.getPkdWildCard().toString());
			else
				table.addCell("");

			if (s4_PackagingDto.getSecPkgMat() != null)
				table.addCell(s4_PackagingDto.getSecPkgMat().toString());
			else
				table.addCell("");

			if (s4_PackagingDto.getShipsOnPallet() != null)
				table.addCell(s4_PackagingDto.getShipsOnPallet().toString());
			else
				table.addCell("");

			if (s4_PackagingDto.getStatus() != null)
				table.addCell(s4_PackagingDto.getStatus().toString());
			else
				table.addCell("");

			if (s4_PackagingDto.getUpdatedBy() != null)
				table.addCell(s4_PackagingDto.getUpdatedBy().toString());
			else
				table.addCell("");

			if (s4_PackagingDto.getUpdatedDate() != null)
				table.addCell(s4_PackagingDto.getUpdatedDate().toString());
			else
				table.addCell("");

			if (s4_PackagingDto.getWeight() != null)
				table.addCell(s4_PackagingDto.getWeight().toString());
			else
				table.addCell("");

			if (s4_PackagingDto.getWidth() != null)
				table.addCell(s4_PackagingDto.getWidth().toString());
			else
				table.addCell("");
		}

		// Step-6 Adding Table to document
		doc.add(table);

		// Step-7 Closing the document
		doc.close();

		byte[] bytes = bos.toByteArray();
		byte[] encoded = Base64.getEncoder().encode(bytes);
		String base64 = new String(encoded);
		return new PayloadDto(base64, "pdf");
	}

	@Override
	public String testAuto() {
		return mr.testAuto();
	}

	@Override
	public void sendMailBasicAuth() {
		mr.sendMailBasicAuth();
	}

	@Override
	public void sendMailOAuth() {
		mr.sendMailOAuth();
	}
}