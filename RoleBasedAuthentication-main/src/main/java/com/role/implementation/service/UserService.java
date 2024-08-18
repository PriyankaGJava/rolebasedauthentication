package com.role.implementation.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.role.implementation.model.User;


public interface UserService {
	List<User> getAllUsers();
	void saveUser(User user);
	Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	User getUserById(int id);
	void deleteUserById(int id);
}
