package shopIn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shopIn.pojo.Cart;
import shopIn.pojo.Item.CartItem;

public interface CartsMapper {
	

	boolean itemExists(@Param("usersId")Integer usersId,//查找方法
			        	@Param("cellponesId")Integer cellponesId);

	void incItemAmount(@Param("usersId")Integer usersId, //跟新
						@Param("cellponesId")Integer cellponesId,
						@Param("amount")int amount);

	void createItem(@Param("usersId")Integer usersId,//添加方法
					@Param("cellponesId")Integer cellponesId,
					@Param("amount")int amount);
	
	List<CartItem> finCartsItems(@Param("usersId")Integer usersId);
	
	boolean seekCarts(@Param("usersId")Integer usersId,//先查找
						@Param("cellponesId")Integer cellponesId);

	void deletCarts(@Param("cellponesId")Integer cellponesId);

	Integer finCarts(@Param("usersId")Integer usersId,
					@Param("cellponesId")Integer cellponesId, 
					@Param("amount")int amount);

	void minusCarts(@Param("usersId")Integer usersId,
					@Param("cellponesId")Integer cellponesId,
					@Param("amount")int amount);
	
	void delete(Integer usersId);

	void updateItemAmount(@Param("userId")Integer userId,
					@Param("cellponesId")Integer cellponesId,
					@Param("amount")	Integer amount);
}
