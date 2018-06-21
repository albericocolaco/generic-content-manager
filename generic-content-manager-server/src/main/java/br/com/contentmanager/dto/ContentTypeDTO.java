package br.com.contentmanager.dto;

import java.io.Serializable;

/**
 * 
 * @author alberico.silva
 *
 */
public class ContentTypeDTO implements Serializable{

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -7145794608609978369L;
	
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ContentTypeDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public ContentTypeDTO() {
		super();
	}
	
	
}
