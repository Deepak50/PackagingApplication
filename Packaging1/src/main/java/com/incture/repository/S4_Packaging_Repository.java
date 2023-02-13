package com.incture.repository;
import java.util.List;

import com.incture.dto.AutoGenDto;
import com.incture.dto.ExcelDto;
import com.incture.dto.S4_PackagingDto;
import com.incture.entity.AutoGen;
import com.incture.entity.Sample;

public interface S4_Packaging_Repository {
	public String test();

	public String insertFromPostman(S4_PackagingDto s4_PackagingDto);

	public String insertFromExcel(ExcelDto excelDto);

	public List<S4_PackagingDto> getAllRecords();

	public String sampleInsert(Sample sample);

	public String testAuto();
	
	public AutoGenDto save(AutoGenDto dto);
	
	public List<AutoGen> getAll();
	
	public void sendMailBasicAuth();
	
	public void sendMailOAuth();
}
