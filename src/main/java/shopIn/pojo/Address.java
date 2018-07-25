package shopIn.pojo;


import javax.validation.constraints.Size;

public class Address {//收货地址表
	 private Integer id;
	 @Size(max=30,min=1, message="1~30")
     private String consigneeName;//--收货人姓名
	 @Size(max=30,min=4, message="4~30")
     private String phone;//--电话号码
	 @Size(min=3,message="最少两个")
     private String detailsAddress;//--详情地址
     
     private Integer users;//--关联用户id
     
     
     
     
	public Integer getUsers() {
		return users;
	}
	public void setUsers(Integer users) {
		this.users = users;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDetailsAddress() {
		return detailsAddress;
	}
	public void setDetailsAddress(String detailsAddress) {
		this.detailsAddress = detailsAddress;
	}

}
