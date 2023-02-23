package org.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        // creating object of question
        Question question=new Question();
        question.setQuestion_id(121);
        question.setQuestion("what is JAVA ?");
        Answer answer=new Answer();
        answer.setAnswer_id(221);
        answer.setAnswer("Java is a programming language");
        answer.setQuestion(question);
        question.setAnswer(answer);


        Question question1=new Question();
        question1.setQuestion_id(122);
        question1.setQuestion("what is Collection Framework ?");
        Answer answer1=new Answer();
        answer1.setAnswer_id(222);
        answer1.setAnswer("API to work with group of object");
        answer1.setQuestion(question1);
        question1.setAnswer(answer1);

        Session session= factory.openSession();
        Transaction transaction= session.beginTransaction();
        session.save(answer);
        session.save(answer1);
        session.save(question);
        session.save(question1);
        transaction.commit();

        // fetching the data
        Question q=(Question)session.get(Question.class,121);
        System.out.println(q.getQuestion());
        System.out.println(q.getAnswer().getAnswer());
        session.close();
        factory.close();
    }
}
