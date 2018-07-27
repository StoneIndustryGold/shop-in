package shopIn.controller.form;

import javax.validation.constraints.NotNull;

public class OrdersForm {
	 @NotNull(message = "请选择收货地址")
	private Integer AddressId;

	public Integer getAddressId() {
		return AddressId;
	}

	public void setAddressId(Integer addressId) {
		AddressId = addressId;
	}
	
	
}
