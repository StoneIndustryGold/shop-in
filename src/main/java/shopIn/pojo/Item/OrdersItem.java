package shopIn.pojo.Item;

import shopIn.pojo.Cellpones;

public class OrdersItem {//订单项
	private Integer ordersId;
	private Cellpones cellpones;
	private Integer ampout;
	
	
	public Integer getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}
	public Cellpones getCellpones() {
		return cellpones;
	}
	public void setCellpones(Cellpones cellpones) {
		this.cellpones = cellpones;
	}
	public Integer getAmpout() {
		return ampout;
	}
	public void setAmpout(Integer ampout) {
		this.ampout = ampout;
	}
	
	
}
