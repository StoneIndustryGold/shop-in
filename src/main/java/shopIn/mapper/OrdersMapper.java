package shopIn.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import shopIn.pojo.Orders;
import shopIn.pojo.Item.OrdersItem;

public interface OrdersMapper {
	
	void create(Orders orders);

	void addItem(OrdersItem ordersItem);
	
	List<Orders> findALl(Integer usersId);
	
	Orders findOne(@Param("id")int id,
				   @Param("usersId") Integer usersId);

	void setTotalAmount(@Param("id")Integer id, 
						@Param("totalAmountInFen")Integer totalAmountInFen);
}
