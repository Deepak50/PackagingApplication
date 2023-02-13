package com.incture.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import com.incture.repositoryImpl.S4_Packaging_RepositoryImpl;

//Related to AutoGeneration
@Entity
@Table(name = "AutoGen")
public class AutoGen {

	@Id
	// x@GenericGenerator(name = "UseExistingIdOtherwiseGenerateUsingIdentity",
	// strategy =
	// "com.incture.entity.UseExistingIdOtherwiseGenerateUsingIdentity")
	// @GeneratedValue(generator =
	// "UseExistingIdOtherwiseGenerateUsingIdentity")

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = true)
	protected Integer id;

	@Column
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AutoGen [id=" + id + ", name=" + name + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	class UseExistingIdOtherwiseGenerateUsingIdentity extends IdentityGenerator{
		@Override
		public Serializable generate(SharedSessionContractImplementor session, Object object)
				throws HibernateException {

			Serializable id = session.getEntityPersister(null, object).getClassMetadata().getIdentifier(object,
					session);
			// Integer idd = new Integer(mr.getId());
			// Integer idd = new Integer(-1);
			// if(S4_Packaging_RepositoryImpl.idd != null){
			// idd = new Integer(S4_Packaging_RepositoryImpl.idd);
			// System.out.println("The id inside generate : "+idd);
			// }
			//// System.out.println("This is id :"+idd);
			// System.out.println("obj : "+object);
			//
			//// return idd != -1 ? idd : super.generate(session, object);
			// System.out.println(super.generate(session, object));

			// Serializable id = session.getEntityPersister(null,
			// object).getClassMetadata().getIdentifier(object, session);
			// Integer idd = new Integer(mr.getId());

			// working code
			Integer idd = new Integer(-1);
			if (S4_Packaging_RepositoryImpl.idd != null) {
				idd = S4_Packaging_RepositoryImpl.idd;
				System.out.println("The id inside generate class : " + idd);
			}
			if (S4_Packaging_RepositoryImpl.idd == null) {
				System.out.println("The id inside generate class : " + idd);
			}

			System.out.println("obj : " + object);
			System.out.println("THe id extracted is : " + id);
			return idd != -1 ? idd : super.generate(session, object);

			// new code
			// Integer idd = new Integer(-1);
			// if(S4_Packaging_RepositoryImpl.idd != null){
			// idd = S4_Packaging_RepositoryImpl.idd;
			// System.out.println("The id inside generate class : "+idd);
			// }
			// if(S4_Packaging_RepositoryImpl.idd == null){
			// System.out.println("The id inside generate class : "+idd);
			// }

			// System.out.println("obj : "+object);
			//
			// return idd != -1 ? idd : super.generate(session, object);

		}
	}

}
