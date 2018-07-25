package shopIn.sevice.impl;

import java.util.List;

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


	@Override
	public List<Address> finOne(Integer usersId) {
		
		return addressMapper.findOne(usersId);
	}


	@Override
	public Address finOneAddress(int id) {
		
		return addressMapper.finOneAddress(id);
	}


	@Override
	public void updateAddress(Address address) {
		addressMapper.updateAddress(address);
		
	}




}
