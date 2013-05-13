package com.quangvinh.dao;

import java.util.Date;
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
import com.quangvinh.model.VanBanDen;
@Repository
public class VanBanDenDAO implements IVanBanDenDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Create a new VanBanDen on the database
	 * @param VanBanDen
	 * @return VanBanDen added
	 */
	@Override
	public void saveVanBanDen(VanBanDen vanbanden) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(vanbanden);
		
	}
	/**
	 * Delete a VanBanDen with id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteVanBanDen(int id) {
		VanBanDen vanbanden = (VanBanDen) sessionFactory.getCurrentSession().load(VanBanDen.class, id);
		if(vanbanden != null){
			sessionFactory.getCurrentSession().delete(vanbanden);
			
		}
		
	}
	/**
	 * Update VanBanDen on the database
	 * @param VanBanDen
	 * @return VanBanDen updated in DB
	 * 
	 */
	@Override
	public void updateVanBanDen(VanBanDen vanbanden) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(vanbanden);
		
	}
	/**
	 * Get List of contacts from database
	 * @return list of all VanBan
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<VanBanDen> getVanBanDen() {
		
		Session session = sessionFactory.getCurrentSession();
		/*String hql = "from VanBanDen a where a.enabled = true";
		Query query = session.createQuery(hql);
		List<VanBanDen> list = query.list();*/
		List<VanBanDen> list = session.createQuery("from VanBanDen").list();
		return list;
	}

	@Override
	public int getMaxSoDen() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select max(s.SoDen) as maxSoDen from VanBanDen s";
		Query query = session.createQuery(hql);
		int sodenmax = 0;
		if(query.uniqueResult() != null)
		sodenmax = (int) query.uniqueResult();
		return sodenmax;
	}

	@Override
	public int findQuyTrinh(int mavanban) {
		Session session = sessionFactory.getCurrentSession();
		String hql="select q.maQuyTrinh from " +
				"VanBanDen v inner join v.loaivanban l " +
				"inner join l.quytrinh q " +
				"where v.maVanBan = :mavanban";
		Query query = session.createQuery(hql);
		query.setInteger("mavanban",mavanban);
		int ret = (int) query.uniqueResult();
		return ret;
		
	}

	@Override
	public VanBanDen findVanBanDenID(int id) {
		Hibernate.initialize(getVanBanDen());
		VanBanDen vanbanden = (VanBanDen) sessionFactory.getCurrentSession().load(VanBanDen.class,id);
		return vanbanden;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VanBanDen> getVanBanDenChuaTiepNhan() {
		
		Session session = sessionFactory.getCurrentSession();
		boolean val = false;
		String hql = "from VanBanDen a where a.enabled = :val";
		Query query = session.createQuery(hql);
		query.setBoolean("val", val);
		List<VanBanDen> list = query.list();
		
		return list;
	}

	@Override
	public DonVi findDonViTheoMaVanBan(int mavanban) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select a.donvi from VanBanDen a where a.maVanBan = :mavanban";
		Query query = session.createQuery(hql);
		query.setInteger("mavanban", mavanban);
		DonVi donvi = (DonVi) query.uniqueResult();
		return donvi;
	}

	@Override
	public int capNhatSoDenNgayDen(int mavanban, int soden, Date ngayden) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "update VanBanDen a set a.SoDen = :soden,a.NgayDen = :ngayden " +
						"where a.maVanBan = :mavanban";
		Query query = session.createQuery(hql);
		query.setParameter("mavanban", mavanban);
		query.setParameter("soden", soden);
		query.setParameter("ngayden", ngayden);
		int result = query.executeUpdate();
		return result;
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VanBanDen> timKiemNangCaoVanBanDen(String trichyeu,
			Date ngayden, int soden, String sokyhieu, int coquanbanhanh,
			int loaivanban, int linhvuc, int sohoso) {
		/*Session session = sessionFactory.getCurrentSession();
		String hql = "select a " +
				"from VanBanDen a inner join a.linhvuc b " +
				"inner join a.loaivanban c " +
				"inner join a.hosoluutru e " +
				"inner join a.donvi f " +
				"where a.trichYeu like :trichyeu and " +
				"a.NgayDen = :ngayden and " +
				"a.SoDen = :soden and  " +
				"a.soKyHieuVanBan like :sokyhieu and " +
				"f.maDonVi = :coquanbanhanh and " +
				"c.maLoaiVanBan = :loaivanban and " +
				"b.maLinhVuc = :linhvuc and " +
				"e.soHoSo = :sohoso";
		Query query = session.createQuery(hql);
		query.setString("trichyeu", "%" +trichyeu+ "%");
		query.setDate("ngayden", ngayden);
		query.setInteger("soden", soden);
		query.setString("sokyhieu", "%" +sokyhieu+ "%");
		query.setInteger("coquanbanhanh", coquanbanhanh);
		query.setInteger("loaivanban", loaivanban);
		query.setInteger("linhvuc", linhvuc);
		query.setInteger("sohoso", sohoso);
		List<VanBanDen> list = query.list();
		return list;*/
		
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(VanBanDen.class,"vanbandenAlias");
		List<VanBanDen> list = cr.createAlias("vanbandenAlias.linhvuc", "linhvucAlias")
			.createAlias("vanbandenAlias.loaivanban", "loaivanbanAlias")
			.createAlias("vanbandenAlias.hosoluutru", "hosoluutruAlias")
			.createAlias("vanbandenAlias.donvi", "donviAlias")
			.add(Restrictions.like("vanbandenAlias.trichYeu", "%"+trichyeu+"%"))
			.add(Restrictions.eq("vanbandenAlias.NgayDen", ngayden))
			.add(Restrictions.eq("vanbandenAlias.SoDen", soden))
			.add(Restrictions.like("vanbandenAlias.soKyHieuVanBan","%"+sokyhieu+"%"))
			.add(Restrictions.eq("donviAlias.maDonVi", coquanbanhanh))
			.add(Restrictions.eq("loaivanbanAlias.maLoaiVanBan", loaivanban))
			.add(Restrictions.eq("linhvucAlias.maLinhVuc", linhvuc))
			.add(Restrictions.eq("hosoluutruAlias.soHoSo", sohoso))
			.list();
			
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VanBanDen> timKiemCoBanVanBanDen(String textInput) {
		/*Session session = sessionFactory.getCurrentSession();
		String hql = "select a " +
				"from VanBanDen a " +
				"where a.tuKhoa like :textInput";
		Query query = session.createQuery(hql);
		query.setString("textInput", "%" +textInput+ "%");
		List<VanBanDen> list = query.list();
		return list;	*/	
		
		
		
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(VanBanDen.class)
			.add(Restrictions.like("tuKhoa", "%"+textInput+"%"));
		List<VanBanDen> list = cr.list();
		return list;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VanBanDen> getVanBanDenTheoTrangThai(int trangthai) {
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "from VanBanDen a where a.trangThaiXuLy = :trangthai";
		Query query = session.createQuery(hql);
		query.setInteger("trangthai", trangthai);
		List<VanBanDen> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VanBanDen> getVanBanDenPaging(int page) {
		int per_page = 10;
		int start = (page-1)*per_page;
		System.out.println("start: " + start);
		Session session = sessionFactory.getCurrentSession();
		/*String hql = "from VanBanDen";
		Query query = session.createQuery(hql);*/
		String hql = "from VanBanDen a where a.enabled = true";
		Query query = session.createQuery(hql);
		query.setFirstResult(start);
		query.setMaxResults(per_page);
		List<VanBanDen> list = query.list();
		return list;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkExistVanBanDen(String sokyhieuvanban) {
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "from VanbanDen a where a.soKyHieuVanBan = :sokyhieuvanban";
		Query query = session.createQuery(hql);
		query.setString("sokyhieuvanban", sokyhieuvanban);
		List<VanBanDen> list = query.list();
		if(list == null){
			return true;
			
		}
		return false;
	}

	

}
