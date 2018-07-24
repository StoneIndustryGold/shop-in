package shopIn.sevice;

import java.util.List;

import shopIn.pojo.Carts;

public interface CartsService {

	

	void addToCart(Integer usersId, Integer cellponesId, int amount);

	List<Carts> finCartsItems(Integer usersId);

	void uptedaCarts(Integer usersId, Integer cellponesId);

	void minusCarts(Integer usersId, Integer cellponesId, int amount);

	void uptedaCartsAdd(Integer usersId, Integer cellponesId, int amount);

	

}
