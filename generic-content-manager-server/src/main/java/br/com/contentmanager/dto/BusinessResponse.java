package br.com.contentmanager.dto;

import java.io.Serializable;

/**
 * 
 * @author alberico.silva
 *
 */
public class BusinessResponse implements Serializable{

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 2238572714750891369L;

	private int code;
	private String mensage;

	public BusinessResponse(final int code, final String mensage) {
		super();
		this.code = code;
		this.mensage = mensage;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMensage() {
		return mensage;
	}

	public void setMensage(String mensage) {
		this.mensage = mensage;
	}
	
	
}
