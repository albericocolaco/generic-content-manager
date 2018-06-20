package br.com.contentmanager.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CONTENT_TYPE database table.
 * 
 * @author alberico.silva
 * 
 */
@Entity
@Table(name="CONTENT_TYPE")
@NamedQuery(name="ContentType.findAll", query="SELECT c FROM ContentType c")
public class ContentType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONTENT_TYPE_ID_GENERATOR", sequenceName="CONTENT_TYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTENT_TYPE_ID_GENERATOR")
	private Long id;

	private String name;

	//bi-directional many-to-one association to ContentLiv
	@OneToMany(mappedBy="contentType")
	private List<ContentLiv> contentLivs;

	public ContentType() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ContentLiv> getContentLivs() {
		return this.contentLivs;
	}

	public void setContentLivs(List<ContentLiv> contentLivs) {
		this.contentLivs = contentLivs;
	}

	public ContentLiv addContentLiv(ContentLiv contentLiv) {
		getContentLivs().add(contentLiv);
		contentLiv.setContentType(this);

		return contentLiv;
	}

	public ContentLiv removeContentLiv(ContentLiv contentLiv) {
		getContentLivs().remove(contentLiv);
		contentLiv.setContentType(null);

		return contentLiv;
	}

}