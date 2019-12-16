package com.controllers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojos.User;

@Controller
public class UserController {
	
	static SessionFactory sf ;
	static {
		sf= new Configuration().configure().buildSessionFactory();
	}
	
	
	@RequestMapping(value = "/fetchAllRecords")
	public String showAll(Model m) {
		
		Session session = sf.openSession();
		Query query = session.createQuery("from User");
		List list = query.list();
		
		m.addAttribute("userList",list);
		return "Profiles";
	
	}
	
	
	@RequestMapping(value="/deleteUser")
	public String deleteUser(@RequestParam("idToDelete") int id, Model m) {
		System.out.println("delete button triggered" +id);
		
		Session session1 = sf.openSession();
		
		Query query1 = session1.createQuery("delete from User where id =:id1");
		query1.setParameter("id1", id);
        query1.executeUpdate();
        
        session1.beginTransaction().commit();
        Query queryAllUsers = session1.createQuery("from User");
        List<User> userlist = queryAllUsers.list();
        
        m.addAttribute("userList",userlist);
        session1.close();

        return "Profiles";
		
	}
	
	@RequestMapping(value = "/editView", method = RequestMethod.POST)
	public String editView(@RequestParam("idtoedit") int id, Model m) {
		System.out.println("triggered edit button : " + id);

		Session session = sf.openSession();

		Query queryById = session.createQuery("from User where id =:id");
		queryById.setParameter("id", id);
		List<User> userList = queryById.list();

		m.addAttribute("userObj", userList.get(0));

		return "Edit";
	}

	@RequestMapping(value = "/updateUser")
	public String updateUserDetails(User us, Model m) {
		System.out.println("updateUserDetails method triggered!!");
		System.out.println(us.getName());
		System.out.println(us.getMobile());
		System.out.println(us.getId());
		
		Session session = sf.openSession();

		try{
		session.update(us);
		session.beginTransaction().commit();
		}catch(StaleObjectStateException ex){
			m.addAttribute("errorMsg", "The record has been modified by other user, kinldy take the latest and update");
			return "Edit";
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Query queryAllUsers = session.createQuery("from User");
		List<User> userList = queryAllUsers.list();
		m.addAttribute("userList", userList);

		session.close();

		return "Profiles";
	}

}
