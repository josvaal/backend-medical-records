package com.josval.backend.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.josval.backend.controller.mapper.UserMapper;
import com.josval.backend.model.dto.UserDTO;
import com.josval.backend.service.IUserService;

@Service
public class UserAuthService implements UserDetailsService {

	@Autowired
	IUserService userService;
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserDTO user = userMapper.toUserDTO(userService.findByEmail(email));
		
		if(user != null) {
			return User
					.withUsername(user.getEmail())
					.password(user.getPassword())
					.roles(user.getUserRole().name())
					.build();
		}
		else {
	        throw new UsernameNotFoundException("Usuario no encontrado con email: " + email);
	    }
	}
	

}
