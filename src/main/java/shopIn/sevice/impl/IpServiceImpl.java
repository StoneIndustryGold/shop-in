package shopIn.sevice.impl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import ch.qos.logback.classic.Logger;
import shopIn.sevice.IpService;
@Service
public class IpServiceImpl implements IpService {
	//private Logger logger=LoggerFactory.这是日志
	private RestTemplate restTemplate;
	
	@Autowired
	public IpServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Cacheable(cacheNames = "ip-to-province", sync = true) 
	@Override
	public String ipToProvince(String ip) {
		
		Map<String,String> params=new HashMap<>();
		params.put("key", "1df963ffa84aa4fab66a7c6a8f618e4d");
		params.put("ip", ip);
		
		JsonNode json=restTemplate.getForObject(
				"https://restapi.amap.com/v3/ip?key={key}&ip{ip}", 
				JsonNode.class,// 将响应转换成json树模型
				params);
		System.out.println("调用高德地址："+json.at("/info")+json.at("/province"));
		return json.at("/province").asText();//json树根，/下的文件
	}

}
