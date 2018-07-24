package shopIn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shopIn.pojo.Carts;

public interface CartsMapper {
	

	boolean itemExists(@Param("usersId")Integer usersId,//查找方法
			        	@Param("cellponesId")Integer cellponesId);

	void incItemAmount(@Param("usersId")Integer usersId, //跟新
						@Param("cellponesId")Integer cellponesId,
						@Param("amount")int amount);

	void createItem(@Param("usersId")Integer usersId,//添加方法
					@Param("cellponesId")Integer cellponesId,
					@Param("amount")int amount);
	
	List<Carts> finCartsItems(@Param("usersId")Integer usersId);
	
	boolean seekCarts(@Param("usersId")Integer usersId,//先查找
						@Param("cellponesId")Integer cellponesId);

	void deletCarts(@Param("cellponesId")Integer cellponesId);
}
