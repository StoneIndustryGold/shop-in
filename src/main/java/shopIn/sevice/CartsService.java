package shopIn.sevice;

import java.util.List;

import shopIn.pojo.Cart;
import shopIn.pojo.Item.CartItem;

public interface CartsService {

	

	void addToCart(Integer usersId, Integer cellponesId, int amount);

	//List<Carts> finCartsItems(Integer usersId);

	void uptedaCarts(Integer usersId, Integer cellponesId);

	void minusCarts(Integer usersId, Integer cellponesId, int amount);

	void uptedaCartsAdd(Integer usersId, Integer cellponesId, int amount);

	Cart fondOneByUserID(Integer usersId);//购物车详情--也调用了这个方法---集合去掉了

	void delete(Integer usersId);

	

}
