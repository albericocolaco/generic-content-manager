package br.com.contentmanager.model;

import java.util.List;

import br.com.contentmanager.dto.SystemDTO;
import br.com.contentmanager.exception.BusinessException;

/**
 * 
 * @author alberico.silva
 *
 */
public interface SystemModel {

	/**
	 * Get System By Filter.
	 * @param code
	 * @param name
	 * @param id
	 * @return List<SystemDTO>
	 * @throws BusinessException
	 */
	public List<SystemDTO> getSystens(final String code, final String name, final Long id) throws BusinessException;
}
