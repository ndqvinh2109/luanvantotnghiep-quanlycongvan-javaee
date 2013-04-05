package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.LoaiVanBan;
import com.quangvinh.model.ViTriLuuTru;
@Repository
public class ViTriLuuTruDAO implements IViTriLuuTruDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Create a new ViTriLuuTru on the database
	 * @param vitriluutru
	 * @return ViTriLuuTru added
	 */
	@Override
	public ViTriLuuTru saveViTriLuuTru(ViTriLuuTru vitriluutru) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(vitriluutru);
		return vitriluutru;
		
	}
	/**
	 * Delete a ViTriLuuTru with id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteViTriLuuTru(int id) {
		ViTriLuuTru vitriluutru = (ViTriLuuTru) sessionFactory.getCurrentSession().load(LoaiVanBan.class,id);
		if(vitriluutru != null){
			sessionFactory.getCurrentSession().delete(vitriluutru);
			
		}
		
	}
	/**
	 * Update ViTriLuuTru on the database
	 * @param vitriluutru
	 * @return ViTriLuuTru updated in DB
	 * 
	 */
	@Override
	public ViTriLuuTru updateViTriLuuTru(ViTriLuuTru vitriluutru) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(vitriluutru);
		return vitriluutru;
		
	}
	/**
	 * Get List of ViTriLuuTru from database
	 * @return list of all ViTriLuuTru
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ViTriLuuTru> getViTriLuuTru() {
		
		Session session = sessionFactory.getCurrentSession();
		List<ViTriLuuTru> list = session.createQuery("from ViTriLuuTru").list();
		return list;
	}

	@Override
	public ViTriLuuTru findViTriLuuTruID(int id) {
		ViTriLuuTru vitriluutru = (ViTriLuuTru) sessionFactory.getCurrentSession().load(ViTriLuuTru.class,id);
		return vitriluutru;
	}

}
