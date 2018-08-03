package shopIn.sevice.Exception;

public class ServiceException extends RuntimeException {//这父列继承了爷类的方法
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ServiceException(String messahe) {
		super(messahe);	//重写了爷爷类的方法--下面以一样的
	}
	public ServiceException() {}
	
	public ServiceException(String message,Exception cause) {
		super(message,cause);
	}
	public ServiceException(Exception cause) {
		super(cause);
	}
}
