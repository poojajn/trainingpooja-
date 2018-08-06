package com.trainig.exilant.restfulworks.user;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {
private static List<User> users=new CopyOnWriteArrayList();

static {
	users.add(new User(101,"pooja",new Date()));
	users.add(new User(102,"deepi",new Date()));
	users.add(new User(103,"suni",new Date()));
}


public List<User> getAllUsers(){
	return users;
}

public User saveUsers(User user) {
	int userCount=1;
	if(user.getUserId()==null) {
		
		user.setUserId(++userCount);
	}
	users.add(user);
	return user;
}

public User getUser(int userId) {
	for(User us:users) {
		if(us.getUserId()==userId) {
			return us;
		}
	}
	return null;
}

public User deleteUser(int userId) {
	for(User u:users) {
		if(u.getUserId()==userId) {
			users.remove(u);
		}
	}
	return null;
}
public User updateUser(User user) {
	for(User u:users) {
		if(u.getUserId()==user.getUserId()) {
			u.setUname(user.getUname());
			return u;
		}
	}
	return null;
	
}
 }
