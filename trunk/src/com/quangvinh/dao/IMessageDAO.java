package com.quangvinh.dao;

import java.util.List;

import com.quangvinh.model.Message;
public interface IMessageDAO {
	Message saveMessage(Message message);
	void deleteMessage(int id);
	Message updateMessage(Message message);
	List<Message> getMessages();
	Message findMessageID(int id);
	List<Message> getMessagesReadYet(boolean isRead,int manguoidung);
	
}
