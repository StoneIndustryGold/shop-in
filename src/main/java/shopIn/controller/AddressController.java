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

import shopIn.pojo.Address;
import shopIn.sevice.AddressService;

@Controller
public class AddressController {
	private AddressService addressService;
	
	
	@Autowired
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@RequestMapping(method=RequestMethod.GET,value="/uc/address/add")
	public String addAdderess(@ModelAttribute Address address,
												Model model,
			@AuthenticationPrincipal(expression = "users.id") Integer usersId) {
			
			
	return "address-add";	
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/uc/address/add")
	public String addAddere(@ModelAttribute  @Valid Address address,
											BindingResult  bindingResult,
			@AuthenticationPrincipal(expression = "users.id") Integer usersId) {
			System.out.println("名字"+address.getConsigneeName()+"地址"+address.getDetailsAddress()+"电话"+address.getPhone());
			if(bindingResult.hasErrors()) {
				return "address-add";
			}
			addressService.addAddress(address,usersId);
		
		return "redirect:/uc/address/add";	
	}
	@RequestMapping(method=RequestMethod.GET,value="/uc/address/ubdate")
	public String updateAdderess(@ModelAttribute Address address,
													Model model,
				@AuthenticationPrincipal(expression = "users.id") Integer usersId) {
		
		List<Address>  addres=addressService.finOne(usersId);
		model.addAttribute("addres", addres);
		return "address-list";
	}
	@RequestMapping(method=RequestMethod.POST,value="/uc/address/ubdate")
	public String updateAddere(@ModelAttribute  @Valid Address address,
								BindingResult  bindingResult,
								@AuthenticationPrincipal(expression = "users.id") Integer usersId) {
		
		System.out.println(address.getConsigneeName()+"--"+address.getDetailsAddress()+"--"
				+ "--"+address.getPhone()+"--地址id："+address.getId());
		addressService.updateAddre(address,usersId);
		return "redirect:/uc/address/add";
	}
}
