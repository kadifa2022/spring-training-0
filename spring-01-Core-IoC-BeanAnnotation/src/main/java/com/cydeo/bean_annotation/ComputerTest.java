package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.RandomConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class ComputerTest {
    public static  void main(String[] args) {


         //crating container by using Application Context           //put bean in container--can be added more than one class
        ApplicationContext container=new AnnotationConfigApplicationContext(ComputerConfig.class, RandomConfig.class);
        //creating container by using beanFactory

        BeanFactory context=new AnnotationConfigApplicationContext();

       //Monitor theMonitor = container.getBean(Monitor.class)

        SonyMonitor theMonitor=container.getBean(SonyMonitor.class);
        Case theCase=container.getBean(Case.class);
        Motherboard myMotherboard=container.getBean(Motherboard.class);


        PC myPc = new PC(theCase,theMonitor,myMotherboard);
        myPc.powerUp();





    }
}
