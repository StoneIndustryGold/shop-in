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
		
	}


	
	
	

