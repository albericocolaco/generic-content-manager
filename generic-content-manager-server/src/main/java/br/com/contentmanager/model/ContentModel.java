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
	 * @param contentDTO
	 * @return List<ContentDTO>
	 * @throws BusinessException
	 */
	public List<ContentDTO> findContent(final ContentDTO contentDTO) throws BusinessException;
}
