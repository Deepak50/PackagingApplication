package com.incture.controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incture.compositeKey.Sample_CK;
import com.incture.dto.AutoGenDto;
import com.incture.dto.PayloadDto;
import com.incture.dto.ResponseDto;
import com.incture.dto.S4_PackagingDto;
import com.incture.dto.SampleDto;
import com.incture.entity.AutoGen;
import com.incture.entity.Sample;
import com.incture.repository.S4_Packaging_Repository;
import com.incture.service.S4_Packaging_Service;

@RestController
@RequestMapping(value = "/main", produces = "application/json")
public class S4_Packaging_Controller {

	@Autowired
	S4_Packaging_Service ms;

	@Autowired
	S4_Packaging_Repository mr;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return ms.test();
	}

	@RequestMapping(value = "/testAuto", method = RequestMethod.POST, consumes = "application/json")
	public String testAuto() {
		return ms.testAuto();
	}

	@RequestMapping(value = "/insertFromPostman", method = RequestMethod.POST, consumes = "application/json")
	public String insertFromPostman(@RequestBody S4_PackagingDto s4_PackagingDto) {
		System.out.println("Inside controller : " + s4_PackagingDto.getPartNum());
		return ms.insertFromPostman(s4_PackagingDto);
	}

	@RequestMapping(value = "/generateTemplate", method = RequestMethod.GET)
	public PayloadDto generateTemplate() {
		return ms.generateTemplate();
	}

	@RequestMapping(value = "/insertFromExcel", method = RequestMethod.POST)
	public ResponseDto insertFromExcel(@RequestBody String base64Str) {
		return ms.insertFromExcel(base64Str); // argument is present just to
												// keep
												// options open for input
												// through
												// postman
	}

	@RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
	public PayloadDto downloadExcel() {
		return ms.downloadExcel();
	}

	@RequestMapping(value = "/sampleInsert", method = RequestMethod.POST, consumes = "application/json")
	public String sampleInsert(@RequestBody SampleDto sampleDto) {
		Sample_CK sample_CK = new Sample_CK();
		sample_CK.setId(sampleDto.getId());
		System.out.println(sampleDto.getId());
		sample_CK.setName(sampleDto.getName());
		System.out.println(sampleDto.getName());
		Sample sample = new Sample();
		sample.setSample_CK(sample_CK);
		sample.setAge(sampleDto.getAge());
		System.out.println(sampleDto.getAge());
		return ms.sampleInsert(sample);
	}

	@RequestMapping(value = "/pdfConvert", method = RequestMethod.GET)
	public PayloadDto pdfConvert() {
		return ms.pdfConvert();
	}

	//Related to AutoGeneration
	@RequestMapping(value = "/saveAutoGen", method = RequestMethod.POST, consumes = "application/json")
	public AutoGenDto save(@RequestBody AutoGenDto autoGenDto) {
		System.out.println(autoGenDto);
		return mr.save(autoGenDto);
	}

	//Related to AutoGeneration
	@RequestMapping(value = "/getAllAutoGen", method = RequestMethod.GET)
	public List<AutoGen> getAll() {
		return mr.getAll();
	}
	
	//Related to mailing
	@RequestMapping(value = "/sendMailBasicAuth", method = RequestMethod.GET)
	public void sendMailBasicAuth(){
		ms.sendMailBasicAuth();
	}
	
	@RequestMapping(value = "/sendMailOAuth", method = RequestMethod.GET)
	public void sendMailOauth(){
		ms.sendMailOAuth();
	}
	
	@RequestMapping(value="/redirect", method = RequestMethod.GET)
	public void redirect(){
		CloseableHttpClient httpclient = HttpClients.createDefault();

	      //Creating a HttpGet object
	      HttpGet httpget = new HttpGet("https://www.tutorialspoint.com/");

	      //Printing the method used
	      System.out.println("Request Type: "+httpget.getMethod());

	      //Executing the Get request
	      HttpResponse httpresponse = null;
		try {
			httpresponse = httpclient.execute(httpget);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	      Scanner sc = null;
		try {
			sc = new Scanner(httpresponse.getEntity().getContent());
		} catch (UnsupportedOperationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	      //Printing the status line
	      System.out.println(httpresponse.getStatusLine());
	      while(sc.hasNext()) {
	         System.out.println(sc.nextLine());
	      }
	}
}