package com.vivek.Chakrawaat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	
        Vehicle c = (Vehicle) context.getBean("car");
        Vehicle c2 = (Vehicle) context.getBean("bike");
        c.drive();
        c2.drive();
        
        Tyre t = (Tyre) context.getBean("tyre");
        System.out.println(t);
    }
}
