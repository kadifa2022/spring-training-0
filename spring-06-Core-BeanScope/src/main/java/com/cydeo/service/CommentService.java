package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//autowiring is done through constructors

@Component
//@Scope("prototype")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentService {//interface is use because of loose coupling -implementation can change through abstract
    private final CommentRepository commentRepository;//dev.put final because  if of reminding to put constructors because of autowiring
    private final CommentNotificationProxy commentNotificationProxy;

    //CONSTRUCTOR USED INSTEAD OF @Autowiring                        //default bin name
    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }





    public void publishComment(Comment comment){
        //save in data Base
        commentRepository.storeComment(comment);
        //send email
        commentNotificationProxy.sendComment(comment);

    }
}
