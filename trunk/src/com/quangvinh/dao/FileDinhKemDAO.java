package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.FileDinhKem;

@Repository
public class FileDinhKemDAO implements IFileDinhKemDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Create a new FileDinhKem on the database
	 * @param FileDinhKem
	 * @return FileDinhKem added
	 */
	@Override
	public void addFileDinhKem(FileDinhKem fileDinhKem) {
		 Session session = sessionFactory.getCurrentSession();
		 session.save(fileDinhKem);
		
	}
	/**
	 * Get the list of all Files stored in FileDinhKem table and return list of FileDinhKem object
	 *	@return List FileDinhKem
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FileDinhKem> getFileDinhKem() {
		 Session session = sessionFactory.getCurrentSession();
		 List<FileDinhKem> list = session.createQuery("from FileDinhKem").list();
		 return list;
		
	}
	/**
	 * Return FileDinhKem for a given ID from database.
	 * Used in download functionality to download a stored File from database
	 * @param id
	 * @return FileDinhKem
	 */
	@Override
	public FileDinhKem get(int id) {
		Session session = sessionFactory.getCurrentSession();
        return (FileDinhKem)session.get(FileDinhKem.class, id);
		
	}
	/**
	 * Delete a FileDinhKem with specific ID from database
	 * @param id
	 */
	@Override
	public void deleteFileDinhKem(int id) {
		  Session session = sessionFactory.getCurrentSession();
	      FileDinhKem fileDinhKem = (FileDinhKem)session.get(FileDinhKem.class, id);
	   	  session.delete(fileDinhKem);
	}
	/**
	 * Get List FileDinhKem with specific Mã Văn Bản from database
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FileDinhKem> getFileDinhKemVanBan(int mavanban) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from FileDinhKem a where a.vanban.maVanBan = :maVanBan";
		Query query = session.createQuery(hql);
		query.setInteger("maVanBan",mavanban);
		List<FileDinhKem> list = query.list();
		return list;
	}

}
