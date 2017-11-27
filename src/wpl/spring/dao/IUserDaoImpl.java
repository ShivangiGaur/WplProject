package wpl.spring.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import wpl.spring.entity.User;

import java.util.List;

import javax.persistence.EntityManager;

@Repository
public class IUserDaoImpl implements IUserDao{

	@Autowired 
	private SessionFactory sessionFactory;

	@Override
	public int updateUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println(user.getFirstName());
		String stringQuery = "UPDATE User SET FirstName= :firstname, LastName= :lastname, SecurityQuestion= :securityquestion, "
				+ "SecurityAnswer= :securityanswer, Password= :password  WHERE EmailID= '"+user.getEmail()+"'";
		Query query = currentSession.createQuery(stringQuery);
		query.setParameter("firstname", user.getFirstName());
		query.setParameter("lastname", user.getLastName());
		query.setParameter("securityquestion", user.getSecurityQuestion());
		query.setParameter("securityanswer", user.getSecurityAnswer());
		query.setParameter("password", user.getPassword());
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(user);
	}

	@Override
	public int removeUser(String user) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		String stringQuery = "Delete from User where EmailID = :email";
		Query query = currentSession.createQuery(stringQuery);
		query.setParameter("email", user);
		int result = query.executeUpdate();
		return result;

	}

	@Override
	public List<User> getallUser() {
		Session currentSession = sessionFactory.getCurrentSession();
		String stringQuery = "FROM User";
		Query query = currentSession.createQuery(stringQuery);
		List<User> userReturned = query.getResultList();
		if(userReturned.size()>0)
			return userReturned;
		else
			return null;

	}

	@Override
	public User getUser(String user) {
		Session currentSession = sessionFactory.getCurrentSession();
		String stringQuery = "FROM User WHERE EmailID = '" + user+"'";
		Query query = currentSession.createQuery(stringQuery);
		List<User> userReturned = query.getResultList();
		if(userReturned.size()>0)
			return userReturned.get(0);
		else
			return null;
	}

	@Override
	public String authenticateUser(String email, String password) {
		Session currentSession = sessionFactory.getCurrentSession();
		String stringQuery = "FROM User WHERE EmailID = '" + email+"' and Password = '" + password+"'";
		Query query = currentSession.createQuery(stringQuery);
		List<User> userReturned = query.getResultList();
		if(userReturned.size()>0)
			return email;
		else
			return null;
	}

}
