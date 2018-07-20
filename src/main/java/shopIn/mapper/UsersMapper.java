package shopIn.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import shopIn.pojo.Users;

public interface UsersMapper {
	
	List<Users> fondAll();
	
	Users findOneByUsername(String username);
	
	void addUser(Users users);
	
	boolean create(String username);

	void updateLastLoginTime(@Param("id")Integer id,
							@Param("date")Date date);
}
