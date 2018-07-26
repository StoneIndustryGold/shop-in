package shopIn.controller;

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

import shopIn.pojo.Address;
import shopIn.sevice.AddressService;

@Controller
public class AddressController {
	private AddressService addressService;
	
	
	@Autowired
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}
	//添加方法
	@RequestMapping(method=RequestMethod.GET,value="/uc/address/add")
	public String addAdderess(@ModelAttribute Address address,
												Model model,
			@AuthenticationPrincipal(expression = "users.id") Integer usersId) {
			
			
	return "address-add";	
	}
	//添加方法
	@RequestMapping(method=RequestMethod.POST,value="/uc/address/add")
	public String addAddere(@ModelAttribute  @Valid Address address,
											BindingResult  bindingResult,
			@AuthenticationPrincipal(expression = "users.id") Integer usersId) {
			System.out.println("名字"+address.getConsigneeName()+"地址"+address.getDetailsAddress()+"电话"+address.getPhone());
			if(bindingResult.hasErrors()) {
				return "address-add";
			}
			addressService.addAddress(address,usersId);
		
		return "redirect:/uc/address/list";	
	}
	//详情页方法
	@RequestMapping(method=RequestMethod.GET,value="/uc/address/list")
	public String updateAdderess(@ModelAttribute Address address,
													Model model,
				@AuthenticationPrincipal(expression = "users.id") Integer usersId) {
		
		List<Address>  addres=addressService.finAll(usersId);
		model.addAttribute("addres", addres);
		return "address-list";
	}
	//修改前修改方法
	@RequestMapping(method=RequestMethod.GET,value="/uc/address/{id}/update")
	public String finOneAddress(@ModelAttribute Address address ,
								@PathVariable int id ,
								Model model,
								@AuthenticationPrincipal(expression = "users.id") Integer usersId) {
		System.out.println(id);
		Address addres=addressService.finOneAddress(id);
		model.addAttribute("addres", addres);
		return "address-add";
	}
	//修改方法
	@RequestMapping(method=RequestMethod.POST,value="/uc/address/{id}/update")
	public String ubdateAddre(@ModelAttribute Address address) {
		System.out.println(address);
		
		addressService.updateAddress(address);
		return "redirect:/uc/address/list";
	}
	@RequestMapping(method=RequestMethod.POST,value="/uc/address/{id}/delete")
	public String deleteAddress(@PathVariable int id) {
		System.out.println(id);
		addressService.deleteAddress(id);
		return "redirect:/uc/address/list";
	}
}
