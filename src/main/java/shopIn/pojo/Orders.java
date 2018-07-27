package shopIn.pojo;

import java.util.Date;

import javax.xml.crypto.Data;

public class Orders {//订单表
	private Integer id;
    private Integer userId ;//当前用户id
    private Address address;//对一的收货地址表
    private Date createtime;//订单形成的时间
    
    
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
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
    
    
}
