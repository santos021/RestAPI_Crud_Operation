package in.crudrestapi.service;

import java.util.List;

import in.crudrestapi.entity.User;

public interface UserService {
	
	public User saveUser(User user);
	
	public List<User> getAllUsers();
	
	public User updateUser(User user);
	
	public void deleteUser(Integer userId);
	
	public User getUserById(Integer userId);
}
