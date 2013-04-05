package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.LoaiVanBan;

@Repository
public class LoaiVanBanDAO implements ILoaiVanBanDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Create a new LoaiVanBan on the database
	 * @param LoaiVanBan
	 * @return LoaiVanBan added
	 */
	@Override
	public LoaiVanBan saveLoaiVanBan(LoaiVanBan loaivanban) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(loaivanban);
		return loaivanban;
	}
	/**
	 * Delete a LoaiVanBan with id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteLoaiVanBan(int id) {
		LoaiVanBan loaivanban = (LoaiVanBan) sessionFactory.getCurrentSession().load(LoaiVanBan.class,id);
		if(loaivanban != null){
			sessionFactory.getCurrentSession().delete(loaivanban);
			
		}
	}
	/**
	 * Update LoaiVanBan on the database
	 * @param LoaiVanBan
	 * @return LoaiVanBan updated in DB
	 * 
	 */
	@Override
	public LoaiVanBan updateLoaiVanBan(LoaiVanBan loaivanban) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(loaivanban);
		return loaivanban;
	}
	/**
	 * Get List of LoaiVanBan from database
	 * @return list of all LoaiVanBan
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LoaiVanBan> getLoaiVanBan() {
		
		Session session = sessionFactory.getCurrentSession();
		List<LoaiVanBan> list = session.createQuery("from LoaiVanBan").list();
		return list;
	}

	@Override
	public LoaiVanBan findLoaiVanBanID(int id) {
		LoaiVanBan loaivanban = (LoaiVanBan) sessionFactory.getCurrentSession().load(LoaiVanBan.class,id);
		return loaivanban;
	}

}
