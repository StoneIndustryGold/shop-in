package shopIn.sevice;

import java.util.List;

import shopIn.pojo.Users;

public interface UsersService {
	
	List<Users> fondAll();

	Users findOneByUsername(String username);
	
	
}
