package in.crudrestapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.crudrestapi.entity.User;
import in.crudrestapi.repository.UserRepository;
import in.crudrestapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Integer userId) {
		Optional<User> findByIdUser = userRepository.findById(userId);
		
		if (findByIdUser.isPresent()) {
			User user = findByIdUser.get();
			userRepository.delete(user);
		}
	}

	@Override
	public User getUserById(Integer userId) {
		Optional<User> usersId = userRepository.findById(userId);
		
		if (usersId.isPresent()) {
			return usersId.get();
		}
		return null;
	}
}
