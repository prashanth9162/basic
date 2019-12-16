package com.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dao.IRegisterDao;
import com.pojos.User;

public class RegisterDaoImpl implements IRegisterDao {

	public void saveUser(User us) throws Exception {
		
		System.out.println("Entered into save user");
		
		Configuration con = new Configuration().configure();
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		System.out.println("session opened");
		
		session.save(us);
		System.out.println("saved user object into database"+us.getMobile());
		session.beginTransaction().commit();
		session.close();
		
	}

}
