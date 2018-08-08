package shopIn.controller.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import shopIn.sevice.IpService;


public abstract class BaseServiceController {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IpService ipServiice;
	
	@ModelAttribute// springmvc在执行控制器类中的@RequestMapping方法之前会自动调用@Model
	public void prepareCommonModel(HttpServletRequest requst,
									HttpSession session,//拿到会话
									Model model//把拿到的数据放到model
									) {
		logger.debug("准备数据");
		String ip=requst.getRemoteAddr();//获得请求ip地址
		String province=ipServiice.ipToProvince(ip);
		logger.debug("ip定位"+province);
//		String province=(String) session.getAttribute("userProvince");//接收userProvince地址
//
//		if(province==null) {//判断取来的值等于空时
//			province=ipServiice.ipToProvince(ip);//就去查找ip
//			session.setAttribute("userProvince", province);//查到的数据存往会话中
//		}
		model.addAttribute("userProvince", province);
	}
}
