package shopIn.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shopIn.mapper.CartsMapper;
import shopIn.pojo.Cart;
import shopIn.pojo.Item.CartItem;
import shopIn.sevice.CartsService;
@Service
@Transactional
public class CartsIml implements CartsService {
	private CartsMapper cartsMapper;
	
	@Autowired
	public CartsIml(CartsMapper cartsMapper) {
		this.cartsMapper = cartsMapper;
	}

	@Override
	public void addToCart(Integer usersId, Integer cellponesId, int count) {
			
		if (cartsMapper.itemExists(usersId,cellponesId)) {//若购物车中已有该商品,先查找
			cartsMapper.incItemCount(usersId,cellponesId,count);//则数量+1
		}else {//否则
			cartsMapper.createItem(usersId,cellponesId,count);//添加一个新的购物车项
		}
		
	}


	private List<CartItem> finCartsItems(Integer usersId) {//属性私有了，只有当前得类可以调用
		
		return cartsMapper.finCartsItems(usersId);
	}

	@Override
	public void uptedaCarts(Integer usersId, Integer cellponesId) {//取消购物
		if(cartsMapper.seekCarts(usersId, cellponesId)) {//先查找，当前用户是否有购物车，
			cartsMapper.deletCarts(cellponesId);
			System.out.println("有东西");//有就删除购物车相关的id，cartsMapper.deletCarts(cellponesId);
		}
	}

	@Override
	public void minusCarts(Integer usersId, Integer cellponesId,int amount) {//减去购物数量
			Integer a=cartsMapper.finCarts(usersId, cellponesId,amount);
			if(a==1 || a==null) {
				cartsMapper.deletCarts(cellponesId);//删除
				
			}else {
				cartsMapper.minusCarts(usersId,cellponesId,amount);//则数量-1
				
			}
		
	}

	@Override
	public void uptedaCartsAdd(Integer usersId, Integer cellponesId, int amount) {
	
			cartsMapper.incItemCount(usersId, cellponesId, amount);//调用添加方法进行 加1		
	
	}

	@Override
	public Cart fondOneByUserID(Integer usersId) {
		
		return new Cart(finCartsItems(usersId));//调用了上面的私有方法，再往Service返回，查到的数据
	}

	@Override
	public void delete(Integer usersId) {
		cartsMapper.delete(usersId);
		
	}

	@Override
	public void updateItemCount(Integer userId, Integer cellponesId, Integer amount) {		  
		        if (amount <= 0) {
		            throw new IllegalArgumentException("购物车项的数量必须大于0");
		        }
		        cartsMapper.updateItemCount(userId, cellponesId, amount);
		
		
	}


}
