package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.Buoc;
@Repository
public class BuocDAO implements IBuocDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Create a new Buoc on the database
	 * @param Buoc
	 * @return Buoc added
	 */
	@Override
	public void saveBuoc(Buoc buoc) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(buoc);
		
	}
	/**
	 * Delete a Buoc with id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteBuoc(int id) {
		Buoc buoc = (Buoc) sessionFactory.getCurrentSession().load(Buoc.class,id);
		if(buoc != null){
			sessionFactory.getCurrentSession().delete(buoc);
		}
	}
	/**
	 * Update Buoc on the database
	 * @param Buoc
	 * @return Buoc updated in DB
	 * 
	 */
	@Override
	public void updateBuoc(Buoc buoc) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(buoc);
		
	}
	/**
	 * Get List of Buoc from database
	 * @return list of all Buoc
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Buoc> getBuoc() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Buoc> list = session.createQuery("from Buoc").list();
		return list;
	}
	
	
	/**
	 * Get max STT with maquytrinh passed as parameter
	 * @param Mã Quy Trình
	 */
	@Override
	public int getMaxId(int maquytrinh) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select max(b.pkQuyTrinh.soThuTu) as max from Buoc b where b.pkQuyTrinh.maQuyTrinh =:maQuyTrinh";
		Query query = session.createQuery(hql);
		query.setInteger("maQuyTrinh",maquytrinh);
		int ret = 0;
		if(query.uniqueResult() != null)
			ret = (int) query.uniqueResult();
		return ret;
	}
	
	/**
	 * Get object Buoc with id passed as parameter
	 * @param Ma quy trinh , So thu tu
	 */
	@Override
	public Buoc findBuocID(int maquytrinh, int sothutu) {
	
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Buoc b where b.pkQuyTrinh.soThuTu = :sothutu and b.pkQuyTrinh.maQuyTrinh = :maquytrinh";
		Query query = session.createQuery(hql);
		query.setInteger("sothutu",sothutu);
		query.setInteger("maquytrinh",maquytrinh);
		Buoc buoc = (Buoc)query.uniqueResult();
		return buoc;
	}

}
