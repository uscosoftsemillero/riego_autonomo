package com.api.demo.service;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.api.demo.modelo.entidades.Usuario;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private MongoOperations mongoOps;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario user = mongoOps.findOne(new Query(where("user").is(username)), Usuario.class);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		} else {
			User users = (User) User.builder().username(user.getUser()).password(user.getPassword())
					.roles("admin").build();
			return users;
		}
	}
}