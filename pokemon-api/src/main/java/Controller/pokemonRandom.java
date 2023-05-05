package Controller;

import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.util.Iterator;

import Connection.HttpConnection;
import POJO.Pokemon;
import POJO.Stats;
import dao.PokemonDaoImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/randomPokemon")
public class pokemonRandom extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int randomPokeId = (int) (Math.random()*100);
	
		HttpConnection connection = new HttpConnection(String.valueOf(randomPokeId));
		Pokemon pokemon = connection.getJson();
		String imgUrl = pokemon.getSprites().getFrontDefault();
		int attack = 0, defense = 0, hp = 0;
		
		for(Stats stats : pokemon.getStats()) {
			if (stats.getStat().getName().equals("attack")) {
				attack = stats.getBase_stat();
			}else if (stats.getStat().getName().equals("defense")) {
				defense = stats.getBase_stat();
			}else if (stats.getStat().getName().equals("hp")) {
				hp = stats.getBase_stat();
			}
		}
		
		URI uri = URI.create(imgUrl);
		
		req.setAttribute("attack", attack);
		req.setAttribute("defense", defense);
		req.setAttribute("hp", hp);
		req.setAttribute("imageUrl", uri);
		req.setAttribute("id", pokemon.getId());
		req.setAttribute("name", pokemon.getName());

		req.getSession().setAttribute("pokemon", pokemon); 
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
		dispatcher.forward(req, resp);
	}
}
