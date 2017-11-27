package wpl.spring.dao;

import java.util.List;

import wpl.spring.entity.User;

public interface IUserDao {

	   public int updateUser(User user);
	   public void createUser(User user);
	   public int removeUser(String user);
	   public User getUser(String user);
	   public String authenticateUser(String email, String password);
	   public List<User> getallUser();
}
