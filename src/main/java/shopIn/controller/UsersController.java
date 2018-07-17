package shopIn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shopIn.pojo.Users;
import shopIn.sevice.UsersService;

@Controller
public class UsersController {
	private UsersService usersService;
	
	@Autowired
	public UsersController(UsersService usersService) {		
		this.usersService = usersService;
	}


	@RequestMapping(method=RequestMethod.GET,value="/users/list")	
	public String usersfindAll(Model model) {
		List<Users> users=usersService.fondAll();
		for(Users u:users) {
			System.out.println("用户是："+u.getUsername());
			
		}
		model.addAttribute("users", users);
		return "users-list";
	}
}
