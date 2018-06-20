package br.com.contentmanager.dto;

import java.io.Serializable;

/**
 * 
 * @author alberico.silva
 *
 */
public class SystemDTO implements Serializable {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 3938544301724077085L;
	
	private Long id;
	private String code;
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
