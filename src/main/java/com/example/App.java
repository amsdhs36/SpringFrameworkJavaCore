package com.example;

import java.util.List;
import java.util.Scanner;

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
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
         Student s=ac.getBean(Student.class);
         StudentDAO dao=ac.getBean(StudentDAO.class);
         try (Scanner sc = new Scanner(System.in)) {
			System.out.println("enter the id value");
			s.setSid(sc.nextInt());
			System.out.println("enter the name");
			s.setSname(sc.next());
			System.out.println("enter the email");
			s.setSemail(sc.next());
			System.out.println("enter the phono");
			s.setPhono(sc.nextInt());
		}
         int row=dao.insert(s);
         if(row>0) {
         	System.out.println("insertion is done");
         }
         else {
         	System.out.println("insertion failed");
         	
         }
         
         System.out.println();
         System.out.println();
         
         System.out.println("data from the table is ");
         List<Student> ss=dao.getallstudents();
         for(Student std:ss) {
         	System.out.println(std.getSid()+"   "+std.getSname()+"  "+std.getSemail()+"  "+std.getPhono());
         }
     }
}

