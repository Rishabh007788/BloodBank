package blood.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blood.dto.Requests;
import blood.dto.UserDetails;

@Component
public class Requestdao {
	
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	
	public void save(Requests requests) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(requests);
		entityTransaction.commit();
	}
	
	public void update(Requests requests) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(requests);
		entityTransaction.commit();
	}
	
	public Requests fetchOne(int id) {
		Requests requests=entityManager.find(Requests.class, id);
		return requests;
	}
	
	public List<Requests> fetchall() {
		List<Requests> requests=entityManager.createQuery("select x from Requests x").getResultList();
		return requests;
	}
}

