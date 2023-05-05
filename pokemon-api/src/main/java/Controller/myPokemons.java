package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import POJO.Pokemon;
import dao.PokemonDaoImp;

@WebServlet("/myPokemons")
public class myPokemons extends HttpServlet{
	
	PokemonDaoImp daoImp = new PokemonDaoImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		List<Pokemon> pokemons = daoImp.getMyPokemons();
		
		req.setAttribute("pokemons", pokemons);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("mypokemons.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pokemonId = Integer.parseInt(req.getParameter("pokemonId"));
		Pokemon pokemon = daoImp.findPokemon(pokemonId);
		daoImp.removePokemon(pokemon);
		
		List<Pokemon> pokemons = daoImp.getMyPokemons();
		req.setAttribute("pokemons", pokemons);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("mypokemons.jsp");
		dispatcher.forward(req, resp);
	}
}
