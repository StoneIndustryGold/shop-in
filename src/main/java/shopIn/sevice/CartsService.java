package shopIn.sevice;

import java.util.List;

import shopIn.pojo.Cart;
import shopIn.pojo.Item.CartItem;

public interface CartsService {

	

	void addToCart(Integer usersId, Integer cellponesId, int count);

	//List<Carts> finCartsItems(Integer usersId);

	void uptedaCarts(Integer usersId, Integer cellponesId);

	void minusCarts(Integer usersId, Integer cellponesId, int count);

	void uptedaCartsAdd(Integer usersId, Integer cellponesId, int count);

	Cart fondOneByUserID(Integer usersId);//购物车详情--也调用了这个方法---集合去掉了

	void delete(Integer usersId);

	void updateItemCount(Integer userId, Integer cellponesId, Integer count);

	



	

}
