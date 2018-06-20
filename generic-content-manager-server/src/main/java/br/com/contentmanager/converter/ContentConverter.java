package br.com.contentmanager.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.contentmanager.dto.ContentDTO;
import br.com.contentmanager.entity.ContentLiv;

/**
 * 
 * @author alberico.silva
 *
 */
public final class ContentConverter {
	
	/**
	 * Construct.
	 */
	private ContentConverter(){}
	
	/**
	 * Mapping DTO to Entity.
	 * @param dto
	 * @return ContentLiv
	 */
	public static ContentLiv dtoToEntity(final ContentDTO dto){
		final ContentLiv entity = new ContentLiv();
		entity.setActive(dto.getActive());
		entity.setContentLiv(dto.getContentLiv());
		entity.setContentType(ContentTypeConverter.dtoToEntity(dto.getContentType()));
		entity.setDateCreate(dto.getDateCreate());
		entity.setDateModify(dto.getDateModify());
		entity.setId(dto.getId());
		entity.setSystem(SystemConverter.dtoToEntity(dto.getSystem()));
		return entity;
	}
	
	/**
	 * Mapping Entity to DTO.
	 * @param entity
	 * @return ContentDTO
	 */
	public static ContentDTO entityToDTO(final ContentLiv entity){
		final ContentDTO dto = new ContentDTO();
		dto.setActive(entity.getActive());
		dto.setContentLiv(entity.getContentLiv());
		dto.setContentType(ContentTypeConverter.entityToDTO(entity.getContentType()));
		dto.setDateCreate(entity.getDateCreate());
		dto.setDateModify(entity.getDateModify());
		dto.setId(entity.getId());
		dto.setSystem(SystemConverter.entityToDTO(entity.getSystem()));
		return dto;
	}
	
	/**
	 * Mapping DTO to Entity.
	 * @param dtos
	 * @return List<ContentLiv>
	 */
	public static List<ContentLiv> dtoToEntity(final List<ContentDTO> dtos){
		final List<ContentLiv> result = new ArrayList<>();
		for(ContentDTO content: dtos){
			result.add(dtoToEntity(content));
		}
		return result;
	}
	
	/**
	 * Mapping Entity to DTO.
	 * @param entitys
	 * @return List<ContentDTO>
	 */
	public static List<ContentDTO> entitoToDTO(final List<ContentLiv> entitys){
		final List<ContentDTO> result = new ArrayList<>();
		for(ContentLiv content: entitys){
			result.add(entityToDTO(content));
		}
		return result;
	}

}
