package shopIn.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shopIn.mapper.AddressMapper;
import shopIn.pojo.Address;
import shopIn.sevice.AddressService;
@Service
@Transactional
public class AddressIml implements AddressService {
	private AddressMapper addressMapper;
	
	@Autowired
	public AddressIml(AddressMapper addressMapper) {
		this.addressMapper = addressMapper;
	}


	@Override
	public void addAddress(Address address, Integer usersId) {
		addressMapper.addAddress(address, usersId);
		System.out.println("实现类名字："+address.getConsigneeName()+"地址："+address.getDetailsAddress()+"电话"+address.getPhone());
	}

}
