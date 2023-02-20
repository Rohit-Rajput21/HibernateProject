package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableDemo {
    public static void main(String[] args) {
        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Student1 student1=new Student1();
        student1.setId(121);
        student1.setCity("Indore");
        student1.setName("Manish");
        Certificate certificate=new Certificate();
        certificate.setCourse("Java");
        certificate.setDuration("2 months");
        student1.setCerti(certificate);

        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(student1);
        tx.commit();
        session.close();
        factory.close();

    }
}
