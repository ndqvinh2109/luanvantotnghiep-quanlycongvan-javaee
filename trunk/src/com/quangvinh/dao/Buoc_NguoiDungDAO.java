package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.Buoc_NguoiDung;

@Repository
public class Buoc_NguoiDungDAO implements IBuoc_NguoiDungDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveBuocNguoiDung(Buoc_NguoiDung buocnd) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(buocnd);
		
	}

	@Override
	public void deleteBuocNguoiDung(int mabuocnd) {
		Buoc_NguoiDung buocnd = (Buoc_NguoiDung) sessionFactory.getCurrentSession().load(Buoc_NguoiDung.class,mabuocnd);
		if(buocnd != null){
			sessionFactory.getCurrentSession().delete(buocnd);
		}
		
	}

	@Override
	public void updateBuocNguoiDung(Buoc_NguoiDung buocnd) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(buocnd);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Buoc_NguoiDung> getBuocNguoiDung() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Buoc_NguoiDung> list = session.createQuery("from Buoc_NguoiDung").list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Buoc_NguoiDung> getBuocndQuyTrinh(int maquytrinh) {
		Session session = sessionFactory.getCurrentSession();
		List<Buoc_NguoiDung> list = session.createCriteria(Buoc_NguoiDung.class,"bnd")
				.add(Restrictions.eq("bnd.quytrinh.maQuyTrinh",maquytrinh))
				/*.add(Restrictions.eq("bnd.sothutu",sothutu))*/
				.list();
	return list;
	}
	
	
}
