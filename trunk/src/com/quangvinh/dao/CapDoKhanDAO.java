package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.CapDoKhan;
@Repository
public class CapDoKhanDAO implements ICapDoKhanDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Create a new CapDoKhan on the database
	 * @param capDoKhan
	 * @return CapDoKhan added
	 */
	@Override
	public CapDoKhan saveCapDoKhan(CapDoKhan capDoKhan) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(capDoKhan);
		return capDoKhan;
		
	}
	/**
	 * Delete a CapDoKhan with id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteCapDoKhan(int id) {
		CapDoKhan capDoKhan = (CapDoKhan) sessionFactory.getCurrentSession().load(CapDoKhan.class,id);
		if(capDoKhan != null){
			sessionFactory.getCurrentSession().delete(capDoKhan);
			
		}
		
	}
	/**
	 * Update CapDoKhan on the database
	 * @param capDoKhan
	 * @return CapDoKhan updated in DB
	 * 
	 */
	@Override
	public CapDoKhan updateCapDoKhan(CapDoKhan capDoKhan) {
		
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(capDoKhan);
		return capDoKhan;
	}
	/**
	 * Get List of CapDoKhan from database
	 * @return list of all CapDoKhan
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CapDoKhan> getCapDoKhan() {
		Session session = sessionFactory.getCurrentSession();
		List<CapDoKhan> list = session.createQuery("from CapDoKhan").list();
		return list;
		
	}

	@Override
	public CapDoKhan findCapDoKhanID(int id) {
		CapDoKhan capDoKhan = (CapDoKhan) sessionFactory
				.getCurrentSession()
				.load(CapDoKhan.class,id);
		return capDoKhan;
	}

}
