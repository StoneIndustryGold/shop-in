package shopIn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import shopIn.pojo.Users;
import shopIn.sevice.UsersService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private UsersService  usersService;
	
	
	@Autowired
	public UserDetailsServiceImpl(UsersService usersService) {
		this.usersService = usersService;
	}


	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		Users users=usersService.findOneByUsername(username);
		if(users == null) {
			throw new UsernameNotFoundException("没有干用户"+username);
		}
		return new UserDetailsImpl(users);
	}

}
