package br.com.contentmanager.model;

import java.util.List;

import br.com.contentmanager.dto.ContentDTO;
import br.com.contentmanager.exception.BusinessException;

/**
 * 
 * @author alberico.silva
 *
 */
public interface ContentModel {

	/**
	 * Create content.
	 * @param contentDTO
	 * @return ContentDTO
	 * @throws BusinessException
	 */
	public ContentDTO createContent(final ContentDTO contentDTO) throws BusinessException;
	
	/**
	 * Update content.
	 * @param contentDTO
	 * @return ContentDTO
	 * @throws BusinessException
	 */
	public ContentDTO updateContent(final ContentDTO contentDTO) throws BusinessException;
	
	/**
	 * Remove content.
	 * @param id
	 * @throws BusinessException
	 */
	public void removeContent(final Long id) throws BusinessException;
	
	/**
	 * Find content.
	 * @param id
	 * @param dateCreate
	 * @param dateModify
	 * @param active
	 * @param contentTypeId
	 * @param systemId
	 * @return List<ContentDTO>
	 * @throws BusinessException
	 */
	public List<ContentDTO> findContent(final Long id, final Long dateCreate, final Long dateModify, 
			final String active, final Long contentTypeId, final Long systemId) throws BusinessException;
}
