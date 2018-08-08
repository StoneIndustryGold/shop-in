package shopIn.sevice.impl;

import java.io.File;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import shopIn.OrderState;
import shopIn.mapper.OrdersMapper;
import shopIn.pojo.Address;
import shopIn.pojo.Cart;
import shopIn.pojo.Orders;
import shopIn.pojo.Item.CartItem;
import shopIn.pojo.Item.OrdersItem;
import shopIn.sevice.CartsService;
import shopIn.sevice.OrdersService;
import shopIn.sevice.Exception.AlipaySignatureException;

@Service
@Transactional
public class OrdersImpl implements OrdersService {
	private OrdersMapper  ordersMapper;//依赖了--订单mapper
	private AlipayClient alipayClient;//依赖了支付宝接口第三方的
	private CartsService cartsService;//购物车接口 
	private String alipayReturnUrl;
	private String alipayNotifyurl;
	private String alipayPublickey;
	private String alipaySignType;
	private String appId;
	private ObjectMapper  objectMapper;
	
	@Autowired
	public OrdersImpl(OrdersMapper ordersMapper,
					AlipayClient alipayClient, 
					CartsService cartsService,
					ObjectMapper  objectMapper,
					Environment env) throws IOException{
		this.ordersMapper = ordersMapper;
		this.alipayClient = alipayClient;
		this.cartsService = cartsService;
		this.objectMapper=objectMapper;
		this.alipayReturnUrl = env.getProperty("alipay.rteurnUrl");
		this.alipayNotifyurl = env.getProperty("alipay.notifyurl");
		this.alipayPublickey=FileUtils.readFileToString(
				new File(env.getProperty("alipay.alipayPublicKeyFile")),
				"UTF-8");//异常校验
		this.alipaySignType=env.getProperty("alipay.signType");
		this.appId=env.getProperty("alipay.appId");//初始发id
	}


	@Override
	public Orders create(Integer usersId, Integer addressId) {
		//订单表
		Orders orders=new Orders();//new个订单实体
		orders.setUserId(usersId);//往里设置当前用户id
		Address address=new Address();//new个地址实体
		address.setId(addressId);//把地址id设置给它
		orders.setAddress(address);//在社往订单--订单拿到了--usersId和adderssId
		orders.setCreatetime(new Date());//往里面设置时间
		orders.setState(OrderState.Created);
		
		ordersMapper.create(orders);
		
		//创建订单项表
		//订单项里有-- 用户的id和--商品的id--和数量
		Cart cart=cartsService.fondOneByUserID(usersId);//通过用户id找到了商品项
		for(CartItem cartItem:cart.getItems()) {//得到了购物车
			OrdersItem ordersItem=new OrdersItem();//订单项new过来
			ordersItem.setOrdersId(orders.getId());//这id是从数据库里返回出来的，在上面
			ordersItem.setCellpones(cartItem.getCellpones());//拿到购物车里的商品
			ordersItem.setAmpout(cartItem.getCount());//拿到数量，并设置
			ordersMapper.addItem(ordersItem);//期待mapper有个添加方法 ，
		}
		
		cartsService.delete(usersId);
		return orders;
	}


	@Override
	public List<Orders> findALl(Integer usersId) {
		
		return ordersMapper.findALl(usersId);
	}


	@Override
	public Orders findOne(int id, Integer usersId) {
		System.out.println("当前："+id);
		return ordersMapper.findOne(id, usersId);
	}


