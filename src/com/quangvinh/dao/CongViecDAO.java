package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.CongViec;
@Repository
public class CongViecDAO implements ICongViecDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Create a new CongViec on the database
	 * @param CongViec
	 * @return CongViec added
	 */
	@Override
	public void saveCongViec(CongViec congviec) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(congviec);
		
	
	}
	
	/**
	 * Update CongViec on the database
	 * @param CongViec
	 * @return CongViec updated in DB
	 * 
	 */
	@Override
	public void updateCongViec(CongViec congviec) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(congviec);
		
	}
	
	/**
	 * Delete a CongViec with id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteCongViec(int id) {
		CongViec congviec = (CongViec) sessionFactory.getCurrentSession().load(CongViec.class,id);
		if(congviec != null){
			sessionFactory.getCurrentSession().delete(congviec);
		}
		
	}
	/**
	 * Get List of CongViec from database
	 * @return list of all CongViec
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CongViec> getCongViec() {
		
		Session session = sessionFactory.getCurrentSession();
		List<CongViec> list = session.createQuery("from CongViec").list();
		return list;
	}

	@Override
	public CongViec findCongViecID(int id) {
		
		CongViec congviec = (CongViec) sessionFactory.getCurrentSession().load(CongViec.class,id);
		return congviec;
	}

}
