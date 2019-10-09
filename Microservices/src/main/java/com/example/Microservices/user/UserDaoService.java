package com.example.Microservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
   
	private static List<User> users = new ArrayList();
	private static int count =3;
	static 
	{
		users.add(new User(1, "pinky", new Date()));
		users.add(new User(2, "rahul", new Date()));
		users.add(new User(3, "mallesh", new Date()));
	}
	
	
	public User findOne(int id) 
	{
		for(User user:users) 
		{
			if(user.getId()==id)
				return user;
		}
		return null;
	}
	
	public User delete(int id) 
	{
		Iterator<User> it=users.iterator();
		while(it.hasNext()) 
		{
			User user = it.next();
		
			if(user.getId()==id)
				it.remove();
			    return user;
		}
		return null;
	}
	
	public List<User> findAll()
	{
		return users;
	}
	
	public User save(User a)
	{
		if(a.getId()==null) 
		{
			a.setId(++count);
		}
		users.add(a);
		return a;
	}
}
