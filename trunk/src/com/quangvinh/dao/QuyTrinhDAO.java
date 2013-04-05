package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.QuyTrinh;

@Repository
public class QuyTrinhDAO implements IQuyTrinhDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Create a new QuyTrinh on the database
	 * @param QuyTrinh
	 * @return QuyTrinh added
	 */
	@Override
	public void saveQuyTrinh(QuyTrinh quyTrinh) {
		
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(quyTrinh);
	
	}

	/**
	 * Delete a QuyTrinh with id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteQuyTrinh(int id) {
		QuyTrinh quyTrinh = (QuyTrinh) sessionFactory.getCurrentSession().load(QuyTrinh.class,id);
		if(quyTrinh != null){
			sessionFactory.getCurrentSession().delete(quyTrinh);
			
		}
		
	}
	/**
	 * Update QuyTrinh on the database
	 * @param QuyTrinh
	 * @return QuyTrinh updated in DB
	 * 
	 */
	@Override
	public void updateQuyTrinh(QuyTrinh quyTrinh) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(quyTrinh);
	}

	/**
	 * Get List of QuyTrinh from database
	 * @return list of all QuyTrinh
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<QuyTrinh> getQuyTrinh() {
		
		Session session = sessionFactory.getCurrentSession();
		List<QuyTrinh> list = session.createQuery("from QuyTrinh").list();
		return list;
	}
	
	/**
	 * Get object QuyTrinh with id passed as parameter
	 */
	@Override
	public QuyTrinh findQuyTrinhID(int id) {
		QuyTrinh quyTrinh = (QuyTrinh) sessionFactory.getCurrentSession().load(QuyTrinh.class,id);
		return quyTrinh;
		
	}

}
