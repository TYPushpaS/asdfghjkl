package com.tyss.talunthunt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.tyss.talunthunt.dto.ScheduleInterview;


@Repository
public class ScheduleInterviewDAOImpl implements ScheduleInterviewDAO{
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public ScheduleInterview scheduleInterview(ScheduleInterview si) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(si);
			transaction.commit();
			return si;
		} catch (Exception e) { 
			manager.close();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ScheduleInterview> getAllInterviews() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String jpql = "From ScheduleInterview";
		Query query = manager.createQuery(jpql);
		List<ScheduleInterview> req=(List<ScheduleInterview>) query.getResultList();
			return req;
	}

}
