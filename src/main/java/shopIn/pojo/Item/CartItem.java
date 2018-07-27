package shopIn.pojo.Item;

import shopIn.pojo.Cellpones;

public class CartItem {//这是购物车
  
   private Integer count; //购物数量
   
   private Cellpones cellpones;//一个购物车有多个商品

public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}
public Cellpones getCellpones() {
	return cellpones;
}
public void setCellpones(Cellpones cellpones) {
	this.cellpones = cellpones;
}

   
}
