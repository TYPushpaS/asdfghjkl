package com.tyss.talenthunt.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.tyss.talenthunt.dto.AddRequirement;

@Repository
public class AddRequirementDaoImpl implements AddRequirementDaoInterface {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addRequirement(AddRequirement requirement) {

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(requirement);
			transaction.commit();
			return true;
		} catch (Exception e) {
			manager.close();
			e.printStackTrace();
		}
		return false;
	}

}
