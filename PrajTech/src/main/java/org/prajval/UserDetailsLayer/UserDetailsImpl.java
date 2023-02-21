package org.prajval.UserDetailsLayer;

import org.prajval.EntityLayer.UserEntity;
import org.prajval.RepositoryLayer.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//WE FETCH OUR RECORDS FROM DB
				UserEntity user = userRepository.getUserByMail(username);
				if (user == null) {
					throw new UsernameNotFoundException("Could Not Found User");
				}
				
				CustomUserDetails customUserData = new CustomUserDetails(user);
				return customUserData;
	}

}
