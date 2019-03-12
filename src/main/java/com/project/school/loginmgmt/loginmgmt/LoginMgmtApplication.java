package com.project.school.loginmgmt.loginmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"com.project.school.loginmgmt.controller","com.project.school.loginmgmt.service","com.project.school.loginmgmt.util"})
@EntityScan("com.project.school.loginmgmt.model")
@EnableMongoRepositories("com.project.school.loginmgmt.repository")
public class LoginMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginMgmtApplication.class, args);
	}

}
