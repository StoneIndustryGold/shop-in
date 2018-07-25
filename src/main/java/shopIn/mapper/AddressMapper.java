package shopIn.mapper;

import org.apache.ibatis.annotations.Param;

import shopIn.pojo.Address;

public interface AddressMapper {

	void addAddress(@Param("address")Address address,
					@Param("usersId") Integer usersId);
}
