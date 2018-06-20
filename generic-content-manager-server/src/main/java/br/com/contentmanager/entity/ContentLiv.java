package br.com.contentmanager.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the CONTENT_LIV database table.
 * 
 */
@Entity
@Table(name="CONTENT_LIV")
@NamedQuery(name="ContentLiv.findAll", query="SELECT c FROM ContentLiv c")
public class ContentLiv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONTENT_LIV_ID_GENERATOR", sequenceName="CONTENT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTENT_LIV_ID_GENERATOR")
	private Long id;

	private String active;

	@Lob
	@Column(name="CONTENT_LIV")
	private String contentLiv;

	@Column(name="DATE_CREATE")
	private Timestamp dateCreate;

	@Column(name="DATE_MODIFY")
	private Timestamp dateModify;

	//bi-directional many-to-one association to ContentType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CONTENT_TYPE_ID")
	private ContentType contentType;

	//bi-directional many-to-one association to System
	@ManyToOne(fetch=FetchType.LAZY)
	private System system;

	public ContentLiv() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getContentLiv() {
		return this.contentLiv;
	}

	public void setContentLiv(String contentLiv) {
		this.contentLiv = contentLiv;
	}

	public Timestamp getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Timestamp dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Timestamp getDateModify() {
		return this.dateModify;
	}

	public void setDateModify(Timestamp dateModify) {
		this.dateModify = dateModify;
	}

	public ContentType getContentType() {
		return this.contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	public System getSystem() {
		return this.system;
	}

	public void setSystem(System system) {
		this.system = system;
	}

}