package in.crudrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.crudrestapi.entity.User;
import in.crudrestapi.repository.UserRepository;
import in.crudrestapi.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUser")
	public ResponseEntity<?> saveUsers(@RequestBody User user){
		User saveUser = userService.saveUser(user);
		if (saveUser == null) {
			return new ResponseEntity<>("User not saved",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED) ;
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<?> getAllUser(){
		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<>(allUsers,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateUsers(@RequestBody User user){
		User saveUser = userService.saveUser(user);
		if (saveUser == null) {
			return new ResponseEntity<>("User not updated",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED) ;
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id){
		userService.deleteUser(id);
		return new ResponseEntity<>("Delete successully",HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable Integer id){
		User userById = userService.getUserById(id);
		if (userById == null) {
			return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(userById,HttpStatus.OK);
	}
}
