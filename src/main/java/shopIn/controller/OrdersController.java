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
	
	@Autowired
	public OrdersController(CartsService cartsService, 
			AddressService addressService, OrdersService ordersService
			) {
		this.cartsService = cartsService;
		this.addressService = addressService;
		this.ordersService = ordersService;
		
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
		
		return ordersService.payForm(usersId,id);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/uc/orders/sync-pay-cb")
	public String payok(@RequestParam("out_trade_no") String orderNumber,
						Model model) {
		Integer orderId=Integer.valueOf(orderNumber.split("-")[0]);
		model.addAttribute("orderId", orderId);
		return "order-pay-ok";
	}
}
