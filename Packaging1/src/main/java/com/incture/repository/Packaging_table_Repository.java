package com.incture.repository;

import java.util.List;

import com.incture.dto.Change_LogDto;
import com.incture.dto.FilterDto;
import com.incture.dto.Packaging_tableDto;
import com.incture.dto.ResponseDto;

public interface Packaging_table_Repository {
	public List<Packaging_tableDto> filter(FilterDto filterDto);
	public ResponseDto insert(Packaging_tableDto packaging_tableDto);
	//public ResponseDto batchInsertTest(Base64Dto base64Dto);
	public ResponseDto batchInsertTest(List<Packaging_tableDto> packaging_tableDtoList);
	public List<Change_LogDto> getFlag0FromChangeLogTable();
	
}
