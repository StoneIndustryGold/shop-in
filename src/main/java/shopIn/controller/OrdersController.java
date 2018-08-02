package shopIn.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

import shopIn.OrderState;
import shopIn.controller.form.OrdersForm;
import shopIn.pojo.Address;
import shopIn.pojo.Cart;
import shopIn.pojo.Orders;
import shopIn.sevice.AddressService;
import shopIn.sevice.CartsService;
import shopIn.sevice.OrdersService;

@Controller
public class OrdersController {//订单控制类
	private CartsService cartsService;//购物车接口
	private AddressService addressService;//地址接口
	private OrdersService ordersService;//依赖订单接口
	private AlipayClient alipayClient;//依赖了支付宝接口第三方的
	@Autowired
	public OrdersController(CartsService cartsService, AddressService addressService, OrdersService ordersService,
			AlipayClient alipayClient) {
		this.cartsService = cartsService;
		this.addressService = addressService;
		this.ordersService = ordersService;
		this.alipayClient = alipayClient;
	}



	//订单生成中。。
	@RequestMapping(method=RequestMethod.GET,value="/uc/Orders/add")
	public String add(@ModelAttribute OrdersForm ordersForm,
					@AuthenticationPrincipal(expression = "users.id") Integer usersId,
					Model model) {
		refactoring(usersId, model);
		return "Orders-add";
	}


	//重构方法
	private void refactoring(Integer usersId, Model model) {
		Cart cartsItem=cartsService.fondOneByUserID(usersId);
		model.addAttribute("cartsItem", cartsItem);
		
		List<Address> addres=addressService.finAll(usersId);//查找购物车
		model.addAttribute("addres", addres);
	}
	//生成订单
	@RequestMapping(method=RequestMethod.POST,value="/uc/Orders/add")
	public String create(@AuthenticationPrincipal(expression = "users.id") Integer usersId,
						 @ModelAttribute   @Valid OrdersForm ordersForm,
						 BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			refactoring(usersId, model);
			
			return "Orders-add";
		}
		System.out.println("了空间啊："+ordersForm.getAddressId());
		Orders orders=ordersService.create(usersId,ordersForm.getAddressId());
		
		return "redirect:/uc/Orders/list";
	}
	//订单集合页面
	@RequestMapping(method=RequestMethod.GET,value="/uc/Orders/list")
	public String list(@AuthenticationPrincipal(expression = "users.id") Integer usersId,
							Model model) {
		List<Orders> orders=ordersService.findALl(usersId);
	
		model.addAttribute("orders", orders);
		return "Orders-list";
	}
	//订单详情页
	@RequestMapping(method=RequestMethod.GET,value="/uc/Orders/details/{id}")
	public String details(@AuthenticationPrincipal(expression = "users.id") Integer usersId,
						  @PathVariable int id,
						  @ModelAttribute OrdersForm ordersForm,
						  Model model) {
		System.out.println(id);
		Orders orders=ordersService.findOne(id,usersId);
		model.addAttribute("orders", orders);		
		return "Orders-details";
	}
	@RequestMapping(method=RequestMethod.POST,value="/uc/Orders/{id}/pay",
					produces="text/html;charset=UTF-8")// 非常重要，支付宝api响应是html片段（不含编码），必须显式
	@ResponseBody
	public String pay(@AuthenticationPrincipal(expression = "users.id") Integer usersId,
					  @PathVariable Integer id) throws AlipayApiException {
		Orders orders=ordersService.findOne(id,usersId);//这是订单id，和当前用户的id
		if(orders.getState() !=OrderState.Created) {//盘对从数据库里查的值不等于枚举的值
				throw new IllegalAccessError("只有Created状态的订单才能发起支付");
		}
		BigDecimal totalAmount=BigDecimal.valueOf(orders.totalCost()).divide(BigDecimal.valueOf(100));
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest(); // 即将发送给支付宝的请求（电脑
		alipayRequest.setReturnUrl("http://shop.me/shop-in/uc/orders/sync-pay-cb"); // 浏览器端完成支付后跳转回商户的地
		alipayRequest.setNotifyUrl("http://shop.me/shop-in/async-pay-cb");// 支付宝服务端确认支付成功后通知商户的地址（异步通知,需要上线才能做
		alipayRequest.setBizContent("{"+
				"	\"out_trade_no\":\"" + id.toString() + "-" + new Date().getTime() + "\"," + // 商户订单号，加时间戳是为了避免测试时订单号重复
				"   \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," + //产品码，固定
				"   \"total_amount\":" + totalAmount.toString() + "," + //订单总金额
				"   \"subject\":\"shop手机商城订单支付\"," +//订单标题
				"    \"body\":\"TODO 显示订单项概要\"" + // 订单描述
				
				"}");
		return alipayClient.pageExecute(alipayRequest).getBody();
	}
	@RequestMapping(method = RequestMethod.GET, value = "/uc/orders/sync-pay-cb")
	public String payok(@RequestParam("out_trade_no") String orderNumber,
						Model model) {
		Integer orderId=Integer.valueOf(orderNumber.split("-")[0]);
		model.addAttribute("orderId", orderId);
		return "order-pay-ok";
	}
}
