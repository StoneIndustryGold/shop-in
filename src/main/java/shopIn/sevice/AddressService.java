package shopIn.sevice;

import java.util.List;

import javax.validation.Valid;

import shopIn.pojo.Address;

public interface AddressService {

	void addAddress(Address address, Integer usersId);

	List<Address> finOne(Integer usersId);

	Address finOneAddress(int id);

	void updateAddress(Address address);

	void deleteAddress(int id);

	
	
}
