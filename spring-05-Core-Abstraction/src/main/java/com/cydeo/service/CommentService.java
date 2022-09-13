package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import com.cydeo.repository.DBCommentRepository;

public class CommentService {//interface is use because of loose coupling -implementation can change through abstract
    private CommentRepository commentRepository;
    private CommentNotificationProxy commentNotificationProxy;



    public void publishComment(Comment comment){
        //save in data Base
        commentRepository.storeComment(comment);
        //send email
        commentNotificationProxy.sendComment(comment);

    }
}
