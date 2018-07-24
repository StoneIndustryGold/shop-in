package shopIn.config;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import shopIn.mapper.UsersMapper;

@Component
public class LoginSuccessListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent>{
	private UsersMapper usersMapper;
	
	
	@Autowired
	public LoginSuccessListener(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}



	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		UserDetailsImpl userDetails=(UserDetailsImpl) event.getAuthentication().getPrincipal();
		System.out.println("有人登录成功了: #"+
				userDetails.getUsers().getId()+""+
				userDetails.getUsername());
		usersMapper.updateLastLoginTime(userDetails.getUsers().getId(), new Date());
	}

}
