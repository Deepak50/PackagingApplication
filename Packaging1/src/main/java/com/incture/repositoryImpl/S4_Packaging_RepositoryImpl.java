package com.incture.repositoryImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

		// if(autoGenDto.getId() != null){
		// autoGen.setId(autoGenDto.getId());
		// }
		// else{
		// autoGen.setId(null);
		// }
		if (autoGenDto.getId() != null)
			idd = new Integer(autoGenDto.getId());
		else
			idd = null;
		autoGen.setName(autoGenDto.getName());
		System.out.println(autoGen);
		return autoGen;
	}

	// Related to AutoGeneration
	@Override
	public AutoGenDto save(AutoGenDto dto) {
		System.out.println("Dto" + dto);
		if (dto.getId() != null) {
			String queryString = "insert into \"USR_EYDCV8U0D03RRFFGCL3N91N7X\".\"AutoGen5\" values(:name,:id)";
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(queryString);
			query.setParameter("id", dto.getId());
			query.setParameter("name", dto.getName());
			// sessionFactory.getCurrentSession().saveOrUpdate(giveDo(dto));
			query.executeUpdate();
		} else {
			sessionFactory.getCurrentSession().saveOrUpdate(giveDo(dto));
		}
		return null;
	}

	// Related to AutoGeneration
	@Override
	public List<AutoGen> getAll() {
		String queryStr = "from AutoGen";
		Query query = sessionFactory.getCurrentSession().createQuery(queryStr);
		return query.getResultList();
	}
}