package shopIn.sevice.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
//当有人篡改数据时（报错异常400---打印签名无效）
@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason = "签名无效")
public class AlipaySignatureException extends ServiceException {//继承自己的父类
	/**
	 * 这里是异常类，为什么要继承那么多次，可能是为了签名无效，这段话显示在页面吧
	 */
	private static final long serialVersionUID = 1L;//这个没用
	public AlipaySignatureException(Exception cause) {
		super(cause);//重写父类方法
	}
	public AlipaySignatureException() {};//重写父类方法
}
