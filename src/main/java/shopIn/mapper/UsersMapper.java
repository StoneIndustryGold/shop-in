package shopIn.mapper;

import java.util.List;

import shopIn.pojo.Users;

public interface UsersMapper {
	
	List<Users> fondAll();
	
	Users findOneByUsername(String username);
	
	void addUser(Users users);
	
	boolean create(String username);
}
