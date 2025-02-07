package io.coderproblem.journalwithdatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
@EnableTransactionManagement
public class JournalwithdatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalwithdatabaseApplication.class, args);
	}


	@Bean
	public PlatformTransactionManager add(MongoDatabaseFactory dbfactory){
		return new MongoTransactionManager(dbfactory);
	}
}
