package shopIn.controller.business;

import javax.validation.Valid;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shopIn.pojo.Users;
import shopIn.sevice.UsersService;


@Controller
@Transactional
public class LoginController extends BaseServiceController{
	//private Logger 
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
		
		if(usersService.create(users.getUsername())) {
			bindingResult.rejectValue("username", "create","用户名已占用");
		}
		
		if(bindingResult.hasErrors()) {			
			return "register";			
		}
		usersService.addUser(users);
		return "redirect:/login";//回到首次进入页面
	}
}
	

