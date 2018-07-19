package shopIn.config;
import java.security.Permissions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import shopIn.pojo.Users;

public class UserDetailsImpl extends User{
	private Users users;//点尸体里别的属性
	public UserDetailsImpl(Users users) {
		super(users.getUsername(),
			  users.getPassword(),
			  users.getEnabled() == null ? true : users.getEnabled(),
					 true, true ,true,
					 buildAuthorities(users));
			this.users=users;
	}
	private static List<GrantedAuthority> buildAuthorities(Users users) {
		List<GrantedAuthority>  authorities=new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("adni_"+users));
	
		return authorities;
	}
	
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	

}
