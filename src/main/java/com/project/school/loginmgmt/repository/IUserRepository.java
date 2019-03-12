/**
 * 
 */
package com.project.school.loginmgmt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.school.loginmgmt.model.User;

/**
 * @author Vishal
 *
 */
@Repository
public interface IUserRepository extends MongoRepository<User, String>{
	
	public List<User> findByUserNameAndPassword(String username , String password);

}
