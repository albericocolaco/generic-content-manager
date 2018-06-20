package br.com.contentmanager.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.contentmanager.dto.ContentTypeDTO;
import br.com.contentmanager.entity.ContentType;

/**
 * 
 * @author alberico.silva
 *
 */
public final class ContentTypeConverter {

	/**
	 * Construct.
	 */
	private ContentTypeConverter(){}
	
	/**
	 * Mapping DTO to Entity.
	 * @param dto
	 * @return ContentType
	 */
	public static ContentType dtoToEntity(final ContentTypeDTO dto){
		final ContentType entity = new ContentType();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}
	
	/**
	 * Mapping Entity to DTO.
	 * @param entity
	 * @return ContentTypeDTO
	 */
	public static ContentTypeDTO entityToDTO(final ContentType entity){
		final ContentTypeDTO dto = new ContentTypeDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}
	
	/**
	 * Mapping DTO to Entity.
	 * @param dto
	 * @return List<ContentType>
	 */
	public static List<ContentType> dtoToEntity(final List<ContentTypeDTO> dtos){
		final List<ContentType> result = new ArrayList<>();
		for(ContentTypeDTO dto: dtos){
			result.add(dtoToEntity(dto));
		}
		return result;
	}
	
	/**
	 * Mapping Entity to DTO.
	 * @param entity
	 * @return List<ContentTypeDTO>
	 */
	public static List<ContentTypeDTO> entityToDTO(final List<ContentType> entitys){
		List<ContentTypeDTO> result = new ArrayList<>();
		for(ContentType entity: entitys){
			result.add(entityToDTO(entity));
		}
		return result;
	}
}
