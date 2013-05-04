package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.VanBanDi_DonVi;

@Repository
public class VanBanDi_DonViDAO implements IVanBanDi_DonViDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
		
	@Override
	public void saveVanBanDi_DonVi(VanBanDi_DonVi vanbandi_donvi) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(vanbandi_donvi);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkBanHanhYet(int mavanban) {
		Session sesson = sessionFactory.getCurrentSession();
		String hql = "from VanBanDi_DonVi a where a.vanbandi.maVanBan = :mavanban";
		Query query = sesson.createQuery(hql);
		query.setInteger("mavanban",mavanban);
		List<VanBanDi_DonVi> vbd_dv = query.list();
		if(vbd_dv.size()==0){
			
			return true;
			
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VanBanDi_DonVi> getListVBDVDaBH(int mavanban) {
		Session sesson = sessionFactory.getCurrentSession();
		List<VanBanDi_DonVi> list = sesson.createCriteria(VanBanDi_DonVi.class,"a")
				.add(Restrictions.eq("a.vanbandi.maVanBan", mavanban)).list();
		return list;
	}
	

}
