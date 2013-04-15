package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.NguoiDung_Roles;

@Repository
public class NguoiDungRolesDAO implements INguoiDung_RolesDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void saveNguoiDungRoles(NguoiDung_Roles nguoiDungRoles) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(nguoiDungRoles);
		
	}

	@Override
	public void deleteNguoiDungRoles(int id) {
		NguoiDung_Roles nguoiDungRoles = (NguoiDung_Roles) sessionFactory.getCurrentSession().load(NguoiDung_Roles.class,id);
		if(nguoiDungRoles != null){
			sessionFactory.getCurrentSession().delete(nguoiDungRoles);
		}
		
	}

	@Override
	public void updateNguoiDungRoles(NguoiDung_Roles nguoiDungRoles) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(nguoiDungRoles);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NguoiDung_Roles> getNguoiDungRoles() {
		Session session = sessionFactory.getCurrentSession();
		List<NguoiDung_Roles> list = session.createQuery("from NguoiDung_Roles").list();
		return list;
	}

	@Override
	public NguoiDung_Roles findNguoiDungRolesID(int id) {
		NguoiDung_Roles nguoiDungRoles = (NguoiDung_Roles) sessionFactory.getCurrentSession().load(NguoiDung_Roles.class,id);
		return nguoiDungRoles;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NguoiDung_Roles> checkExistNguoiDungRoles(int manguoidung,
			int marole) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(NguoiDung_Roles.class,"nguoidungroleAlias");
		List<NguoiDung_Roles> list = cr
				.createAlias("nguoidungroleAlias.nguoidung", "nguoidungAlias")
				.createAlias("nguoidungroleAlias.roles", "rolesAlias")
				.add(Restrictions.eq("nguoidungAlias.maNguoiDung", manguoidung))
				.add(Restrictions.eq("rolesAlias.maRoles", marole)).list();
				
		return list;
		
	}

	@Override
	public void deleteNguoiDungRoles2(int manguoidung, int marole) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(NguoiDung_Roles.class,"nguoidungroleAlias");
		NguoiDung_Roles nguoidungrole = (NguoiDung_Roles) cr
				.createAlias("nguoidungroleAlias.nguoidung", "nguoidungAlias")
				.createAlias("nguoidungroleAlias.roles", "rolesAlias")
				.add(Restrictions.eq("nguoidungAlias.maNguoiDung", manguoidung))
				.add(Restrictions.eq("rolesAlias.maRoles", marole)).uniqueResult();
		
		session.delete(nguoidungrole);
	}

}
