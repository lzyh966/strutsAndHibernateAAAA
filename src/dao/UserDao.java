package dao;

import model.User;

public interface UserDao {
	public User find(String userName, String password);
	
	public void save(User user);
}
