package br.com.contentmanager.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;

import br.com.contentmanager.converter.ContentConverter;
import br.com.contentmanager.converter.ContentTypeConverter;
import br.com.contentmanager.converter.SystemConverter;
import br.com.contentmanager.dao.ContentDAO;
import br.com.contentmanager.dto.ContentDTO;
import br.com.contentmanager.dto.ContentTypeDTO;
import br.com.contentmanager.dto.SystemDTO;
import br.com.contentmanager.entity.ContentLiv;
import br.com.contentmanager.exception.BusinessException;
import br.com.contentmanager.specification.ContentSpecification;
import br.com.contentmanager.util.ErrorMessageEnum;

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
		return this.createAndUpdateContent(ContentConverter.dtoToEntity(contentDTO), false);
	}

	@Override
	public ContentDTO updateContent(final ContentDTO contentDTO) throws BusinessException {
		return this.createAndUpdateContent(ContentConverter.dtoToEntity(contentDTO), true);
	}

	@Override
	public void removeContent(final Long id) throws BusinessException {
		this.contentDAO.delete(id);
	}

	@Override
	public List<ContentDTO> findContent(final Long id, final Long dateCreate, final Long dateModify, 
			final String active, final Long contentTypeId, final Long systemId) throws BusinessException {
		final SystemDTO system = new SystemDTO(systemId, null, null);
		final ContentTypeDTO contentTypeDTO = new ContentTypeDTO(contentTypeId, null);
		final ContentDTO contentDTO = new ContentDTO(id, active, null, dateCreate, dateModify, contentTypeDTO, system);
		final List<ContentLiv> result = this.contentDAO.findAll(this.makeFilterForSelectDB(contentDTO));
		if(result == null || result.isEmpty()){
			throw new BusinessException(ErrorMessageEnum.DATA_NOT_FOUND);
		}
		return ContentConverter.entitoToDTO(result);
	}
	
	/**
	 * Build the filter for custom select in DB.
	 * @param contentDTO
	 * @return Specifications<ContentLiv>
	 */
	private Specifications<ContentLiv> makeFilterForSelectDB(final ContentDTO contentDTO){
		Specifications<ContentLiv> spec = Specifications.where(ContentSpecification.oneEqualOne());
		if(contentDTO != null){
			if(contentDTO.getId() != null){
				spec = spec.and(ContentSpecification.andID(contentDTO.getId()));
			}
			if(contentDTO.getDateCreate() != null){
				spec = spec.and(ContentSpecification.andDateCreate(contentDTO.getDateCreate()));
			}
			if(contentDTO.getDateModify() != null){
				spec = spec.and(ContentSpecification.andDateModify(contentDTO.getDateModify()));
			}
			if(contentDTO.getActive() != null){
				spec = spec.and(ContentSpecification.andActive(contentDTO.getActive()));
			}
			if(contentDTO.getContentType() != null && contentDTO.getContentType().getId() != null){
				spec = spec.and(ContentSpecification.andContentType(ContentTypeConverter.dtoToEntity(contentDTO.getContentType())));
			}
			if(contentDTO.getSystem() != null && contentDTO.getSystem().getId() != null){
				spec = spec.and(ContentSpecification.andSystem(SystemConverter.dtoToEntity(contentDTO.getSystem())));
			}
		}
		return spec;
	}
	
	/**
	 * Record and Update content in DB.
	 * @param content
	 * @param isEdit
	 * @return ContentDTO
	 * @throws BusinessException
	 */
	private ContentDTO createAndUpdateContent(final ContentLiv content, final Boolean isEdit) throws BusinessException{
		this.validateRequeredAttributes(content, isEdit);
		if(isEdit){
			final ContentLiv result = this.contentDAO.findById(content.getId());
			if(result != null){
				content.setDateCreate(result.getDateCreate());
			}
			content.setDateModify(new Timestamp(new Date().getTime()));
		} else {
			content.setDateCreate(new Timestamp(new Date().getTime()));
		}
		return ContentConverter.entityToDTO(this.contentDAO.save(content));
	}
	
	/**
	 * Validate Requered Attributes.
	 * @param content
	 * @param isEdit
	 * @throws BusinessException
	 */
	private void validateRequeredAttributes(final ContentLiv content, final Boolean isEdit) throws BusinessException {
		if(content == null){
			throw new BusinessException(ErrorMessageEnum.ATTRIBUTES_REQUIRED_NOT_INFORMED);
		} else {
			this.validateRequeredAttributesSecondPart(content, isEdit);
		}
	}
	
	/**
	 * Validate Requered Attributes Second Part.
	 * @param content
	 * @param isEdit
	 * @throws BusinessException
	 */
	private void validateRequeredAttributesSecondPart(final ContentLiv content, final Boolean isEdit) throws BusinessException {
		if(isEdit && (content.getId() == null || content.getId().equals(0L))){
			throw new BusinessException(ErrorMessageEnum.ATTRIBUTE_REQUIRED_NOT_INFORMED_ID);
		}
		if(content.getContentLiv() == null || content.getContentLiv().isEmpty()){
			throw new BusinessException(ErrorMessageEnum.ATTRIBUTE_REQUIRED_NOT_INFORMED_CONTENT);
		}
		if(content.getSystem() == null || content.getSystem().getId() == null || content.getSystem().getId().equals(0L)){
			throw new BusinessException(ErrorMessageEnum.ATTRIBUTE_REQUIRED_NOT_INFORMED_ID_SYSTEM);
		}
		if(content.getContentType() == null || content.getContentType().getId() == null || content.getContentType().getId().equals(0L)){
			throw new BusinessException(ErrorMessageEnum.ATTRIBUTE_REQUIRED_NOT_INFORMED_ID_CONTENT_TYPE);
		}
		if(content.getActive() == null){
			throw new BusinessException(ErrorMessageEnum.ATTRIBUTE_REQUIRED_NOT_INFORMED_ID_CONTENT_TYPE);
		}
	}

}
