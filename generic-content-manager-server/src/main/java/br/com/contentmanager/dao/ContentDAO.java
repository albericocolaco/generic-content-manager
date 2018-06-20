package br.com.contentmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contentmanager.entity.ContentLiv;

/**
 * 
 * @author alberico.silva
 *
 */
@Repository
public interface ContentDAO extends JpaRepository<ContentLiv, Long> {

}
