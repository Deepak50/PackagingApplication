package com.incture.utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import com.incture.dto.ExcelDto;
import com.incture.dto.PayloadDto;
import com.incture.dto.S4_PackagingDto;
import com.itextpdf.layout.element.Table;

@Component
public class S4_Packaging_Utility {
	
	public HSSFWorkbook prepareWorkbook(List<String> headerList){
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Template");
		Row rowH = sheet.createRow(0);
		int n = headerList.size();
		Cell cell[] = new Cell[n];
		for(int i = 0;i<n;i++){
			cell[i] = rowH.createCell(i);
			cell[i].setCellValue(headerList.get(i));
		}
		return workbook;
	}
	
	public void writeToDisk(HSSFWorkbook workbook){
		OutputStream fileOut;
		try {
			fileOut = new FileOutputStream("C:\\ExcelSheets\\template.xlsx");
			workbook.write(fileOut);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {

		}
	}
	
	public byte[] convertToBytes(HSSFWorkbook workbook){
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
		return bytes;
	}
	
	public byte[] generateTemplate(List<String> headerList) {
		HSSFWorkbook workbook = prepareWorkbook(headerList);
		writeToDisk(workbook);
		byte[] bytes = convertToBytes(workbook);
		return bytes;
	}

	public Table prepareTable(Table table, List<String> headerList) {
		for(int i = 0;i<headerList.size();i++){
			table.addCell(headerList.get(i));
		}
		return table;
	}
}
