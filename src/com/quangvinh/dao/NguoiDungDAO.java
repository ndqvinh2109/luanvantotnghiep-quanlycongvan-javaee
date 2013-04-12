package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.NguoiDung;
import com.quangvinh.model.Roles;

@Repository
public class NguoiDungDAO implements INguoiDungDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Create a new NguoiDung on the database
	 * @param NguoiDung
	 * @return NguoiDung added
	 */
	@Override
	public void saveNguoiDung(NguoiDung nguoiDung) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(nguoiDung);
		
	}
	/**
	 * Delete a NguoiDung with id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteNguoiDung(int id) {
		NguoiDung nguoiDung = (NguoiDung) sessionFactory.getCurrentSession().load(NguoiDung.class,id);
		if(nguoiDung != null){
			sessionFactory.getCurrentSession().delete(nguoiDung);
		}
		
	}
	/**
	 * Update NguoiDung on the database
	 * @param NguoiDung
	 * @return NguoiDung updated in DB
	 * 
	 */
	@Override
	public void updateNguoiDung(NguoiDung nguoiDung) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(nguoiDung);
	}
	/**
	 * Get List of NguoiDung from database
	 * @return list of all NguoiDung
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NguoiDung> getNguoiDung() {
		
		Session session = sessionFactory.getCurrentSession();
		List<NguoiDung> list = session.createQuery("from NguoiDung").list();
		return list;
	}
	/**
	 * Get object NguoiDung with id passed as parameter
	 */
	@Override
	public NguoiDung findNguoiDungID(int id) {
		Hibernate.initialize(getNguoiDung());
		NguoiDung nguoiDung = (NguoiDung) sessionFactory.getCurrentSession().load(NguoiDung.class,id);
		return nguoiDung;
	}

	@Override
	public NguoiDung getNguoiDungByUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from NguoiDung a where a.userName = :userName";
		Query query = session.createQuery(hql);
		query.setString("userName", userName);
		NguoiDung nguoidung = (NguoiDung)query.uniqueResult();
		return nguoidung;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> getRolesByUserName(String userName) {
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "select a from Roles a inner join a.nguoidung b where a.nguoidung.userName = :userName";
		Query query = session.createQuery(hql);
		query.setString("userName", userName);
		List<Roles> roles = query.list();
		return roles;
		
		
	}

	@Override
	public int getMaNguoiDungTheoUsername(String userName) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select a.maNguoiDung from NguoiDung a where a.userName = :userName";
		Query query = session.createQuery(hql);
		query.setString("userName", userName);
		int manguoidung = (int)query.uniqueResult();
		return manguoidung;
	}

	@Override
	public int getMaDonViTheoMaNguoiDung(int manguoidung) {
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "select a.donvi.maDonVi from NguoiDung a where a.maNguoiDung = :manguoidung";
		Query query = session.createQuery(hql);
		query.setInteger("manguoidung", manguoidung);
		int madonvi = (int)query.uniqueResult();
		return madonvi;
	}

	@Override
	public String getTenNguoiDungTheoUsername(String userName) {
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "select a.tenNguoiDung from NguoiDung a where a.userName = :userName";
		Query query = session.createQuery(hql);
		query.setString("userName", userName);
		String tennguoidung = (String)query.uniqueResult();
		return tennguoidung;
	}

}
