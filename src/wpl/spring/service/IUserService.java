package wpl.spring.service;

import java.util.List;

import wpl.spring.entity.Inventory;
import wpl.spring.entity.User;

public interface IUserService {
	
	public void addUser(User user) ;
	public int updateUser(User update);
	public int removeUser(String remove);
	public String authenticateUser(String email, String password);
	public User getUser(String user);
	public List<User> getallUser();

}
