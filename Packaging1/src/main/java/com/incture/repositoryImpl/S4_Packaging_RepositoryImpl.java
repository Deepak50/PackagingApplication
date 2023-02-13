package com.incture.repositoryImpl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest.AuthenticationRequestBuilder;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Repository;

import com.incture.compositeKey.Change_Log_CK;
import com.incture.compositeKey.S4_Packaging_CK;
import com.incture.dto.AutoGenDto;
import com.incture.dto.Change_LogDto;
import com.incture.dto.ExcelDto;
import com.incture.dto.S4_PackagingDto;
import com.incture.entity.AutoGen;
import com.incture.entity.Change_Log;
import com.incture.entity.S4_Packaging;
import com.incture.entity.Sample;
import com.incture.repository.S4_Packaging_Repository;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Repository
@Transactional
public class S4_Packaging_RepositoryImpl implements S4_Packaging_Repository {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	private Date date;
	private Timestamp timeNow;

	public String test() {
		return "testing Packaging1";
	}

	public static Integer idd;

	public S4_Packaging giveS4PackagingDo(S4_PackagingDto s4_PackagingDto) {
		date = new Date();
		timeNow = new Timestamp(date.getTime());
		S4_Packaging s4_Packaging = new S4_Packaging();
		S4_Packaging_CK s4_Packaging_CK = new S4_Packaging_CK();
		s4_Packaging_CK.setPART_NUM(s4_PackagingDto.getPartNum());
		s4_Packaging_CK.setPLANT(s4_PackagingDto.getPlant());
		s4_Packaging_CK.setSUPPLIER_ID(s4_PackagingDto.getSupplierId());
		s4_Packaging.setS4_Packaging_CK(s4_Packaging_CK);
		s4_Packaging.setCREATED_BY(s4_PackagingDto.getCreatedBy());
		s4_Packaging.setHEIGHT(s4_PackagingDto.getHeight());
		s4_Packaging.setLENGTH(s4_PackagingDto.getLength());
		s4_Packaging.setMAX_QTY_PER_KG(s4_PackagingDto.getMaxQtyPerKg());
		s4_Packaging.setMIXED_PACKAGE(s4_PackagingDto.getMixedPackage());
		s4_Packaging.setMIXED_PALLET(s4_PackagingDto.getMixedPallet());
		s4_Packaging.setPACKAGING_MATERIAL(s4_PackagingDto.getPackagingMaterial());
		s4_Packaging.setPALLET_PACKAGING_MATERIAL(s4_PackagingDto.getPalletPackagingMaterial());
		s4_Packaging.setPART_DESC(s4_PackagingDto.getPartDesc());
		s4_Packaging.setPKD_WILD_CARD(s4_PackagingDto.getPkdWildCard());
		s4_Packaging.setSEC_PKG_MAT(s4_PackagingDto.getSecPkgMat());
		s4_Packaging.setSHIPS_ON_PALLET(s4_PackagingDto.getShipsOnPallet());
		s4_Packaging.setSTATUS(s4_PackagingDto.getStatus());
		s4_Packaging.setUPDATED_BY(s4_PackagingDto.getUpdatedBy());
		s4_Packaging.setWEIGHT(s4_PackagingDto.getWeight());
		s4_Packaging.setWIDTH(s4_PackagingDto.getWidth());
		return s4_Packaging;
	}

