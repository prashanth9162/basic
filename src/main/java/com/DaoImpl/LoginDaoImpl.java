package com.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dao.ILoginDao;
import com.pojos.User;

public class LoginDaoImpl implements ILoginDao{

	public List<User> getUserDetails(int id, String password) {
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("from User where id = :id and password = :password");
		query.setParameter("id", id);
		query.setParameter("password", password);
		List list = query.list();
		
		session.close();
		
		return list;
	}	

	public List<User> getAllUsers() {
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		
        Query queryAllUsers = session.createQuery("from User");
	
		List<User> userList = queryAllUsers.list();
		session.close();
		System.out.println(userList.get(1).getMobile());
		
		return userList;
	}
		

}
