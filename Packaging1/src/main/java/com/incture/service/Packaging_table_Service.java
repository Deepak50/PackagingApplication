package com.incture.service;

import java.util.List;

import com.incture.dto.Base64Dto;
import com.incture.dto.Change_LogDto;
import com.incture.dto.FilterDto;
import com.incture.dto.Packaging_tableDto;
import com.incture.dto.PayloadDto;
import com.incture.dto.ResponseDto;

public interface Packaging_table_Service {
	public List<Packaging_tableDto> filter(FilterDto filterDto);

	public ResponseDto insert(Packaging_tableDto packaging_tableDto);

	public ResponseDto batchInsertTest(Base64Dto base64Dto);

	public PayloadDto generatePackagingTemplate();
	
	public List<Change_LogDto> getFlag0FromChangeLogTable();
}
