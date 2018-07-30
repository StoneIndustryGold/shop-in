package shopIn.sevice.impl;

import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shopIn.mapper.OrdersMapper;
import shopIn.pojo.Address;
import shopIn.pojo.Cart;
import shopIn.pojo.Orders;
import shopIn.pojo.Item.CartItem;
import shopIn.pojo.Item.OrdersItem;
import shopIn.sevice.CartsService;
import shopIn.sevice.OrdersService;
@Service
@Transactional
public class OrdersImpl implements OrdersService {
	private OrdersMapper  ordersMapper;
	
	private CartsService cartsService;
	@Autowired
	public OrdersImpl(OrdersMapper ordersMapper, CartsService cartsService) {
		this.ordersMapper = ordersMapper;
		this.cartsService = cartsService;
	}


	@Override
	public Orders create(Integer usersId, Integer addressId) {
		//订单表
		Orders orders=new Orders();//new个订单实体
		orders.setUserId(usersId);//往里设置当前用户id
		Address address=new Address();//new个地址实体
		address.setId(addressId);//把地址id设置给它
		orders.setAddress(address);//在社往订单--订单拿到了--usersId和adderssId
		orders.setCreatetime(new Date());//往里面设置时间
		
		
		ordersMapper.create(orders);
		//创建订单项表
		//订单项里有-- 用户的id和--商品的id--和数量
		Cart cart=cartsService.fondOneByUserID(usersId);//通过用户id找到了商品项
		for(CartItem cartItem:cart.getItems()) {//得到了购物车
			OrdersItem ordersItem=new OrdersItem();//订单项new过来
			ordersItem.setOrdersId(orders.getId());//这id是从数据库里返回出来的，在上面
			ordersItem.setCellpones(cartItem.getCellpones());//拿到购物车里的商品
			ordersItem.setAmpout(cartItem.getCount());//拿到数量，并设置
			ordersMapper.addItem(ordersItem);//期待mapper有个添加方法 ，
		}
		
		cartsService.delete(usersId);
		return orders;
	}


	@Override
	public List<Orders> findALl(Integer usersId) {
		
		return ordersMapper.findALl(usersId);
	}

}
