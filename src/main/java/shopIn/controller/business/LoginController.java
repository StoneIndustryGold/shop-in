package shopIn.controller.business;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shopIn.pojo.Users;
import shopIn.sevice.UsersService;

@Controller
public class LoginController {
	private UsersService usersService;
	
	@Autowired
	public LoginController(UsersService usersService) {
		this.usersService = usersService;
	}
	@RequestMapping(method=RequestMethod.GET,value="/login")//得到主键传来的login
	//error是网址上的信息当有他的时候就不让进去。把error那下来（必填要不让回会死循环）
	public String login(@RequestParam(required = false) String error,
			Model model) {
		if(error !=null) {//拿下来的error判断不等空是
			model.addAttribute("loginError", true);//就放行只是值为true--命名--“loginError”
		}
		return "login";//回到首次进入页面
	}
	//注册
	@RequestMapping(method=RequestMethod.GET,value="/register")
	public String add(@ModelAttribute Users users ) {		
	
		return "register";
	}
	//注册
	@RequestMapping(method=RequestMethod.POST,value="/register")
	public String adduser(@ModelAttribute 
					 @Valid Users users,
					BindingResult  bindingResult) {		
		if(bindingResult.hasErrors()) {			
			return "register";			
		}
		System.out.println("用户是："+users.getUsername()+""+users.getPassword()+""+users.getImages()+""+
				users.getSex());
		
		usersService.addUser(users);
		return "redirect:/login";//回到首次进入页面
	}
}
	

