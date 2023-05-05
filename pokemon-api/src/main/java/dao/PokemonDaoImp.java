package dao;

import POJO.Pokemon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import utility.EntityManagerUtility;

public class PokemonDaoImp {
	
	EntityManager manager = EntityManagerUtility.getEntityManager("MyPersistenceUnit");
	
	public void insertPokemon(Pokemon pokemon) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(pokemon);
		transaction.commit();
	}
}
