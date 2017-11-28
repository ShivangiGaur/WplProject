package wpl.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wpl.spring.dao.IUserDao;
import wpl.spring.service.IUserService;
import wpl.spring.entity.Inventory;
import wpl.spring.entity.User;

@Service
public class IUserServiceImp implements IUserService {

	@Autowired
	private IUserDao addUserDao;
	
	@Override
	@Transactional
	public void addUser(User user) {
		// TODO Auto-generated method stub
		addUserDao.createUser(user);

	}

	@Override
	@Transactional
	public int updateUser(User update) {
		// TODO Auto-generated method stub
		return addUserDao.updateUser(update);
		
	}

	@Override
	@Transactional
	public int removeUser(String remove) {
		// TODO Auto-generated method stub
		return addUserDao.removeUser(remove);

	}



	@Override
	@Transactional
	public User getUser(String user) {
		// TODO Auto-generated method stub
		return addUserDao.getUser(user);
		
	}
//
//	@Override
//	public void getallUser(User user) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	@Transactional
	public List<User> getallUser() {
		// TODO Auto-generated method stub
		return addUserDao.getallUser();
		
	}

	@Override
	@Transactional
	public String authenticateUser(String email, String password) {
		// TODO Auto-generated method stub
		return addUserDao.authenticateUser(email, password);
	}


	
}
