package shopIn.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import shopIn.mapper.UsersMapper;
import shopIn.pojo.Users;
import shopIn.sevice.UsersService;
@Service
public class UsersServiceImpl implements UsersService {
	private UsersMapper usersMapper;
	private PasswordEncoder passwordEncoder;
	@Autowired
	public UsersServiceImpl(UsersMapper usersMapper, PasswordEncoder passwordEncoder) {
		this.usersMapper = usersMapper;
		this.passwordEncoder = passwordEncoder;
	}



	public List<Users> fondAll() {
		
		return usersMapper.fondAll();
	}


	public Users findOneByUsername(String username) {
		// TODO Auto-generated method stub
		return usersMapper.findOneByUsername(username);
	}


	public void addUser(Users users) {
	String passwordEncode=passwordEncoder.encode(users.getPassword());
	users.setPassword(passwordEncode);	
	usersMapper.addUser(users);
		
	}


	public boolean create(String username) {
		
		return usersMapper.create(username);
	}

}
