package com.project.school.loginmgmt.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.loginmgmt.model.User;
import com.project.school.loginmgmt.repository.IUserRepository;
import com.project.school.loginmgmt.util.EncryptorDecryptorUtil;

/**
 * @author Vishal
 *
 */
@Service
public class UserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private EncryptorDecryptorUtil encryptorDecryptorUtil;
	
	public User login(String userName , String password) {
		List<User> userList = userRepository.findByUserNameAndPassword(encryptorDecryptorUtil.encryptString(userName),encryptorDecryptorUtil.encryptString(password));
		User user = null ;
		if(null!= userList && !userList.isEmpty())
			user = userList.get(userList.size()-1);
		if(null != user) {
			user.setUserName(encryptorDecryptorUtil.decryptString(user.getUserName()));
			user.setPassword(null);
		}		
		return user;
	}	
	
	public User getUserById(String id) {
		Optional<User> foundUser = userRepository.findById(id);
		User user;
		if(foundUser.isPresent()) {
			user = foundUser.get();
			user.setUserName(encryptorDecryptorUtil.decryptString(user.getUserName()));
			user.setPassword(encryptorDecryptorUtil.decryptString(user.getPassword()));
		}else {
			user=null;
		}
		return user;		
	}
	public User createUser(User user) {
		user.setCreatedDate(new Date());
		user.setUserName(encryptorDecryptorUtil.encryptString(user.getUserName()));
		user.setPassword(encryptorDecryptorUtil.encryptString(user.getPassword()));
		User savedUser = userRepository.save(user);
		savedUser.setUserName(encryptorDecryptorUtil.decryptString(savedUser.getUserName()));
		savedUser.setPassword(encryptorDecryptorUtil.decryptString(savedUser.getPassword()));
		return savedUser;
	}
	

	
}