	// Dto class is not used much in this project.. So not sure how correct this
	// code is..Works pretty fine
	public S4_PackagingDto giveS4PackagingDto(S4_Packaging s4_Packaging) {
		S4_PackagingDto s4_PackagingDto = new S4_PackagingDto();
		S4_Packaging_CK s4_Packaging_CK = s4_Packaging.getS4_Packaging_CK();
		s4_PackagingDto.setPartNum(s4_Packaging_CK.getPART_NUM());
		s4_PackagingDto.setPlant(s4_Packaging_CK.getPLANT());
		s4_PackagingDto.setSupplierId(s4_Packaging_CK.getSUPPLIER_ID());
		s4_PackagingDto.setCreatedBy(s4_Packaging.getCREATED_BY());
		String dt1 = s4_Packaging.getCREATED_DATE().toString(); //
		s4_PackagingDto.setCreatedDate(dt1);
		s4_PackagingDto.setHeight(s4_Packaging.getHEIGHT());
		s4_PackagingDto.setLength(s4_Packaging.getLENGTH());
		s4_PackagingDto.setMaxQtyPerKg(s4_Packaging.getMAX_QTY_PER_KG());
		s4_PackagingDto.setMixedPackage(s4_Packaging.getMIXED_PACKAGE());
		s4_PackagingDto.setMixedPallet(s4_Packaging.getMIXED_PALLET());
		s4_PackagingDto.setPackagingMaterial(s4_Packaging.getPACKAGING_MATERIAL());
		s4_PackagingDto.setPalletPackagingMaterial(s4_Packaging.getPALLET_PACKAGING_MATERIAL());
		s4_PackagingDto.setPartDesc(s4_Packaging.getPART_DESC());
		s4_PackagingDto.setPkdWildCard(s4_Packaging.getPKD_WILD_CARD());
		s4_PackagingDto.setSecPkgMat(s4_Packaging.getSEC_PKG_MAT());
		s4_PackagingDto.setShipsOnPallet(s4_Packaging.getSHIPS_ON_PALLET());
		s4_PackagingDto.setStatus(s4_Packaging.getSTATUS());
		s4_PackagingDto.setUpdatedBy(s4_Packaging.getUPDATED_BY());
		String dt2 = s4_Packaging.getUPDATED_DATE().toString();
		s4_PackagingDto.setUpdatedDate(dt2);
		s4_PackagingDto.setWeight(s4_Packaging.getWEIGHT());
		s4_PackagingDto.setWidth(s4_Packaging.getWIDTH());
		return s4_PackagingDto;
	}

	public Change_Log giveChangeLogDo(Change_LogDto change_LogDto) {
		Change_Log change_Log = new Change_Log();
		Change_Log_CK change_Log_CK = new Change_Log_CK();
		change_Log_CK.setPART_NUM(change_LogDto.getPartNum());
		change_Log_CK.setSUPPLIER_ID(change_LogDto.getSupplierId());
		change_Log.setChange_Log_CK(change_Log_CK);
		change_Log.setFLAG(change_LogDto.getFlag());
		change_Log.setUPDATED_BY(change_LogDto.getUpdatedBy());
		return change_Log;
	}

	public String insertFromPostman(S4_PackagingDto s4_PackagingDto) {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		if (s4_PackagingDto != null) {
			S4_Packaging s4_PackagingDo = giveS4PackagingDo(s4_PackagingDto);
			s4_PackagingDo.setCREATED_DATE(ts);
			s4_PackagingDo.setUPDATED_DATE(ts); // actual time updation
			sessionFactory.getCurrentSession().saveOrUpdate(s4_PackagingDo);
			Change_LogDto change_LogDto = new Change_LogDto();
			change_LogDto.setPartNum(s4_PackagingDto.getPartNum());
			change_LogDto.setSupplierId(s4_PackagingDto.getSupplierId());
			change_LogDto.setUpdatedBy(s4_PackagingDto.getUpdatedBy());
			change_LogDto.setUpdatedDate(timeNow.toString());
			change_LogDto.setFlag("00");
			Change_Log change_LogDo = giveChangeLogDo(change_LogDto);
			change_LogDo.setUPDATED_DATE(ts); // actual time updation
			sessionFactory.getCurrentSession().saveOrUpdate(change_LogDo);
			return "Successfully Inserted";
		}
		return "Object not found";
	}

