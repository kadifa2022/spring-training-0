package com.cydeo.service;

import com.cydeo.config.AppConfigData;
import com.cydeo.config.DBConfigData;
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
    private final AppConfigData appConfigData;

    private final DBConfigData dbConfigData;


    //CONSTRUCTOR USED INSTEAD OF @Autowiring                        //templates bin name
    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy, AppConfigData appConfigData, DBConfigData dbConfigData) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        this.appConfigData = appConfigData;
        this.dbConfigData = dbConfigData;
    }





    public void publishComment(Comment comment){
        //save in data Base
        commentRepository.storeComment(comment);
        //send email
        commentNotificationProxy.sendComment(comment);


        }
    public void printConfigData(){
        System.out.println(appConfigData.getUserName());
        System.out.println(appConfigData.getPassword());
        System.out.println(appConfigData.getUrl());

    }
    public void printDbConfigData(){
        System.out.println(dbConfigData.getPassword());
        System.out.println(dbConfigData.getUsername());
        System.out.println(dbConfigData.getType());
    }
}
