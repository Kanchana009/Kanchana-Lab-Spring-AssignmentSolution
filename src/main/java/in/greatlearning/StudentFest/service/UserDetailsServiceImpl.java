package in.greatlearning.StudentFest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import in.greatlearning.StudentFest.entities.User;
import in.greatlearning.StudentFest.repo.UserRepository;
import in.greatlearning.StudentFest.security.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getByUsername(username);
		// TODO Auto-generated method stub
		return new MyUserDetails(user);

	}

}
