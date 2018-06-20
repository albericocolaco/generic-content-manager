package br.com.contentmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contentmanager.entity.System;

/**
 * 
 * @author alberico.silva
 *
 */
@Repository
public interface SystemDAO extends JpaRepository<System, Long>  {

}
