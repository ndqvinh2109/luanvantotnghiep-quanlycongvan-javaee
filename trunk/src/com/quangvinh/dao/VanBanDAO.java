package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.VanBan;
@Repository
public class VanBanDAO implements IVanBanDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Create a new VanBan on the database
	 * @param VanBan
	 * @return VanBan added
	 */
	@Override
	public void saveVanBan(VanBan vanban) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(vanban);
		
	}
	/**
	 * Delete a VanBan with id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteVanBan(int id) {
		VanBan vanban = (VanBan) sessionFactory.getCurrentSession().load(VanBan.class, id);
		if(vanban != null){
			sessionFactory.getCurrentSession().delete(vanban);
			
		}
	}
	/**
	 * Update VanBan on the database
	 * @param VanBan
	 * @return VanBan updated in DB
	 * 
	 */
	@Override
	public void updateVanBan(VanBan vanban) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(vanban);
	}
	/**
	 * Get List of contacts from database
	 * @return list of all VanBan
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<VanBan> getVanBan() {
		Session session = sessionFactory.getCurrentSession();
		List<VanBan> list = session.createQuery("from VanBan").list();
		return list;
	}

	@Override
	public VanBan findVanBanID(int id) {
		VanBan vanban = (VanBan) sessionFactory.getCurrentSession().load(VanBan.class, id);
		Hibernate.initialize(vanban);
		return vanban;
	}

	@Override
	public int updateTrangThaiXuLy(int trangthai, int mavanban) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "update VanBan a set a.trangThaiXuLy = :trangthai where a.maVanBan = :mavanban";
		Query query = session.createQuery(hql);
		query.setParameter("trangthai", trangthai);
		query.setParameter("mavanban", mavanban);
		int result = query.executeUpdate();
		return result;
		
	}

	@Override
	public int getMaVanBanTheoSoKyHieu(String sovakyhieu) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select a.maVanBan from VanBan a where a.soKyHieuVanBan = :sovakyhieu";
		Query query = session.createQuery(hql);
		query.setString("sovakyhieu", sovakyhieu);
		int result = (int)query.uniqueResult();
		return result;
	}

	@Override
	public int capNhatBooleanTiepNhan(boolean var,int mavanban) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "update VanBan a " +
				"set a.enabled = :var " +
				"where a.maVanBan = :mavanban ";			
		Query query = session.createQuery(hql);
		query.setParameter("mavanban", mavanban);
		query.setParameter("var", var);
			
		int result = query.executeUpdate();
		
		return result;
	}

	@Override
	public int capNhatBooleanBanHanh(boolean var,int mavanban) {
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "update VanBan a " +
				"set a.isBanHanh = :var " +
				"where a.maVanBan = :mavanban ";			
		Query query = session.createQuery(hql);
		query.setParameter("mavanban", mavanban);
		query.setParameter("var", var);
			
		int result = query.executeUpdate();
		
		return result;
	}
		
	
}
