package service.serviceImpl;

import dao.UserDao;
import dao.daoImpl.UserDaoImpl;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User findByNameAndPswd(String name, String pswd) {
		UserDao userDao = new UserDaoImpl();
		
		return userDao.find(name, pswd);
	}

	@Override
	public void save(User user) {
		UserDao userDao = new UserDaoImpl();
		
		userDao.save(user);
	}

}
