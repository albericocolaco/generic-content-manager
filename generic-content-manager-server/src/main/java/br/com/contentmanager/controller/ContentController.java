package br.com.contentmanager.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.contentmanager.dto.ContentDTO;
import br.com.contentmanager.exception.BusinessException;
import br.com.contentmanager.model.ContentModel;

/**
 * 
 * @author alberico.silva
 *
 */
@RestController
@RequestMapping("/api/content")
public class ContentController {
	
	@Autowired
	private ContentModel contentModel;
	
	/**
	 * Operation of Create Content.
	 * @param httpResponse
	 * @param contentDTO
	 * @return ContentDTO
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContentDTO create(final HttpServletResponse httpResponse, @RequestBody final ContentDTO contentDTO) throws IOException{
		ContentDTO result = null;
		try {
			result = this.contentModel.createContent(contentDTO);
		} catch (BusinessException e) {
			httpResponse.sendError(e.getBusinessResponse().getCode(), e.getBusinessResponse().getMensage());
		}
		return result;
	}
	
	/**
	 * Operation of Update Content.
	 * @param httpResponse
	 * @param contentDTO
	 * @return ContentDTO
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContentDTO update(final HttpServletResponse httpResponse, @RequestBody final ContentDTO contentDTO) throws IOException{
		ContentDTO result = null;
		try {
			result = this.contentModel.updateContent(contentDTO);
		} catch (BusinessException e) {
			httpResponse.sendError(e.getBusinessResponse().getCode(), e.getBusinessResponse().getMensage());
		}
		return result;
	}
	
	/**
	 * Operation of Remove Content.
	 * @param httpResponse
	 * @param id
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(final HttpServletResponse httpResponse, @RequestParam(value = "id", required = true) Long id) throws IOException{
		try {
			this.contentModel.removeContent(id);
		} catch (Exception e) {
			httpResponse.sendError(500, e.getMessage());
		}
	}
}