	@Override
	public String payForm(Integer usersId, Integer id) {
		Orders orders=findOne(id, usersId);
		
		if(orders.getState() !=OrderState.Created) {//盘对从数据库里查的值不等于枚举的值
				throw new IllegalAccessError("只有Created状态的订单才能发起支付");
		}
		
		Integer totalAmountInFen=orders.totalCost();//为总金额，做了个容器totalAmountInFen
		BigDecimal totalAmount=BigDecimal.valueOf(totalAmountInFen).divide(BigDecimal.valueOf(100));// 订单总金额（元）
		
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest(); // 即将发送给支付宝的请求（电脑
		alipayRequest.setReturnUrl(alipayReturnUrl); // 浏览器端完成支付后跳转回商户的地
		alipayRequest.setNotifyUrl(alipayNotifyurl);// 支付宝服务端确认支付成功后通知商户的地址（异步通知,需要上线才能做
		
		Map<String,Object> bizContent=new HashMap<>();//new一个map集合-map无序的，通过键来取值
		
		bizContent.put("out_trade_no",""+id+"-" + new Date().getTime());// 商户订单号，加时间戳是为了避免测试时订单号重
		bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");//产品码，固定
		bizContent.put("total_amount", totalAmount);//订单总金额
		bizContent.put("subject", "shop手机商城订单支付");//订单标题
		bizContent.put("body", "TODO 显示订单项概要");// 订单描述
		//参数都放到了map对象bizContent
		try {
			String bizContentStr=objectMapper.writeValueAsString(bizContent);//objectMapper规定用他接收马皮对象
			System.out.println("alipay.bizContentStr:"+bizContentStr);
			alipayRequest.setBizContent(bizContentStr);//往这对象里添加数据这对象在上面alipayRequest
			 
			String rotm=alipayClient.pageExecute(alipayRequest).getBody();
			System.out.println("往购物车里添加"+id+"总金额"+totalAmountInFen);
			 ordersMapper.setTotalAmount(id,totalAmountInFen);//往购物车里添加总金额，通过当前id
			 
			 return rotm;//返回给支付宝rotm
		} catch (Exception e) {//不管什么异常都抛掉
			throw new RuntimeException(e);//这个异常解决了map对象的异常
		}
		
//		alipayRequest.setBizContent("{"+
//				"	\"out_trade_no\":\"" + id.toString() + "-" + new Date().getTime() + "\"," + // 商户订单号，加时间戳是为了避免测试时订单号重复
//				"   \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," + //产品码，固定
//				"   \"total_amount\":" + totalAmount.toString() + "," + //订单总金额
//				"   \"subject\":\"shop手机商城订单支付\"," +//订单标题
//				"    \"body\":\"TODO 显示订单项概要\"" + // 订单描述
//				
//				"}");

		
	}


	@Override
	public void verifySignature(Map<String, String> paramMap) throws AlipaySignatureException {
		//异常捕获，
			try {
				if(!AlipaySignature.rsaCheckV1(paramMap,alipayPublickey,"UTF-8",alipaySignType)) {
					throw new AlipaySignatureException();
				}				
			}catch (AlipayApiException e) {
				throw new AlipaySignatureException(e);
			}	
	}


	@Override
	public void handlePayResult(Map<String, String> paramMap) {
		//验签
		//verifySignature(paramMap);
		// 获取必要的请求参数
		String orderNumber=paramMap.get("out_trade_no");//out_trade_no: 81-1533173244190值
		Integer orderId=Integer.valueOf(orderNumber.split("-")[0]);//拿到除去减号的第零个下标的值--81
		Integer totalAmount = new BigDecimal(paramMap.get("total_amount")).multiply(BigDecimal.valueOf(100)).intValue();
		System.out.println(orderId);
		String appId=paramMap.get("app_id");//app_id: 2018052360246120  --商户id
		String tradeStatus=paramMap.get("trade_status");//支付宝传来的状态
		
		Orders	orders=ordersMapper.findOneToPay(orderId);//得到的值是148数据库里没有这个值id
		if(orders.getState()!=OrderState.Created) {
			throw new AlipayResultException("订单状态非Created");
		}	
		if(!orders.getTotalAmount().equals(totalAmount)) {
			throw new AlipayResultException("订单总金额不一致");
		}
		if(!appId.equals(this.appId)) {
			
			throw new AlipayResultException("appId不一致");
		}
		System.out.println("234");
		if("TRADE_SUCCESS".equals(tradeStatus) || "TRADE_FINISHED".equals(tradeStatus) ) {
			System.out.println("123");
			//设置订单状态唯一支付
			ordersMapper.setStateToPaid(orderId);
		}
	}


	@Override
	public void deleteOrders(Integer id) {
		ordersMapper.deleteOrders(id);
		
	}
}
