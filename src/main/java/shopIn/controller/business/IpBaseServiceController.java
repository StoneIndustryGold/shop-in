package shopIn.controller.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import shopIn.sevice.IpService;


public class IpBaseServiceController {
	@Autowired
	private IpService ipServiice;
	
	

	@ModelAttribute// springmvc在执行控制器类中的@RequestMapping方法之前会自动调用@Model
	public void prepareCommonModel(HttpServletRequest requst,
									HttpSession session,//拿到会话
									Model model//把拿到的数据放到model
									) {
		System.out.println("准备数据");
		String ip=requst.getRemoteAddr();//获得请求ip地址
		String province=(String) session.getAttribute("userProvince");//接收userProvince地址
		if(province==null) {//判断取来的值等于空时
			province=ipServiice.ipToProvince(ip);//就去查找ip
			session.setAttribute("userProvince", province);//查到的数据存往会话中
		}
		model.addAttribute("userProvince", province);
	}
}
