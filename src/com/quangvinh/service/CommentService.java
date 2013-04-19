package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.ICommentDAO;
import com.quangvinh.model.Comment;

@Service
public class CommentService implements ICommentService{

	@Autowired
	private ICommentDAO commentDao;
	
	@Override
	@Transactional
	public void saveComment(Comment comment) {
		commentDao.saveComment(comment);
		
	}

	@Override
	@Transactional
	public void updateComment(Comment comment) {
		
		commentDao.updateComment(comment);
	}

	@Override
	@Transactional
	public void deleteComment(int id) {
		commentDao.deleteComment(id);			
	}

	@Override
	@Transactional
	public List<Comment> getComment() {
	
		return commentDao.getComment();
	}

	@Override
	@Transactional
	public Comment findCommentID(int id) {
		
		return commentDao.findCommentID(id);
	}

	@Override
	@Transactional
	public List<Comment> getListCommentTheoMaVanBan(int mavanban) {
		
		return commentDao.getListCommentTheoMaVanBan(mavanban);
	}

}