	// @Override
	public String insertFromExcel(ExcelDto excelDto) {
		S4_PackagingDto s4_PackagingDto = new S4_PackagingDto();
		s4_PackagingDto.setPartNum(excelDto.getPartNo());
		s4_PackagingDto.setPlant(excelDto.getPlant());
		s4_PackagingDto.setSupplierId(excelDto.getSupplierId());
		if (excelDto.getPartDescription() != null)
			s4_PackagingDto.setPartDesc(excelDto.getPartDescription());
		if (excelDto.getPartWeight() != null)
			s4_PackagingDto.setWeight(excelDto.getPartWeight());
		if (excelDto.getPartlength() != null)
			s4_PackagingDto.setLength(excelDto.getPartlength());
		if (excelDto.getPartHeight() != null)
			s4_PackagingDto.setHeight(excelDto.getPartHeight());
		if (excelDto.getPartWidth() != null)
			s4_PackagingDto.setWidth(excelDto.getPartWidth());
		S4_Packaging s4_Packaging = giveS4PackagingDo(s4_PackagingDto);
		sessionFactory.getCurrentSession().saveOrUpdate(s4_Packaging);
		Change_LogDto change_LogDto = new Change_LogDto();
		change_LogDto.setPartNum(excelDto.getPartNo());
		change_LogDto.setSupplierId(excelDto.getSupplierId());
		change_LogDto.setFlag("00");
		Change_Log change_LogDo = giveChangeLogDo(change_LogDto);
		// change_LogDo.setUPDATED_DATE(ts); // actual time updation
		sessionFactory.getCurrentSession().saveOrUpdate(change_LogDo);
		return "Successful";
	}

	public List<S4_PackagingDto> getAllRecords() {
		String queryStr = "from S4_Packaging";
		Query query = sessionFactory.getCurrentSession().createQuery(queryStr);
		List<S4_Packaging> resultSet = query.getResultList();
		List<S4_PackagingDto> S4_PackagingDtoList = new ArrayList<S4_PackagingDto>();
		for (S4_Packaging s4_Packaging : resultSet) {
			S4_PackagingDtoList.add(giveS4PackagingDto(s4_Packaging));
		}
		return S4_PackagingDtoList;
	}

	public String sampleInsert(Sample sample) {
		sessionFactory.getCurrentSession().saveOrUpdate(sample);
		return "Successful";
	}

	@Override
	public String testAuto() {
		return "Testing auto";
	}

	public AutoGen giveDo(AutoGenDto autoGenDto) {
		AutoGen autoGen = new AutoGen();
		if (autoGenDto.getId() != null)
			idd = new Integer(autoGenDto.getId());
		else
			idd = null;
		autoGen.setId(autoGenDto.getId());
		autoGen.setName(autoGenDto.getName());
		System.out.println("The idd is : " + idd);
		return autoGen;
	}

	// Related to AutoGeneration
	@Override
	public AutoGenDto save(AutoGenDto dto) {
		System.out.println("Dto" + dto);
		sessionFactory.getCurrentSession().saveOrUpdate(giveDo(dto));
		return null;
	}

	// Related to AutoGeneration
	@Override
	public List<AutoGen> getAll() {
		String queryStr = "from AutoGen";
		Query query = sessionFactory.getCurrentSession().createQuery(queryStr);
		return query.getResultList();
	}

