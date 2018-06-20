package br.com.contentmanager.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.contentmanager.dto.SystemDTO;
import br.com.contentmanager.entity.System;

/**
 * 
 * @author alberico.silva
 *
 */
public final class SystemConverter {
	
	/**
	 * Constructor.
	 */
	private SystemConverter(){}

	/**
	 * Mapping DTO to Entity.
	 * @param dto
	 * @return System
	 */
	public static System dtoToEntity(final SystemDTO dto){
		final System result = new System();
		
		result.setCode(dto.getCode());
		result.setId(dto.getId());
		result.setName(dto.getName());
		
		return result;
	}
	
	/**
	 * Mapping Entity to DTO.
	 * @param entity
	 * @return SystemDTO
	 */
	public static SystemDTO entityToDTO(final System entity){
		final SystemDTO result = new SystemDTO();
		
		result.setCode(entity.getCode());
		result.setName(entity.getName());
		result.setId(entity.getId());
		
		return result;
	}
	
	/**
	 * Mapping DTO to Entity.
	 * @param dtos
	 * @return List<System>
	 */
	public static List<System> dtoToEntity(final List<SystemDTO> dtos){
		final List<System> result = new ArrayList<>();
		for (SystemDTO dto : dtos) {
			result.add(dtoToEntity(dto));
		}
		return result;
	}
	
	/**
	 * Mapping DTO to Entity.
	 * @param entitys
	 * @return List<SystemDTO>
	 */
	public static List<SystemDTO> entitoToDTO(final List<System> entitys){
		final List<SystemDTO> result = new ArrayList<>();
		for (System entity : entitys) {
			result.add(entityToDTO(entity));
		}
		return result;
	}
	
}
