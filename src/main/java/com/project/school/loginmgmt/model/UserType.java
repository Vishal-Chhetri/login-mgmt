package com.project.school.loginmgmt.model;

/**
 * @author Vishal
 *
 */
public enum UserType {
	STUDENT(0), PARENT(1), TEACHER(2), ADMIN(3);

	private int id;
	
	private String name;

	private UserType(int num) {
		this.id = num;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}