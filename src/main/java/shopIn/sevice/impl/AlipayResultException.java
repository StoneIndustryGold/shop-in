package shopIn.sevice.impl;

import shopIn.sevice.Exception.ServiceException;

public class AlipayResultException extends ServiceException {
	public AlipayResultException(String message) {
		super(message);
	}
}
