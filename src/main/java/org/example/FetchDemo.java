package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        // Different test cases :
        Student student=new Student();
        student.setId(101);
        student.setName("Sanjay");
        student.setCity("Chanderi");

        Address address=new Address();
        address.setCity("Indore");
        address.setOpen(true);
        address.setStreet("street1");
        address.setAddressId(101);



        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(student);
        session.save(address);
        tx.commit();
        //case 1: Data is not exist in database -> return ObjectNotFoundException
      //  Student student1=(Student)session.load(Student.class,104);
      //  System.out.println(student1);

        //case 2: return proxy object and doesn't fire select query
       // Student student1=(Student)session.load(Student.class,101);
       // Student student2=(Student)session.load(Student.class,101);

        //case 3:when we call any method then hibernate fires the select query
//        Student student1=(Student)session.load(Student.class,101);
//        System.out.println(student1.getId());
//        System.out.println(student1);

        //case 4: get method return null if data does not exist in database
//        Address ad=(Address)session.get(Address.class,108);
//        System.out.println(ad);

        //case 5: get method stores the object in seccion's cache memory
        Address ad1=(Address)session.get(Address.class,1);
        System.out.println(ad1.getStreet()+" "+ad1.getCity());
        Address ad2=(Address)session.get(Address.class,1);
        System.out.println(ad2.getStreet()+" "+ad2.getCity());

        session.close();
        factory.close();

    }
}
