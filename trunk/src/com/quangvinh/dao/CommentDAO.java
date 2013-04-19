package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.Comment;


@Repository
public class CommentDAO implements ICommentDAO{


	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void saveComment(Comment comment) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(comment);
		
		
	}

	@Override
	public void updateComment(Comment comment) {
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(comment);
		
	}

	@Override
	public void deleteComment(int id) {
		Comment comment = (Comment) sessionFactory.getCurrentSession().load(Comment.class,id);
		if(comment != null){
			sessionFactory.getCurrentSession().delete(comment);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getComment() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Comment> list = session.createQuery("from Comment").list();
		return list;
	}

	@Override
	public Comment findCommentID(int id) {
		
		Comment comment = (Comment) sessionFactory.getCurrentSession().load(Comment.class,id);
		return comment;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getListCommentTheoMaVanBan(int mavanban) {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Comment.class,"commentAlias")
					.add(Restrictions.eq("commentAlias.vanban.maVanBan",mavanban));
		
		List<Comment> list = cr.list();
		
		return list;
	}

}
