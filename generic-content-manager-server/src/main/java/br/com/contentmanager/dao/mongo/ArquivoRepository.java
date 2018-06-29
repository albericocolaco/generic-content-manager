package br.com.contentmanager.dao.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.contentmanager.entity.mongo.Arquivo;

public interface ArquivoRepository extends MongoRepository<Arquivo, String>{

}