	// Related to sending emails using basic authentication
	@Override
	public void sendMailBasicAuth() {
		String host = "m.outlook.com";
		final String user = "kushalappa.ca@incture.com";// change accordingly
		final String password = "kushal@inc1234";// change accordingly

		String to = "deepakkushalappa123@gmail.com"; // change accordingly
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true"); // this is to enable
														// secure connection (no
														// idea how)
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // explicitly set this
															// to TLSv1.2 (no
															// idea why)
		javax.mail.Session session = javax.mail.Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Testing Basic Authentication");
			message.setText("This is a mail sent using Basic Authentication");
			Transport.send(message);
			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	// perfectly working except for token
	@Override
	public void sendMailOAuth() {
		// get access token
		// the setcode() attribute has to be newly set everytime. Code can be obtained from making an http call in the browser with url: https://login.microsoftonline.com/78d7cfc1-dedd-4464-b309-74a59265897e/oauth2/v2.0/authorize?client_id=99b2143a-be2a-462b-bbe4-f4d1573b5d9a&response_type=code&redirect_uri=https://login.microsoftonline.com/common/oauth2/nativeclient&response_mode=query&scope=https://outlook.office365.com/.default
		OAuthClient client = new OAuthClient(new URLConnectionClient());
		OAuthClientRequest request = null;
		try {
			request = OAuthClientRequest
					.tokenLocation(
							"https://login.microsoftonline.com/78d7cfc1-dedd-4464-b309-74a59265897e/oauth2/v2.0/token")
					.setGrantType(GrantType.AUTHORIZATION_CODE).setClientId("99b2143a-be2a-462b-bbe4-f4d1573b5d9a")
					.setClientSecret("9PP8Q~0V~iYrlIu_j~5KTnHulAhp_zRzfxKuxaeY")
					.setScope("https://outlook.office365.com/.default") //the below code has to be newly generated everytime. This can be found at 
					.setCode(
							"0.AXIAwc_XeN3eZESzCXSlkmWJfjoUspkqvitGu-T00Vc7XZpyAOc.AgABAAIAAAD--DLA3VO7QrddgJg7WevrAgDs_wUA9P-JQPvUrho9LfQXlSNkVR375hTPgj6cp9_f9Z4ggKUeLp_4Ez1wB-XgxYranC769YBo6yRnTFsQz1JtdVzsB0hxnnEOZ2sg6Je3sv23s5oqlGDoOh0NThk2G26T841oEHcrPTeV0Q1ZmfLcF0d5KuJsSXqjcLrl9Y_25aRuNMr0HqcE2ioJ06-i6teMmAr4za3MGaOPKTjHw2zliYA8ZLcyO8Mud3BJbpf7s3ZUmmapRp7_lmVCNJ6OrN9YC3CbELkye3vKNd31vNE0-3afhGLUP7TCUgMlkNiaEy0tuNJPnOA9D3cuAqnOXWkkOqq7_n5sMjeKwcIh-EfmKEb7oPHsmnPFhGq4Sx6J7W79l4TcyM8SXmnhrsb86pnCfyn7G8UFFq4hGg_N5J5QSGSKOSoS6i5IXzTfFWDJhmeoQbSETNdbs7Fqd1OkK3ZHg-MiABk__lYFjhc08NtF1kFLvUmmDmIEiSnhvIAhy4-4bSM2nD_6Wz5v_yP0H6q_IsUW_2j6NuQnrdHPi1gljQ-scorVEAAJld3ifWWkRBPoHbJBTbXbF9kJfQAjkVurNIqUeF2UE87KiPZeYMqCm2O15F7L4BtVjxwZyoIHWH_Cgtsw3Ok0K2Q6ADXDT04BNWcm5MvhxjdCAhE3xrAjYlentqK1lNi7-3mUzASbDyYZJttb")
					.setRedirectURI("https://login.microsoftonline.com/common/oauth2/nativeclient").buildBodyMessage();
		} catch (OAuthSystemException e) {
			e.printStackTrace();
		}
		String token = "a";
		try {
			token = client.accessToken(request, OAuth.HttpMethod.POST, OAuthJSONAccessTokenResponse.class)
					.getAccessToken();
		} catch (OAuthSystemException | OAuthProblemException e1) {
			e1.printStackTrace();
		}

		System.out.println(token);
		OkHttpClient okClient = new OkHttpClient().newBuilder().build();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType,
				"{\r\n  \"Message\": {\r\n    \"Subject\": \"Its working2?\",\r\n    \"Body\": {\r\n      \"ContentType\": \"Text\",\r\n      \"Content\": \"Its working2.\"\r\n    },\r\n    \"ToRecipients\": [\r\n      {\r\n        \"EmailAddress\": {\r\n          \"Address\": \"kushalappa.ca@incture.com\"\r\n        }\r\n      }\r\n    ],\r\n    \"Attachments\": [\r\n      {\r\n        \"@odata.type\": \"#Microsoft.OutlookServices.FileAttachment\",\r\n        \"Name\": \"menu.txt\",\r\n        \"ContentBytes\": \"bWFjIGFuZCBjaGVlc2UgdG9kYXk=\"\r\n      }\r\n    ]\r\n  },\r\n  \"SaveToSentItems\": \"false\"\r\n}");
		Request okRequest = new Request.Builder().url("https://outlook.office.com/api/v2.0/me/sendMail")
				.method("POST", body).addHeader("Authorization", "Bearer " + token)
				.addHeader("Content-Type", "application/json").build();
		try {
			Response response = okClient.newCall(okRequest).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}