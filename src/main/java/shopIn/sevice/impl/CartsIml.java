package shopIn.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shopIn.mapper.CartsMapper;
import shopIn.pojo.Carts;
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
	public void addToCart(Integer usersId, Integer cellponesId, int amount) {
			
		if (cartsMapper.itemExists(usersId,cellponesId)) {//若购物车中已有该商品,先查找
			cartsMapper.incItemAmount(usersId,cellponesId,amount);//则数量+1
		}else {//否则
			cartsMapper.createItem(usersId,cellponesId,amount);//添加一个新的购物车项
		}
		
	}


	@Override
	public List<Carts> finCartsItems(Integer usersId) {
		
		return cartsMapper.finCartsItems(usersId);
	}

	@Override
	public void uptedaCarts(Integer usersId, Integer cellponesId) {
		//如果没有就返回，你妹的
		if(cartsMapper.seekCarts(usersId, cellponesId)) {//先查找，当前用户是否有购物车，
			cartsMapper.deletCarts(cellponesId);
			System.out.println("有东西");//有就删除购物车相关的id，cartsMapper.deletCarts(cellponesId);
		}
	}

}
