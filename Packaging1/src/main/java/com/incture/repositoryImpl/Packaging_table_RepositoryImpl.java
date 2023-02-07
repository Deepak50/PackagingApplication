package com.incture.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.incture.compositeKey.Packaging_table_CK;
import com.incture.dto.Change_LogDto;
import com.incture.dto.FilterDto;
import com.incture.dto.Packaging_tableDto;
import com.incture.dto.ResponseDto;
import com.incture.entity.Change_Log;
import com.incture.entity.Packaging_table;
import com.incture.repository.Packaging_table_Repository;

@Repository
@Transactional
public class Packaging_table_RepositoryImpl implements Packaging_table_Repository {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	public Packaging_table givePackagingTableDo(Packaging_tableDto packaging_tableDto) {
		Packaging_table packaging_table = new Packaging_table();
		Packaging_table_CK packaging_table_CK = new Packaging_table_CK();
		packaging_table_CK.setPartNum(packaging_tableDto.getPartNum());
		packaging_table_CK.setPlant(packaging_tableDto.getPlant());
		packaging_table_CK.setSupplierId(packaging_tableDto.getSupplierId());
		packaging_table.setPackaging_table_CK(packaging_table_CK);
		packaging_table.setCreatedBy(packaging_tableDto.getCreatedBy());
		packaging_table.setCreatedDate(packaging_tableDto.getCreatedDate());
		packaging_table.setHeight(packaging_tableDto.getHeight());
		packaging_table.setLength(packaging_tableDto.getLength());
		packaging_table.setMaxQtyPerKg(packaging_tableDto.getMaxQtyPerKg());
		packaging_table.setMixedPackage(packaging_tableDto.getMixedPackage());
		packaging_table.setMixedPallet(packaging_tableDto.getMixedPallet());
		packaging_table.setPackagingMaterialId(packaging_tableDto.getPackagingMaterialId());
		packaging_table.setPalletPackagingMaterial(packaging_tableDto.getPalletPackagingMaterial());
		packaging_table.setPartDesc(packaging_tableDto.getPartDesc());
		packaging_table.setPkdWildCard(packaging_tableDto.getPkdWildCard());
		packaging_table.setSecPkgMat(packaging_tableDto.getSecPkgMat());
		packaging_table.setShipsOnPallet(packaging_tableDto.getShipsOnPallet());
		packaging_table.setStatus(packaging_tableDto.getStatus());
		packaging_table.setUpdatedHeight(packaging_tableDto.getUpdatedHeight());
		packaging_table.setUpdatedLength(packaging_tableDto.getUpdatedLength());
		packaging_table.setUpdatedMaxQtyPerKg(packaging_tableDto.getUpdatedMaxQtyPerKg());
		packaging_table.setUpdatedMixedPackage(packaging_tableDto.getUpdatedMixedPackage());
		packaging_table.setUpdatedMixedPallet(packaging_tableDto.getUpdatedMixedPallet());
		packaging_table.setUpdatedPackagingMaterial(packaging_tableDto.getUpdatedPackagingMaterial());
		packaging_table.setUpdatedPalletPackagingMaterial(packaging_tableDto.getUpdatedPalletPackagingMaterial());
		packaging_table.setUpdatedSecPkgMat(packaging_tableDto.getUpdatedSecPkgMat());
		packaging_table.setUpdatedShipsOnPallet(packaging_tableDto.getUpdatedShipsOnPallet());
		packaging_table.setUpdatedWeight(packaging_tableDto.getUpdatedWeight());
		packaging_table.setUpdatedWidth(packaging_tableDto.getUpdatedWidth());
		packaging_table.setUpdatedBy(packaging_tableDto.getUpdatedBy());
		packaging_table.setUpdatedDate(packaging_tableDto.getUpdatedDate());
		packaging_table.setWeight(packaging_tableDto.getWeight());
		packaging_table.setWidth(packaging_tableDto.getWidth());
		packaging_table.setActions(packaging_tableDto.getActions());

		return packaging_table;
	}

