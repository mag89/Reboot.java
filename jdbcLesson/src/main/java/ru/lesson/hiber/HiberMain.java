package ru.lesson.hiber;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberMain {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
