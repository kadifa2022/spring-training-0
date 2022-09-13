package com.cydeo.proxy;

import com.cydeo.model.Comment;

public  class emailCommentNotificationProxy implements CommentNotificationProxy{

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Storing comment:" + comment.getText());

    }
}