	public Packaging_tableDto givePackagingTableDto(Packaging_table packaging_table) {
		Packaging_tableDto packaging_tableDto = new Packaging_tableDto();
		Packaging_table_CK packaging_table_CK = packaging_table.getPackaging_table_CK();
		packaging_tableDto.setPartNum(packaging_table_CK.getPartNum());
		packaging_tableDto.setPlant(packaging_table_CK.getPlant());
		packaging_tableDto.setSupplierId(packaging_table_CK.getSupplierId());
		packaging_tableDto.setCreatedBy(packaging_table.getCreatedBy());
		packaging_tableDto.setCreatedDate(packaging_table.getCreatedDate());
		packaging_tableDto.setHeight(packaging_table.getHeight());
		packaging_tableDto.setLength(packaging_table.getLength());
		packaging_tableDto.setMaxQtyPerKg(packaging_table.getMaxQtyPerKg());
		packaging_tableDto.setMixedPackage(packaging_table.getMixedPackage());
		packaging_tableDto.setMixedPallet(packaging_table.getMixedPallet());
		packaging_tableDto.setPackagingMaterialId(packaging_table.getPackagingMaterialId());
		packaging_tableDto.setPalletPackagingMaterial(packaging_table.getPalletPackagingMaterial());
		packaging_tableDto.setPartDesc(packaging_table.getPartDesc());
		packaging_tableDto.setPkdWildCard(packaging_table.getPkdWildCard());
		packaging_tableDto.setSecPkgMat(packaging_table.getSecPkgMat());
		packaging_tableDto.setShipsOnPallet(packaging_table.getShipsOnPallet());
		packaging_tableDto.setStatus(packaging_table.getStatus());
		packaging_tableDto.setUpdatedHeight(packaging_table.getUpdatedHeight());
		packaging_tableDto.setUpdatedLength(packaging_table.getUpdatedLength());
		packaging_tableDto.setUpdatedMaxQtyPerKg(packaging_table.getUpdatedMaxQtyPerKg());
		packaging_tableDto.setUpdatedMixedPackage(packaging_table.getUpdatedMixedPackage());
		packaging_tableDto.setUpdatedMixedPallet(packaging_table.getUpdatedMixedPallet());
		packaging_tableDto.setUpdatedPackagingMaterial(packaging_table.getUpdatedPackagingMaterial());
		packaging_tableDto.setUpdatedPalletPackagingMaterial(packaging_table.getUpdatedPalletPackagingMaterial());
		packaging_tableDto.setUpdatedSecPkgMat(packaging_table.getUpdatedSecPkgMat());
		packaging_tableDto.setUpdatedShipsOnPallet(packaging_table.getUpdatedShipsOnPallet());
		packaging_tableDto.setUpdatedWeight(packaging_table.getUpdatedWeight());
		packaging_tableDto.setUpdatedWidth(packaging_table.getUpdatedWidth());
		packaging_tableDto.setUpdatedBy(packaging_table.getUpdatedBy());
		packaging_tableDto.setUpdatedDate(packaging_table.getUpdatedDate());
		packaging_tableDto.setWeight(packaging_table.getWeight());
		packaging_tableDto.setWidth(packaging_table.getWidth());
		packaging_tableDto.setActions(packaging_table.getActions());

		return packaging_tableDto;
	}

	public List<Packaging_tableDto> filter(FilterDto filterDto) {
		Packaging_tableDto packaging_tableDto = new Packaging_tableDto();
		Session session = sessionFactory.getCurrentSession();
		Filter partNumFilter = null;
		if (filterDto.getPartNum() != null && filterDto.getPartNum() != "") {
			partNumFilter = session.enableFilter("partNumFilter");
			partNumFilter.setParameter("partNum", filterDto.getPartNum());
		}

		Filter plantFilter = null;
		if (filterDto.getPlant() != null && filterDto.getPlant() != "") {
			plantFilter = session.enableFilter("plantFilter");
			plantFilter.setParameter("plant", filterDto.getPlant());
		}

		Filter supplierIdFilter = null;
		if (filterDto.getSupplierId() != null && filterDto.getSupplierId() != "") {
			supplierIdFilter = session.enableFilter("supplierIdFilter");
			supplierIdFilter.setParameter("supplierId", filterDto.getSupplierId());
		}
		
		String hql = "from Packaging_table";
		Query query = session.createQuery(hql);
		int pageSize = 5;
		int pageNo = Integer.parseInt(filterDto.getPageNo());
		int startIndex = pageSize * (pageNo - 1);
		int count = 5;
		if (filterDto.getCount() != null)
			if (!(Integer.parseInt(filterDto.getCount()) > count))
				count = Integer.parseInt(filterDto.getCount());
		List<Packaging_table> data = new ArrayList<Packaging_table>();
		try {
			data = query.setFirstResult(count * (pageNo - 1)).setMaxResults(count).getResultList(); // setMaxResults(count).
		} catch (Exception e) {
			System.out.println(e);
		}
		List<Packaging_tableDto> dataDto = new ArrayList<Packaging_tableDto>();
		for (Packaging_table item : data) {
			dataDto.add(givePackagingTableDto(item));
		}
		return dataDto;
	}

	public ResponseDto insert(Packaging_tableDto packaging_tableDto) {
		Packaging_table packaging_table = givePackagingTableDo(packaging_tableDto);
		ResponseDto responseDto = new ResponseDto();
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(packaging_table);
			responseDto.setMessage("Successfully Inserted");
			responseDto.setStatusCode("200");
			responseDto.setStatus("Successful");
		} catch (Exception e) {
			responseDto.setMessage("Some Error Occurred");
			responseDto.setStatusCode("500");
			responseDto.setStatus("Failed");
		}
		return responseDto;
	}

	public ResponseDto batchInsertTest(List<Packaging_tableDto> packaging_tableDtoList) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			for (int i = 0; i < packaging_tableDtoList.size(); i++) {
				session.saveOrUpdate(givePackagingTableDo(packaging_tableDtoList.get(i)));
				if (i % 5 == 0) {
					session.flush();
					session.clear();
				}
			}
			session.flush();
			session.clear();
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseDto("200", "Successfully Inserted", "Successful");
	}

	public List<Change_LogDto> getFlag0FromChangeLogTable() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public Change_LogDto giveChange_LogDto(Change_Log change_Log){
//		Change
//	}
	
//	public List<Change_LogDto> getFlag0FromChangeLogTable(){
//		Change_LogDto change_LogDto = new Change_LogDto();
//		change_LogDto.setSupplierId("This is working");
//		Session session = sessionFactory.getCurrentSession();
//		String zero = "00";
//		String hql = "from Change_Log where FLAG =: zero";
//		Query query = session.createQuery(hql);
//		query.setParameter("zero",zero);
//		List<Change_Log> change_LogList = query.getResultList();
//		List<Change_LogDto> change_LogDtoList = new ArrayList<Change_LogDto>();
//		for(Change_Log change_Log : change_LogList){
//			change_LogDtoList.add(giveChange_LogDto(change_Log));
//		}
//		return change_LogDtoList;
//	}
	
}