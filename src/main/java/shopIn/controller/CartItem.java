package shopIn.controller;

import java.util.List;


import shopIn.pojo.Carts;

public class CartItem {
	private List<Carts> items;

	public CartItem(List<Carts> cartsItems) {
			this.items = cartsItems;
		}
		
		public List<Carts> getItems() {
			return items;
		}
	public int totalCost() {
		int result=0;
		for(Carts c:items) {
			//从对一关系拿到商品，的价格  乘 当前的数量
			result +=c.getCellpones().getPrice() * c.getCount();
		}
		return result;
	}	
}


	
	
	

