package br.com.contentmanager;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.com.contentmanager.util.AbstractMongoConfig;

@Configuration
@EnableMongoRepositories(basePackages = {"br.com.contentmanager.dao.mongo" }, mongoTemplateRef = "primaryMongoTemplate")
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoDbConfig extends AbstractMongoConfig {

	@Primary
	@Override
	@Bean(name = "primaryMongoTemplate")
	public MongoTemplate getMongoTemplate() {
		return new MongoTemplate(mongoDbFactory());
	}

}
