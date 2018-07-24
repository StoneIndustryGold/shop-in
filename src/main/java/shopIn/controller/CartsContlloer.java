package shopIn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shopIn.pojo.Carts;
import shopIn.sevice.CartsService;

@Controller
public class CartsContlloer {
	private CartsService cartsService;
	
	@Autowired
	
	public CartsContlloer(CartsService cartsService) {
		this.cartsService = cartsService;
	}
	@RequestMapping(method=RequestMethod.POST,value="/uc/carts/add")
	public String add(@RequestParam Integer cellponesId,//jsp传来的商品的id
		//和当前用户的id从UserDetailsImpl类里拿的应为那里可以的到当前用户，新知识@AuthenticationPrincipal
					  @AuthenticationPrincipal(expression = "users.id") Integer usersId ) {
		 // 注意：SecurityConfig中配置的/uc/**需要登录保证了到达此控制器方法时，必定有用户已登录，这样才能顺利		
		System.out.println("--当前用户："+usersId+"商品："+cellponesId);
		cartsService.addToCart(usersId,cellponesId,1);
		return "redirect:/";
	}
	@RequestMapping(method=RequestMethod.POST,value="/uc/carts/upteda")
	public String upteda(@RequestParam Integer cellponesId,
			@AuthenticationPrincipal(expression = "users.id") Integer usersId ) {
			System.out.println("取消:"+cellponesId);
			cartsService.uptedaCarts(usersId,cellponesId);//当前用户点击取消订单时执行这方法。
		return "redirect:/uc/carts/details";
	}
	@RequestMapping(method=RequestMethod.POST,value="/uc/carts/uptedaCarts")
	public String uptedaCarts(@RequestParam Integer cellponesId,
							  @AuthenticationPrincipal(expression = "users.id") Integer usersId) {
		System.out.println("asf:"+cellponesId);
		cartsService.minusCarts(usersId,cellponesId,1);//当点击减去--按钮是执行这方法
		return "redirect:/uc/carts/details";
	}
	@RequestMapping(method=RequestMethod.POST,value="/uc/carts/uptedaCartsAdd")
	public String uptedaCartsAdd(@RequestParam Integer cellponesId,
			 					@AuthenticationPrincipal(expression = "users.id") Integer usersId) {//当点击加号是执行这方法--加一方法
		System.out.println("商品："+cellponesId);
		cartsService.uptedaCartsAdd(usersId,cellponesId,1);
		return "redirect:/uc/carts/details";
	}
	
	
	
	
	
	@RequestMapping(method=RequestMethod.GET,value="/uc/carts/details")
	public String cartsSee(@AuthenticationPrincipal(expression ="users.id") Integer usersId,
						   Model model) {
		System.out.println("购物车："+usersId);//查找购物车有那些商品
		List<Carts> cartsItems=cartsService.finCartsItems(usersId);
		
		for(Carts c:cartsItems) {
			System.out.println("ee:"+c.getCount());
		}
		model.addAttribute("cartsItem", new CartItem(cartsItems));
		return "carts-details";
	}
}