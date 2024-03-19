package blood.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import blood.dto.UserDetails;

@Component
public class Userdao {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	
	
	public void save(UserDetails details) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(details);
		entityTransaction.commit();
	}
	public void update(UserDetails userDetails) {
		//EntityTransaction entityTransaction = entityManager.getTransaction();
		//entityTransaction.begin();
		entityManager.merge(userDetails);
		//entityTransaction.commit();
	}
	
	public UserDetails login(String email) {
		List<UserDetails> details =entityManager.createQuery("select x from UserDetails x where email=?1").setParameter(1, email).getResultList();
		if (details.isEmpty()) {
			return null;
		} else {
			return details.getFirst(); 
		} 
		
	}
	
	public UserDetails fetch(int id) {
		UserDetails userDetails=entityManager.find(UserDetails.class, id);
		return userDetails;
	}
	
 
}

