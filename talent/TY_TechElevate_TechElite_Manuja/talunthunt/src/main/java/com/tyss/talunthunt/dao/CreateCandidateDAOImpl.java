package com.tyss.talunthunt.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.tyss.talunthunt.dto.CreateCandidate;

@Repository
public class CreateCandidateDAOImpl implements CreateCandidateDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public CreateCandidate createCandidates(CreateCandidate candidates) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(candidates);
			transaction.commit();
			return candidates;
		} catch (Exception e) {
			e.printStackTrace();
			manager.close();

			return null;
		}

	}
}
