package shopIn.controller.business;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping(method=RequestMethod.GET,value="/login")//得到主键传来的login
	//error是网址上的信息当有他的时候就不让进去。把error那下来（必填要不让回会死循环）
	public String login(@RequestParam(required = false) String error,
			Model model) {
		if(error !=null) {//拿下来的error判断不等空是
			model.addAttribute("loginError", true);//就放行只是值为true--命名--“loginError”
		}
		return "login";//回到首次进入页面
	}
}
	

