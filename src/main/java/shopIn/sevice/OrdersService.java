package shopIn.sevice;

import java.util.List;

import shopIn.pojo.Orders;

public interface OrdersService {

	Orders create(Integer usersId, Integer addressId);

	List<Orders> findALl(Integer usersId);

}
