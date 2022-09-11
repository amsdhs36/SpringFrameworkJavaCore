package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        @SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("Spring.xml");
        Student s=ac.getBean(Student.class);
        StudentDAO dao=ac.getBean(StudentDAO.class);
        int row=dao.insert(s);
        if(row>0) {
        	System.out.println("insertion is done");
        }
        else {
        	System.out.println("insertion failed");
        	
        }
        
    }
}
