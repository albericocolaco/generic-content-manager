package br.com.contentmanager.exception;

import br.com.contentmanager.dto.BusinessResponse;

/**
 * 
 * @author alberico.silva
 *
 */
public class BusinessException extends Exception {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 2575490946749820660L;
	
	private final BusinessResponse businessResponse;
	
	/**
	 * Generate exception type BysinessException.
	 * @param code
	 * @param mensage
	 */
	public BusinessException(final int code, final String mensage){
		this.businessResponse = new BusinessResponse(code, mensage);
	}
	
	/**
	 * Generate exception type BysinessException by other exception.
	 * @param code
	 * @param mensage
	 * @param cause
	 */
	public BusinessException(final int code, final String mensage, final Throwable cause) {
		super(mensage, cause);
		this.businessResponse = new BusinessResponse(code, mensage);
	}

	/**
	 * Get BussinesResponse.
	 * @return BusinessResponse
	 */
	public BusinessResponse getBusinessResponse() {
		return businessResponse;
	}

}
