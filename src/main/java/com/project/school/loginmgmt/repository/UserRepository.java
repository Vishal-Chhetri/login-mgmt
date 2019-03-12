/**
 * 
 */
package com.project.school.loginmgmt.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.project.school.loginmgmt.model.User;

/**
 * @author Vishal
 *
 */
@Repository
public class UserRepository{
	
	@Autowired
	private MongoOperations mongoOperations;
	
	private static final String USERNAME = "userName";
	private static final String PASSWORD = "password";
	
	
	public User login(String userName ,String password) {
		Query query = new Query();
		query.addCriteria(Criteria.where(USERNAME).is(userName).and(PASSWORD).is(password));
		return mongoOperations.findOne(query, User.class);
	}
	

}
