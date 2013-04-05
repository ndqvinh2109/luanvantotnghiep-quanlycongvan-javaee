package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.CapDoBaoMat;

@Repository
public class CapDoBaoMatDAO implements ICapDoBaoMatDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Create a new CapDoBaoMat on the database
	 * @param capDoBaoMat
	 * @return CapDoBaoMat added
	 */
	@Override
	public CapDoBaoMat saveCapDoBaoMat(CapDoBaoMat capDoBaoMat) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(capDoBaoMat);
		return capDoBaoMat;
		
	}
	/**
	 * Delete a CapDoBaoMat with id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteCapDoBaoMat(int id) {
		CapDoBaoMat capDoBaoMat = (CapDoBaoMat) sessionFactory.getCurrentSession().load(CapDoBaoMat.class,id);
		if(capDoBaoMat != null){
			sessionFactory.getCurrentSession().delete(capDoBaoMat);
			
		}
		
	}
	/**
	 * Update CapDoBaoMat on the database
	 * @param capDoBaoMat
	 * @return CapDoBaoMat updated in DB
	 * 
	 */
	@Override
	public CapDoBaoMat updateCapDoBaoMat(CapDoBaoMat capDoBaoMat) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(capDoBaoMat);
		return capDoBaoMat;
	
	}
	/**
	 * Get List of CapDoBaoMat from database
	 * @return list of all CapDoBaoMat
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CapDoBaoMat> getCapDoBaoMat() {
		Session session = sessionFactory.getCurrentSession();
		List<CapDoBaoMat> list = session.createQuery("from CapDoBaoMat").list();
		return list;
				
	}

	@Override
	public CapDoBaoMat findCapDoBaoMatID(int id) {
		CapDoBaoMat capDoBaoMat = (CapDoBaoMat) sessionFactory.getCurrentSession().load(CapDoBaoMat.class,id);
		return capDoBaoMat;
	}

}
