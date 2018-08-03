package shopIn.pojo;

import java.util.Date;
import java.util.List;

import shopIn.OrderState;
import shopIn.pojo.Item.OrdersItem;

public class Orders {//订单表
	private Integer id;
    private Integer userId ;//当前用户id
    private Address address;//对一的收货地址表
    private Date createtime;//订单形成的时间
    private OrderState state;//每局类型的状态
    private Integer totalAmount;//用来放总金额的列
    
    private List<OrdersItem> ordersitem;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Date getCreatetime() {
		return createtime;
	}
	
	public OrderState getState() {
		return state;
	}
	public void setState(OrderState state) {
		this.state = state;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public List<OrdersItem> getOrdersitem() {
		return ordersitem;
	}
	public void setOrdersitem(List<OrdersItem> ordersitem) {
		this.ordersitem = ordersitem;
	}
	
    public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer totalCost() {//方法名
    	Integer result = 0;//容器
        for (OrdersItem item : ordersitem) {//遍历订单项
            result += item.getCellpones().getPrice()*item.getAmpout();//得到订单项里的数据
        }
        return result;//返回
    }
    
	public String stateText() {
        switch (state) {
        case Created:
            return "待支付";
            
        case Paid:
            return "待发货";
            
        case Shipped:
            return "已发货";
            
        case Delivered:
            return "已送达";
            
        case Commented:
            return "已评论";
            
        case Canceled:
            return "已取消";

        default:
            return "?" + state;
        }
    }
}
