package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.RandomConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class ComputerTest {
    public static  void main(String[] args) {

        System.out.println("Creating Container");
         //crating container by using Application Context           //put bean in container--can be added more than one class
        ApplicationContext container=new AnnotationConfigApplicationContext(ComputerConfig.class, RandomConfig.class);

        //creating container by using beanFactory
         BeanFactory context=new AnnotationConfigApplicationContext();

       //Monitor theMonitor = container.getBean(Monitor.class)
        System.out.println("Retrieving the bean");

        SonyMonitor sony=container.getBean(SonyMonitor.class);
        DellCase dell = container.getBean(DellCase.class);
        AsusMotherboard asus = container.getBean(AsusMotherboard.class);


        PC myPc = new PC(dell,sony,asus);
        myPc.powerUp();
        dell.pressPowerButton();

        System.out.println("---------------------------Multiple Objects---------------------" );

      //  Monitor theMonitor2 = container.getBean("monitorSony", Monitor.class);//default
       // Monitor theMonitor3 = container.getBean("sony", Monitor.class);//costume
       // Monitor theMonitor4 = container.getBean( Monitor.class);//@Primary you don"t need to put any nname

       // PC myPc4= new PC(theCase,theMonitor,theMotherboard);


    }
}
