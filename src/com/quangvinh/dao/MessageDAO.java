package com.quangvinh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quangvinh.model.Message;

@Repository
public class MessageDAO implements IMessageDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Message saveMessage(Message message) {
		
		Session sesson = sessionFactory.getCurrentSession();
		sesson.save(message);
		return message;
	}

	@Override
	public void deleteMessage(int id) {
		Message message = (Message) sessionFactory.getCurrentSession().load(Message.class,id);
		if(message != null){
			sessionFactory.getCurrentSession().delete(message);
			
		}
		
	}

	@Override
	public Message updateMessage(Message message) {
	
		Session sesson = sessionFactory.getCurrentSession();
		sesson.update(message);
		return message;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getMessages() {
	
		Session session = sessionFactory.getCurrentSession();
		List<Message> list = session.createQuery("from Message").list();
		return list;
	}

	@Override
	public Message findMessageID(int id) {
		
		Message message = (Message) sessionFactory.getCurrentSession().load(Message.class,id);
		return message;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getMessagesReadYet(boolean isRead,int manguoidung) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Message a where a.isRead = :isRead and a.nguoidung.maNguoiDung = :manguoidung";
		Query query = session.createQuery(hql);
		query.setBoolean("isRead",isRead);
		query.setInteger("manguoidung", manguoidung);
		List<Message> list = query.list();
		return list;
	}

}
