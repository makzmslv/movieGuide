package com.official.movieguide.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.official.movieguide.persistence.dao.UserDAO;
import com.official.movieguide.persistence.entity.User;

/**
 * This service is used for authenticating users using Spring-security. It
 * verifies whether a user is registered in the database and assigns appropriate
 * authority to the user i.e either ADMIN OR USER.
 * 
 * @version 1.0
 * @author Amity
 * 
 */
public class LoginAuthenticationImpl implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	/**
	 * Checks whether specified username/password is present in the database. If
	 * yes, allows access access to the user.
	 * 
	 * @param currencyName
	 * @return Currency if found, or null.
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		User user = userDAO.findByUsername(username);

		org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), true, true, true, true,
				getAuthorities(user.getRole()));

		return userDetail;
	}

	private List<GrantedAuthority> getAuthorities(Integer role) {

		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		if (role.intValue() == 1) {
			authList.add(new SimpleGrantedAuthority("ROLE_USER"));
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		} else {
			if (role.intValue() == 2) {
				authList.add(new SimpleGrantedAuthority("ROLE_USER"));
			}
		}
		return authList;
	}

}
