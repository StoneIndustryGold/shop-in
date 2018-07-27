package shopIn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shopIn.controller.form.OrdersForm;
import shopIn.pojo.Address;
import shopIn.pojo.Cart;
import shopIn.pojo.Orders;
import shopIn.sevice.AddressService;
import shopIn.sevice.CartsService;
import shopIn.sevice.OrdersService;

@Controller
public class OrdersController {//订单控制类
	private CartsService cartsService;
	private AddressService addressService;
	private OrdersService ordersService;
	@Autowired
	public OrdersController(CartsService cartsService, AddressService addressService, OrdersService ordersService) {
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
		
		return "redirect:/";
	}
}
