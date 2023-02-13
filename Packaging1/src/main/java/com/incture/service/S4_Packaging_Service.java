package com.incture.service;

import com.incture.dto.PayloadDto;
import com.incture.dto.ResponseDto;
import com.incture.dto.S4_PackagingDto;
import com.incture.entity.Sample;

public interface S4_Packaging_Service {
	public String test();

	public String insertFromPostman(S4_PackagingDto s4_PackagingDto);

	public PayloadDto generateTemplate();

	public ResponseDto insertFromExcel(String base64Str);

	public PayloadDto downloadExcel();

	public String sampleInsert(Sample sample);

	public PayloadDto pdfConvert();

	public String testAuto();
	
	public void sendMailBasicAuth();
	
	public void sendMailOAuth();
}
