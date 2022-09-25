package com.blog.demo.services;

import java.util.List;

import com.blog.demo.payloads.UserDto;

public interface UserService {
	UserDto createUser(UserDto userDto);  //We don't want that Entities directly communicate to Api
	UserDto updateUser(UserDto userDto, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
}
