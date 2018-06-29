package br.com.contentmanager.util;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

import lombok.Data;

@Data
public abstract class AbstractMongoConfig {

	private String host = "localhost";
	private String database = "arquivo-processamento";
	private int port = 27017;

	/*
	 * Method that creates MongoDbFactory Common to both of the MongoDb
	 * connections
	 */
	public MongoDbFactory mongoDbFactory() {
		return new SimpleMongoDbFactory(getMongoClient(), database);
	}

	/*
	 * Method that creates MongoClient
	 */
	private MongoClient getMongoClient() {
		return new MongoClient(host, port);
	}

	/*
	 * Factory method to create the MongoTemplate
	 */
	abstract public MongoTemplate getMongoTemplate();
}
