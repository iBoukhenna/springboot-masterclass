package com.dzcode.springboot.masterclass;

import com.dzcode.springboot.masterclass.model.Role;
import com.dzcode.springboot.masterclass.model.User;
import com.dzcode.springboot.masterclass.repository.UserRepository;
import com.dzcode.springboot.masterclass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbootMasterclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMasterclassApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			List<User> users = userService.getUsers();
			if (users.isEmpty()) {
				userService.saveRole(new Role(null, "ROLE_USER"));
				userService.saveRole(new Role(null, "ROLE_MANAGER"));
				userService.saveRole(new Role(null, "ROLE_ADMIN"));
				userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

				userService.saveUser(new User(null, "User", "user", "user@dzcode.com", "00213698706011","user", new ArrayList<>()));
				userService.saveUser(new User(null, "Manager", "manager", "manager@dzcode.com", "00213698706011","manager", new ArrayList<>()));
				userService.saveUser(new User(null, "Admin", "admin", "admin@dzcode.com", "00213698706011", "admin", new ArrayList<>()));
				userService.saveUser(new User(null, "Super Admin", "sadmin", "sadmin@dzcode.com", "00213698706011","sadmin", new ArrayList<>()));

				userService.addRoleToUser("user", "ROLE_USER");
				userService.addRoleToUser("manager", "ROLE_USER");
				userService.addRoleToUser("manager", "ROLE_MANAGER");
				userService.addRoleToUser("admin", "ROLE_USER");
				userService.addRoleToUser("admin", "ROLE_MANAGER");
				userService.addRoleToUser("admin", "ROLE_ADMIN");
				userService.addRoleToUser("sadmin", "ROLE_USER");
				userService.addRoleToUser("sadmin", "ROLE_MANAGER");
				userService.addRoleToUser("sadmin", "ROLE_ADMIN");
				userService.addRoleToUser("sadmin", "ROLE_SUPER_ADMIN");
			}
		};
	}
}
