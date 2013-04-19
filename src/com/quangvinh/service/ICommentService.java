package com.quangvinh.service;

import java.util.List;

import com.quangvinh.model.Comment;

public interface ICommentService {
	void saveComment(Comment comment);
	void updateComment (Comment comment);
	void deleteComment (int id);
	List<Comment> getComment();
	Comment findCommentID(int id);
	List<Comment> getListCommentTheoMaVanBan(int mavanban);
}
