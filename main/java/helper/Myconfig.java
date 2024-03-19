package blood.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "blood")
public class Myconfig {
	
	@Bean
	public EntityManager getEM() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(null);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

}
