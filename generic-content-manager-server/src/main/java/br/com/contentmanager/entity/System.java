package br.com.contentmanager.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "SYSTEM" database table.
 * 
 */
@Entity
@Table(name="SYSTEM")
@NamedQuery(name="System.findAll", query="SELECT s FROM System s")
public class System implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SYSTEM_ID_GENERATOR", sequenceName="SYSTEM_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SYSTEM_ID_GENERATOR")
	private Long id;

	private String code;

	private String name;

	//bi-directional many-to-one association to ContentLiv
	@OneToMany(mappedBy="system")
	private List<ContentLiv> contentLivs;

	public System() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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
		contentLiv.setSystem(this);

		return contentLiv;
	}

	public ContentLiv removeContentLiv(ContentLiv contentLiv) {
		getContentLivs().remove(contentLiv);
		contentLiv.setSystem(null);

		return contentLiv;
	}

}