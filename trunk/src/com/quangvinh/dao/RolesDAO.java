package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.Roles;

@Repository
public class RolesDAO implements IRolesDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Create a new Roles on the database
	 * @param Roles
	 * @return Roles added
	 */
	@Override
	public void saveRoles(Roles roles) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(roles);
		
	}

	/**
	 * Update Roles on the database
	 * @param Roles
	 * @return Roles updated in DB
	 * 
	 */
	@Override
	public void updateRoles(Roles roles) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(roles);
		
	}

	/**
	 * Delete a Roles with id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteRoles(int id) {
		Roles role = (Roles) sessionFactory.getCurrentSession().load(Roles.class,id);
		if(role != null){
			sessionFactory.getCurrentSession().delete(role);
		}
		
	}

	/**
	 * Get List of Roles from database
	 * @return list of all Roles
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> getRoles() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Roles> list = session.createQuery("from Roles").list();
		return list;
	}

	@Override
	public Roles findRoleID(int id) {
		
		Roles role = (Roles) sessionFactory.getCurrentSession().load(Roles.class,id);
		return role;
	}

}
