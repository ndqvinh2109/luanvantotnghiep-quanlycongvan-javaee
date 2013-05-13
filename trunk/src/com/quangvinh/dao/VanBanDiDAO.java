package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.VanBanDi;
@Repository
public class VanBanDiDAO implements IVanBanDiDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void saveVanBanDi(VanBanDi vanbandi) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(vanbandi);
		
	}

	@Override
	public void deleteVanBanDi(int id) {
		VanBanDi vanbandi = (VanBanDi) sessionFactory.getCurrentSession().load(VanBanDi.class, id);
		if(vanbandi != null){
			sessionFactory.getCurrentSession().delete(vanbandi);
			
		}
		
	}

	@Override
	public void updateVanBanDi(VanBanDi vanbandi) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(vanbandi);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VanBanDi> getVanBanDi() {
		Session session = sessionFactory.getCurrentSession();
		List<VanBanDi> list = session.createQuery("from VanBanDi").list();
		return list;
	}


	@Override
	public int getMaxSoDi() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select max(s.SoDi) as maxSoDi from VanBanDi s";
		Query query = session.createQuery(hql);
		int sodimax = 0;
		if(query.uniqueResult() != null)
		sodimax = (int) query.uniqueResult();
		return sodimax;
	}

	

	@Override
	public VanBanDi findVanBanDiID(int id) {
		Hibernate.initialize(getVanBanDi());
		VanBanDi vanbandi = (VanBanDi) sessionFactory.getCurrentSession().load(VanBanDi.class,id);
		return vanbandi;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VanBanDi> getVanBanDiPaging(int page) {
		
		int per_page = 10;
		int start = (page-1)*per_page;
		Session session = sessionFactory.getCurrentSession();
		String hql = "from VanBanDi";
		Query query = session.createQuery(hql);
		query.setFirstResult(start);
		query.setMaxResults(per_page);
		List<VanBanDi> list = query.list();
		return list;
	}

	

}
