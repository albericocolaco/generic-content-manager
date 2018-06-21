package br.com.contentmanager.util;

/**
 * 
 * @author alberico.silva
 *
 */
public enum ErrorMessageEnum {

	ATTRIBUTES_REQUIRED_NOT_INFORMED(400,"Atributos obrigatórios não informados"),
	ATTRIBUTE_REQUIRED_NOT_INFORMED_ID(400,"Campo obrigatório não informado - ID"),
	ATTRIBUTE_REQUIRED_NOT_INFORMED_CONTENT(400,"Campo obrigatório não informado - CONTENT"),
	ATTRIBUTE_REQUIRED_NOT_INFORMED_ID_SYSTEM(400,"Campo obrigatório não informado - ID_SYSTEM"),
	ATTRIBUTE_REQUIRED_NOT_INFORMED_ID_CONTENT_TYPE(400,"Campo obrigatório não informado - ID_CONTENT_TYPE"),
	ATTRIBUTE_REQUIRED_NOT_INFORMED_ACTIVE(400,"Campo obrigatório não informado - ACTIVE"),
	DATA_NOT_FOUND(204,"Informações não encontradas");
	
	private Integer httpCode;
	private String message;
	
	private ErrorMessageEnum(final Integer httpCode, final String message){
		this.httpCode = httpCode;
		this.message = message;
	}

	public Integer getHttpCode() {
		return httpCode;
	}

	public String getMessage() {
		return message;
	}
	
	
}
