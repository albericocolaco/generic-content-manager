package br.com.contentmanager.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.contentmanager.converter.SystemConverter;
import br.com.contentmanager.dao.SystemDAO;
import br.com.contentmanager.dto.SystemDTO;
import br.com.contentmanager.exception.BusinessException;

/**
 * 
 * @author alberico.silva
 *
 */
@Component
public class SystemModelImpl implements SystemModel {
	
	@Autowired
	private SystemDAO systemDAO;

	@Override
	public List<SystemDTO> getSystens(final String code, final String name, final Long id) throws BusinessException {
		return SystemConverter.entitoToDTO(systemDAO.findAll());
	}

}
