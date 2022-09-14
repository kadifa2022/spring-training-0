package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;

//another Class/object implementation to interface and can be injected
@Component
@Qualifier("PUSH")//instead of @primary we will use @Qualifier

public class PushCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending push notification for comment:" + comment.getText());


    }
}
