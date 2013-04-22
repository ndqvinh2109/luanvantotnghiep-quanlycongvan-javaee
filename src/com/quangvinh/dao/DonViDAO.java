package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.quangvinh.model.DonVi;
@Repository
public class DonViDAO implements IDonViDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Create a new DonVi on the database
	 * @param DonVi
	 * @return DonVi added
	 */
	@Override
	public DonVi saveDonVi(DonVi donVi) {
		
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(donVi);
		return donVi;
	}
	/**
	 * Delete a DonVi with id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteDonVi(int id) {
		DonVi donVi = (DonVi) sessionFactory.getCurrentSession().load(DonVi.class,id);
		if(donVi != null){
			sessionFactory.getCurrentSession().delete(donVi);
			
		}
		
	}
	/**
	 * Update DonVi on the database
	 * @param DonVi
	 * @return DonVi updated in DB
	 * 
	 */
	@Override
	public DonVi updateDonVi(DonVi donVi) {
		
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(donVi);
		return donVi;
	}
	/**
	 * Get List of DonVi from database
	 * @return list of all DonVi
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DonVi> getDonVi() {
		
		Session session = sessionFactory.getCurrentSession();
		List<DonVi> list = session.createQuery("from DonVi").list();
		return list;
	}
	/**
	 * Get object DonVi with id passed as parameter
	 */
	@Override
	public DonVi findDonViID(int id) {
		Hibernate.initialize(getDonVi());
		DonVi donVi = (DonVi) sessionFactory.getCurrentSession().load(DonVi.class,id);
		return donVi;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DonVi> getDonViDocLap(int val) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from DonVi a where a.kieuDonVi = :val";
		Query query = session.createQuery(hql);
		query.setInteger("val",val);
		List<DonVi> dv = query.list();
		return dv;
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<DonVi> getDonViTheoMaDonViPhuThuoc(int madonvi) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(DonVi.class,"donviAlias")
				.add(Restrictions.ne("donviAlias.maDonVi", madonvi))
				.add(Restrictions.eq("donviAlias.donvi.maDonVi", madonvi));
		List<DonVi> list = cr.list();
		return list;
	}

}
