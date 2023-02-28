package org.fetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        // creating object of question
//        Question question=new Question();
//        question.setQuestion_id(121);
//        question.setQuestion("what is JAVA ?");
//        Answer answer=new Answer();
//        answer.setAnswer_id(221);
//        answer.setAnswer("Java is a programming language");
//        answer.setQuestion(question);
//
//        Answer answer1=new Answer();
//        answer1.setAnswer_id(222);
//        answer1.setAnswer("API to work with group of object");
//        answer1.setQuestion(question);
//
//        List<Answer> a=new ArrayList<Answer>();
//        a.add(answer);
//        a.add(answer1);
//        question.setAnswers(a);
//
//
        Session session= factory.openSession();
//        Transaction transaction= session.beginTransaction();
//        session.save(answer);
//        session.save(answer1);
//        session.save(question);
//        transaction.commit();

        // Eager
        Question q=(Question)session.get(Question.class,121);
        System.out.println(q.getQuestion_id());
        System.out.println(q.getQuestion());
        for (Answer arr:q.getAnswers()) {
            System.out.println(arr.getAnswer());
        }

        session.close();
        factory.close();
    }
}
