package shopIn.mapper;



import java.util.List;

import shopIn.pojo.Orders;
import shopIn.pojo.Item.OrdersItem;

public interface OrdersMapper {
	
	void create(Orders orders);

	void addItem(OrdersItem ordersItem);
	
	List<Orders> findALl(Integer usersId);
}
