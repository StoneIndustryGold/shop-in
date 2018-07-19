package shopIn.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopIn.mapper.UsersMapper;
import shopIn.pojo.Users;
import shopIn.sevice.UsersService;
@Service
public class UsersServiceImpl implements UsersService {
	private UsersMapper usersMapper;
	
	@Autowired
	public UsersServiceImpl(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}


	public List<Users> fondAll() {
		
		return usersMapper.fondAll();
	}


	public Users findOneByUsername(String username) {
		// TODO Auto-generated method stub
		return usersMapper.findOneByUsername(username);
	}


	public void addUser(Users users) {
		usersMapper.addUser(users);
		
	}


	public boolean create(String username) {
		
		return usersMapper.create(username);
	}

}
