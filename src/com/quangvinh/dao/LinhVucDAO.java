package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.LinhVuc;
@Repository
public class LinhVucDAO implements ILinhVucDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Create a new LinhVuc on the database
	 * @param LinhVuc
	 * @return LinhVuc added
	 */
	@Override
	public LinhVuc saveLinhVuc(LinhVuc linhvuc) {
		
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(linhvuc);
		return linhvuc;
	}
	/**
	 * Delete a LinhVuc with id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteLinhVuc(int id) {
		LinhVuc linhvuc = (LinhVuc) sessionFactory.getCurrentSession().load(LinhVuc.class,id);
		if(linhvuc != null){
			sessionFactory.getCurrentSession().delete(linhvuc);
			
		}
		
	}
	/**
	 * Update LinhVuc on the database
	 * @param LinhVuc
	 * @return LinhVuc updated in DB
	 * 
	 */
	@Override
	public LinhVuc updateLinhVuc(LinhVuc linhvuc) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(linhvuc);
		return linhvuc;
		
	}
	/**
	 * Get List of LinhVuc from database
	 * @return list of all LinhVuc
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LinhVuc> getLinhVuc() {
		Session session = sessionFactory.getCurrentSession();
		List<LinhVuc> list = session.createQuery("from LinhVuc").list();
		return list;
		
	}

	@Override
	public LinhVuc findLinhVucID(int id) {
		LinhVuc linhvuc = (LinhVuc) sessionFactory.getCurrentSession().load(LinhVuc.class,id);
		return linhvuc;
	}

}
