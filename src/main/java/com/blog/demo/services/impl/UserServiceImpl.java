package com.blog.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.demo.entities.User;
import com.blog.demo.exceptions.ResourceNotFoundException;
import com.blog.demo.payloads.UserDto;
import com.blog.demo.repositories.UserRepo;
import com.blog.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = dtoToUser(userDto);
		User savedUser = userRepo.save(user);
		return userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		String message = "Could not found user with User id: "+userId;
		userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException(message) );
		
		User user = new User();
		user.setId(userDto.getId());
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser = userRepo.save(user);
		UserDto userDto1 = userToDto(updatedUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		String message = "Could not found user with User id: "+userId;
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException(message) );
		return userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepo.findAll();
		List<UserDto> userDto = users.stream().map(user -> userToDto(user)).collect(Collectors.toList());
		return userDto;
	}
	
	public User dtoToUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		/*
		 * user.setId(userDto.getId()); user.setName(userDto.getName());
		 * user.setEmail(userDto.getEmail()); user.setAbout(userDto.getAbout());
		 * user.setPassword(userDto.getPassword());
		 */
		return user;
	}
	
	public UserDto userToDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		
		return userDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		String message = "Could not found user with User id: "+userId;
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException(message) );
		userRepo.delete(user);
	}

}
