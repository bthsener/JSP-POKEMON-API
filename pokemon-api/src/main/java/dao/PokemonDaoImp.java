package dao;

import java.util.List;

import POJO.Pokemon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transaction;
import utility.EntityManagerUtility;

public class PokemonDaoImp {
	
	EntityManager manager = EntityManagerUtility.getEntityManager("MyPersistenceUnit");
	
	public void insertPokemon(Pokemon pokemon) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(pokemon);
		transaction.commit();
	}
	
	public List<Pokemon> getMyPokemons(){
		TypedQuery<Pokemon> query = manager.createQuery("SELECT e FROM Pokemon e", Pokemon.class);
		return query.getResultList();
	}
	
	public void removePokemon(Pokemon pokemon) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.remove(pokemon);
		transaction.commit();
	}
	
	public Pokemon findPokemon(int id) {
		Pokemon pokemon = manager.find(Pokemon.class, id);
		return pokemon;
	}
}
