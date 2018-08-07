package shopIn.controller.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import shopIn.sevice.IpService;

@Controller
public class IpServiceController {
	private IpService ipServiice;
	
	@Autowired
	public IpServiceController(IpService ipServiice) {
		this.ipServiice = ipServiice;
	}

	@RequestMapping(method=RequestMethod.GET,value="/ip",produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String ipToprovince(@RequestParam String ip) {
		System.out.println("测试"+ip);
		
		return ipServiice.ipToProvince(ip);
	}
}
