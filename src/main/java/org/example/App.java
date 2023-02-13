package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Project started......" );
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        System.out.println(factory);
        System.out.println(factory.isClosed());
        System.out.println(factory.isOpen());

        Student student=new Student();
        student.setId(101);
        student.setName("Rohit");
        student.setCity("Indore");
        System.out.println(student);

        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }
}
