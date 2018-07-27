package shopIn.mapper;



import shopIn.pojo.Orders;
import shopIn.pojo.Item.OrdersItem;

public interface OrdersMapper {
	
	void create(Orders orders);

	void addItem(OrdersItem ordersItem);
}
