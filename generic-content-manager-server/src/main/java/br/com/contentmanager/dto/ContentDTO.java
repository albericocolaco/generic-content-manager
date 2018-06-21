package br.com.contentmanager.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @author alberico.silva
 *
 */
public class ContentDTO implements Serializable{

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 8035705940226050005L;
	
	private Long id;
	private String active;
	private String contentLiv;
	private Timestamp dateCreate;
	private Timestamp dateModify;
	private ContentTypeDTO contentType;
	private SystemDTO system;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getContentLiv() {
		return contentLiv;
	}
	public void setContentLiv(String contentLiv) {
		this.contentLiv = contentLiv;
	}
	public Timestamp getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(Timestamp dateCreate) {
		this.dateCreate = dateCreate;
	}
	public Timestamp getDateModify() {
		return dateModify;
	}
	public void setDateModify(Timestamp dateModify) {
		this.dateModify = dateModify;
	}
	public ContentTypeDTO getContentType() {
		return contentType;
	}
	public void setContentType(ContentTypeDTO contentType) {
		this.contentType = contentType;
	}
	public SystemDTO getSystem() {
		return system;
	}
	public void setSystem(SystemDTO system) {
		this.system = system;
	}
	
	public ContentDTO(Long id, String active, String contentLiv, Long dateCreate, Long dateModify,
			ContentTypeDTO contentType, SystemDTO system) {
		super();
		this.id = id;
		this.active = active;
		this.contentLiv = contentLiv;
		this.dateCreate = dateCreate == null ? null : new Timestamp(dateCreate);
		this.dateModify = dateModify == null ? null : new Timestamp(dateModify);
		this.contentType = contentType;
		this.system = system;
	}
	public ContentDTO() {
		super();
	}
	

}
