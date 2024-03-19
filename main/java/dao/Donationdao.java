package blood.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blood.dto.Donations;

@Component
public class Donationdao {

	@Autowired
	EntityManager entityManager;
	public void save(Donations donations) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(donations);
		entityTransaction.commit();
	}
	public void update(Donations donations) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(donations);
		entityTransaction.commit();
	}
	
	
	public List<Donations> fetchAll() {
		List<Donations> donations = entityManager.createQuery("select x from Donations x").getResultList();
		return donations;
	}

	public Donations fetchone(int donation_id) {
		Donations donation = entityManager.find(Donations.class, donation_id);
		return donation;
	}
}
