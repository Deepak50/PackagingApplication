package com.incture.entity;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import com.incture.repository.S4_Packaging_Repository;
import com.incture.repositoryImpl.S4_Packaging_RepositoryImpl;

public class UseExistingIdOtherwiseGenerateUsingIdentity extends IdentityGenerator {

	
	@Autowired
	S4_Packaging_Repository mr;
	
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        
    	Serializable id = session.getEntityPersister(null, object).getClassMetadata().getIdentifier(object, session);
//    	Integer idd = new Integer(mr.getId()); 
//    	Integer idd = new Integer(-1);
//    	if(id != null)
//    		id = S4_Packaging_RepositoryImpl.idd;
//    	System.out.println("This is id :"+idd);
        System.out.println("obj : "+object);
        
    	return id != null ? id : super.generate(session, object);
//        System.out.println(super.generate(session, object));
    }
}
