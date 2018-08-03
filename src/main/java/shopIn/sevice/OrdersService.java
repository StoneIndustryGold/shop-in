package shopIn.sevice;

import java.util.List;
import java.util.Map;

import shopIn.pojo.Orders;
import shopIn.sevice.Exception.AlipaySignatureException;

public interface OrdersService {

	Orders create(Integer usersId, Integer addressId);

	List<Orders> findALl(Integer usersId);

	Orders findOne(int id, Integer usersId);

	String payForm(Integer usersId, Integer id);
		/*支付宝验签
		 * @param paramMap 所有请求参数
		 * @throws AlipaySignatureException 若签名无效
		 * 用到了面向对象的原理，ASE子类继承了父类方法，父类又继承了爷类方法
		 */
	void verifySignature(Map<String, String> paramMap) 
			throws AlipaySignatureException;

}
