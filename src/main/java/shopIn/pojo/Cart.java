package shopIn.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import shopIn.pojo.Item.CartItem;

public class Cart {//这是购物车项
	private List<CartItem> items;

	public Cart(List<CartItem> cartsItems) {
			this.items = cartsItems;
		}
		
		public List<CartItem> getItems() {
			return items;
		}
	@JsonProperty("totalCost")
	public int totalCost() {
		int result=0;
		for(CartItem c:items) {
			//从对一关系拿到商品，的价格  乘 当前的数量
			result +=c.getCellpones().getPrice() * c.getCount();
		}
		return result;
	}	
}


	
	
	

