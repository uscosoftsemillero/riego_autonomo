package com.api.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	// ---------------------------------------------------- mongodb config
	@Override
	protected String getDatabaseName() {
		return "semillero";
	}

	@Override
	protected String getMappingBasePackage() {
		return "io.lishman.springdata.domain";
	}

	// ---------------------------------------------------- MongoTemplate

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoClient(), getDatabaseName());
	}

	@Override
	public MongoClient mongoClient() {
		MongoClientURI uri = new MongoClientURI("mongodb://localhost/semillero");
		MongoClient client = new MongoClient(uri);
		return client;
	}
}
