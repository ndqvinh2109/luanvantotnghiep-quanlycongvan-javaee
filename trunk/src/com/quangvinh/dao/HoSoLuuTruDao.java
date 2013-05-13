
package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.HoSoLuuTru;
@Repository
public class HoSoLuuTruDao implements IHoSoLuuTruDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Create a new Ho so luu tru on the database
	 * @param ho so luu tru
	 * @return ho so luu tru added
	 */
	@Override
	public HoSoLuuTru saveHoSoLuuTru(HoSoLuuTru hosoluutru) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(hosoluutru);
		return hosoluutru;
	}
	/**
	 * Update Ho so luu tru on the database
	 * @param Ho so luu tru
	 * @return Ho so luu tru updated in DB
	 * 
	 */
	@Override
	public HoSoLuuTru updateHoSoLuuTru(HoSoLuuTru hosoluutru) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(hosoluutru);
		return hosoluutru;
	}
	/**
	 * Delete a ho so luu tru with id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteHoSoLuuTru(int id) {
		HoSoLuuTru hosoluutru = (HoSoLuuTru) sessionFactory.getCurrentSession().load(HoSoLuuTru.class, id);
		if(hosoluutru != null){
			sessionFactory.getCurrentSession().delete(hosoluutru);
			
		}
		
	}
	/**
	 * Get List of hosoluutru from database
	 * @return list of all ho so luu tru
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoLuuTru> getHoSoLuuTru() {
		Session session = sessionFactory.getCurrentSession();
		List<HoSoLuuTru> list = session.createQuery("from HoSoLuuTru").list();
		return list;
	}

	@Override
	public HoSoLuuTru findHoSoLuuTruID(int id) {
		HoSoLuuTru hosoluutru = (HoSoLuuTru) sessionFactory.getCurrentSession().load(HoSoLuuTru.class, id);
		return hosoluutru;
	}

	@Override
	public HoSoLuuTru getChiTietHoSoLuuTru(int mavanban) {
		/*Session session = sessionFactory.getCurrentSession();
		String hql="select q.maQuyTrinh from " +
				"VanBanDen v inner join v.loaivanban l " +
				"inner join l.quytrinh q " +
				"where v.maVanBan = :mavanban";
		Query query = session.createQuery(hql);
		query.setInteger("mavanban",mavanban);
		int ret = (int) query.uniqueResult();
		return ret;*/
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "select a.hosoluutru from VanBanDen a where a.maVanBan = :mavanban";
		Query query = session.createQuery(hql);
		query.setInteger("mavanban",mavanban);
		HoSoLuuTru hosoluutru = (HoSoLuuTru) query.uniqueResult();
		return hosoluutru;
		
	}

}
