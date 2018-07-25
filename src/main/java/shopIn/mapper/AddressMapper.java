package shopIn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shopIn.pojo.Address;

public interface AddressMapper {

	void addAddress(@Param("address")Address address,
					@Param("usersId") Integer usersId);

	List<Address> findOne(Integer usersId);
	
	Address finOneAddress(int id);
	
	void updateAddress(Address address);
}
