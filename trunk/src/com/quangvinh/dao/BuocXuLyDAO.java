package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.Buoc;
import com.quangvinh.model.BuocXuLyPheDuyetVanBan;

@Repository
public class BuocXuLyDAO implements IBuocXuLyDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Create a new BuocXuLy on the database
	 * @param BuocXuLy
	 * @return BuocXuLy added
	 */
	@Override
	public void saveBuocXuLy(BuocXuLyPheDuyetVanBan buocXuLyPheDuyetVanBan) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(buocXuLyPheDuyetVanBan);
	}
	/**
	 * Update BuocXuLy on the database
	 * @param BuocXuLy
	 * @return BuocXuLy updated in DB
	 * 
	 */
	@Override
	public void updateBuocXuLy(BuocXuLyPheDuyetVanBan buocXuLyPheDuyetVanBan) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(buocXuLyPheDuyetVanBan);
		
	}
	/**
	 * Delete a BuocXuLy with id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteBuocXuLy(int id) {
		BuocXuLyPheDuyetVanBan buocXuLyPheDuyetVanBan = (BuocXuLyPheDuyetVanBan) sessionFactory.getCurrentSession().load(BuocXuLyPheDuyetVanBan.class,id);
		if(buocXuLyPheDuyetVanBan != null){
			sessionFactory.getCurrentSession().delete(buocXuLyPheDuyetVanBan);
		}
		
	}
	/**
	 * Get List of BuocXuLy from database
	 * @return list of all BuocXuLy
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BuocXuLyPheDuyetVanBan> getBuocXuLyPheDuyetVanBans() {
	
		Session session = sessionFactory.getCurrentSession();
		List<BuocXuLyPheDuyetVanBan> list = session.createQuery("from BuocXuLyPheDuyetVanBan").list();
		return list;
	}
	/**
	 * Get List of BuocXuLy with parameter is Ma Quy Trinh
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Buoc> getBuocXuLyPheDuyetTrongQuyTrinh(int MaQuyTrinh) {
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Buoc a where a.pkQuyTrinh.maQuyTrinh = :maquytrinh";
		Query query = session.createQuery(hql);
		query.setInteger("maquytrinh",MaQuyTrinh);
		List<Buoc> bxl = query.list();
		return bxl;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BuocXuLyPheDuyetVanBan> getBuocXuLyTheoMaNguoiDung(int manguoidung) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select a from BuocXuLyPheDuyetVanBan a " +
				"inner join a.nguoidung b " +
				"where b.maNguoiDung = :manguoidung";
		Query query = session.createQuery(hql);
		query.setInteger("manguoidung",manguoidung);
		List<BuocXuLyPheDuyetVanBan> bxlpd = query.list();
		return bxlpd;
	}

	@Override
	public BuocXuLyPheDuyetVanBan getBuocXuLyTheoVbanBuoc(int mavanban,
			int buoc) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from BuocXuLyPheDuyetVanBan a " +
				"where a.vanban.maVanBan = :mavanban " +
				"and a.pkBuocXuLy.soThuTu = :buoc";
		Query query = session.createQuery(hql);
		query.setInteger("mavanban",mavanban);
		query.setInteger("buoc",buoc);
		BuocXuLyPheDuyetVanBan buocxuly = (BuocXuLyPheDuyetVanBan)query.uniqueResult();
		return buocxuly;
	}

	@Override
	public long countBuocXuLyTheoMaQuyTrinh(int maquytrinh) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) as countBuoc " +
				"from BuocXuLyPheDuyetVanBan a " +
				"where a.pkBuocXuLy.maQuyTrinh = :maquytrinh";
		Query query = session.createQuery(hql);
		query.setInteger("maquytrinh",maquytrinh);
		long countbuoc = 0;
		if(query.uniqueResult() != null)
		countbuoc = (long) query.uniqueResult();
		return countbuoc;
		
	}

	@Override
	public int updateNoiDungAndValueXuLy(int mavanban,int sothutu,String noidungxuly,boolean valueXuLy) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "update BuocXuLyPheDuyetVanBan a " +
				"set a.noiDungXLPD = :noidungxuly,a.valueXuLy = :valueXuLy " +
				"where a.pkBuocXuLy.soThuTu = :sothutu " +
				"and a.pkBuocXuLy.maVanBan = :mavanban";
		Query query = session.createQuery(hql);
		
		query.setParameter("mavanban", mavanban);
		query.setParameter("sothutu", sothutu);
		query.setParameter("noidungxuly", noidungxuly);
		query.setParameter("valueXuLy", valueXuLy);
		
		int result = query.executeUpdate();
		
		return result;
	}

	@Override
	public int updateNoiDungAndValueChuyen(int mavanban, int sothutu,
			boolean valueChuyen) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "update BuocXuLyPheDuyetVanBan a " +
				"set a.valueChuyen = :valueChuyen " +
				"where a.pkBuocXuLy.soThuTu = :sothutu " +
				"and a.pkBuocXuLy.maVanBan = :mavanban";
		Query query = session.createQuery(hql);
		
		query.setParameter("mavanban", mavanban);
		query.setParameter("sothutu", sothutu);
		query.setParameter("valueChuyen", valueChuyen);
		
		int result = query.executeUpdate();
		
		return result;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkExistVanBanTrongBuocXuLy(int mavanban) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from BuocXuLyPheDuyetVanBan a where a.pkBuocXuLy.maVanBan = :mavanban";
		Query query = session.createQuery(hql);
		query.setInteger("mavanban",mavanban);
		List<BuocXuLyPheDuyetVanBan> bxlpd = query.list();
		return (bxlpd.isEmpty());
	}

	@Override
	public long countBuocXuLyTheoMaNguoiDung(int manguoidung,
			boolean valuechuyen, boolean valuexuly) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from BuocXuLyPheDuyetVanBan a " +
				"where a.nguoidung.maNguoiDung = :manguoidung and " +
				"a.valueChuyen = :valuechuyen and " +
				"a.valueXuLy = :valuexuly";
		Query query = session.createQuery(hql);
		query.setInteger("manguoidung", manguoidung);
		query.setBoolean("valuechuyen", valuechuyen);
		query.setBoolean("valuexuly", valuexuly);
		long countbuoc = 0;
		if(query.uniqueResult() != null)
		countbuoc = (long) query.uniqueResult();
		return countbuoc;
		
	}

}
