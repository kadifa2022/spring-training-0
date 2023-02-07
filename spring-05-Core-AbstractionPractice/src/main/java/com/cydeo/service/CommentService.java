package com.cydeo.service;

import com.cydeo.entity.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;


public class CommentService {

     private CommentRepository commentRepository; //we are  putting interfaces because of loosely couple
     private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment) {

        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);

    }
}
