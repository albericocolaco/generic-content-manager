package br.com.contentmanager.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.contentmanager.converter.ContentConverter;
import br.com.contentmanager.dao.ContentDAO;
import br.com.contentmanager.dto.ContentDTO;
import br.com.contentmanager.entity.ContentLiv;
import br.com.contentmanager.exception.BusinessException;

/**
 * 
 * @author alberico.silva
 *
 */
@Component
public class ContentModelImpl implements ContentModel{
	
	@Autowired
	private ContentDAO contentDAO;

	@Override
	public ContentDTO createContent(final ContentDTO contentDTO) throws BusinessException {
		ContentLiv content = ContentConverter.dtoToEntity(contentDTO);
		this.validateRequeredAttributes(content, false);
		content.setDateCreate(new Timestamp(new Date().getTime()));
		content = contentDAO.save(content);
		return ContentConverter.entityToDTO(content);
	}

	@Override
	public ContentDTO updateContent(final ContentDTO contentDTO) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeContent(final Long id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ContentDTO> findContent(final ContentDTO contentDTO) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Validate Requered Attributes.
	 * @param content
	 * @throws BusinessException
	 */
	private void validateRequeredAttributes(final ContentLiv content, final Boolean isEdit) throws BusinessException {
		if(content == null){
			throw new BusinessException(HttpServletResponse.SC_BAD_REQUEST, "Erro na validacao dos campos");
		} else {
			if(isEdit && (content.getId() == null || content.getId().equals(0L))){
				throw new BusinessException(HttpServletResponse.SC_BAD_REQUEST, "Erro na validacao do campo ID");
			}
			if(content.getContentLiv() == null || content.getContentLiv().isEmpty()){
				throw new BusinessException(HttpServletResponse.SC_BAD_REQUEST, "Erro na validacao do campo CONTENT");
			}
			if(content.getSystem() == null || content.getSystem().getId() == null || content.getSystem().getId().equals(0L)){
				throw new BusinessException(HttpServletResponse.SC_BAD_REQUEST, "Erro na validacao do campo ID_SYSTEM");
			}
			if(content.getContentType() == null || content.getContentType().getId() == null || content.getContentType().getId().equals(0L)){
				throw new BusinessException(HttpServletResponse.SC_BAD_REQUEST, "Erro na validacao do campo ID_CONTENT_TYPE");
			}
		}
	}

}
