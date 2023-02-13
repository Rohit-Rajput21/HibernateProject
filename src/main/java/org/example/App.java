package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main ( String[] args ) throws IOException {

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

        Address ad=new Address();
        ad.setStreet("street_1");
        ad.setCity("Indore");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.345);

        FileInputStream fis=new FileInputStream("src/main/resources/tree-736885__480.jpg");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);


        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(student);
        session.save(ad);
        transaction.commit();
        session.close();
    }
}
