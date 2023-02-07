package com.incture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.incture.dto.Base64Dto;
import com.incture.dto.Change_LogDto;
import com.incture.dto.FilterDto;
import com.incture.dto.Packaging_tableDto;
import com.incture.dto.PayloadDto;
import com.incture.dto.ResponseDto;
import com.incture.service.Packaging_table_Service;

@RestController
@RequestMapping(value = "/main", produces = "application/json")
public class Packaging_table_Controller {
	
	@Autowired
	Packaging_table_Service packaging_table_Service;
	
	@RequestMapping(value = "/filterData/{pageNo}/{count}", method = RequestMethod.POST, consumes = "application/json")
	public List<Packaging_tableDto> filterData(@RequestBody FilterDto filterDto, @PathVariable(value = "pageNo") String pageNo, @PathVariable(value = "count") String count){
		filterDto.setPageNo(pageNo);
		filterDto.setCount(count);
		return packaging_table_Service.filter(filterDto);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = "application/json")
	public ResponseDto insert(@RequestBody Packaging_tableDto packaging_tableDto){
		return packaging_table_Service.insert(packaging_tableDto);
	}
	
	@RequestMapping(value = "test/{someID}/{name}")
	public @ResponseBody ResponseDto urlParameteTest(@PathVariable(value="someID") String id, @PathVariable(value = "name") String name) {
		return new ResponseDto("200",id+" "+name,"Successfull");
	}
	
	@RequestMapping(value = "batchInsert", method = RequestMethod.POST, consumes = "application/json")
	public ResponseDto batchInsertTest(@RequestBody Base64Dto base64Dto){
		return packaging_table_Service.batchInsertTest(base64Dto);
	}
	
	@RequestMapping(value = "/generatePackagingTemplate", method = RequestMethod.GET)
	public PayloadDto generateTemplate() {
		return packaging_table_Service.generatePackagingTemplate();
	}	
	
	@RequestMapping(value = "/getFlag0FromChangeLogtable", method = RequestMethod.GET)
	public List<Change_LogDto> getFlag0FromChangeLogTable(){
		return packaging_table_Service.getFlag0FromChangeLogTable();
	}
	
}
