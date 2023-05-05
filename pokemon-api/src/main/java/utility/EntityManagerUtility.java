package utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtility {
	
	static public EntityManager getEntityManager(String persistenceName) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceName);
		return factory.createEntityManager();
	}
}
