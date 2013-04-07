package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.IMessageDAO;
import com.quangvinh.model.Message;

@Service
public class MessageService implements IMessageService{
	@Autowired
	private IMessageDAO messageDao;
	
	@Override
	@Transactional
	public Message saveMessage(Message message) {
		
		return messageDao.saveMessage(message);
	}

	@Override
	@Transactional
	public void deleteMessage(int id) {
		messageDao.deleteMessage(id);
		
	}

	@Override
	@Transactional
	public Message updateMessage(Message message) {
	
		return messageDao.updateMessage(message);
	}

	@Override
	@Transactional
	public List<Message> getMessages() {
		
		return messageDao.getMessages();
	}

	@Override
	@Transactional
	public Message findMessageID(int id) {
	
		return messageDao.findMessageID(id);
	}

	@Override
	@Transactional
	public List<Message> getMessagesReadYet(boolean isRead,int manguoidung) {
		
		return messageDao.getMessagesReadYet(isRead,manguoidung);
	}

}
