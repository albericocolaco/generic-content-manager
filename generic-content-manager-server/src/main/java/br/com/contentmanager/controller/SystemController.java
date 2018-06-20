package br.com.contentmanager.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.contentmanager.dto.SystemDTO;
import br.com.contentmanager.exception.BusinessException;
import br.com.contentmanager.model.SystemModel;

/**
 * 
 * @author alberico.silva
 *
 */
@RestController
@RequestMapping("/api/system")
public class SystemController {
	
	@Autowired
	private SystemModel systemModel;
	
	
	/**
	 * Get Systens
	 * @param response
	 * @param name
	 * @param code
	 * @param id
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SystemDTO> getSystens (final HttpServletResponse response,
									  @RequestParam(value="name", required = false) final String name,
									  @RequestParam(value="code", required = false) final String code,
									  @RequestParam(value="id", required = false) final Long id) throws IOException{
		List<SystemDTO> result = new ArrayList<>();
		try {
			result = systemModel.getSystens(code, name, id);
		} catch (BusinessException e) {
			response.sendError(e.getBusinessResponse().getCode(), e.getBusinessResponse().getMensage());
		}
		return result;
	}

}
