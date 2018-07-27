package shopIn.sevice;

import shopIn.pojo.Orders;

public interface OrdersService {

	Orders create(Integer usersId, Integer addressId);

}
