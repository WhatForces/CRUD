package com.edusak.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eduask.bean.User;

public class IndexController {

	public static void main(String[] args) {
		
		
	}

	public static void add(User user) {
		
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session =sf.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction();
		session.close();
		sf.close();
	}
	
	public static User query(int id) {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		User user = (User) session.get(User.class, id);
		session.close();
		sf.close();
		return user;
	}
	
	public static void update(User user) {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session =sf.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public static void delete(int id) {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		User user = new User();
		user.setId(id);
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
