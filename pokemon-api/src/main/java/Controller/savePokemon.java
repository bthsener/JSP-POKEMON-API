package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import POJO.Pokemon;
import dao.PokemonDaoImp;

@WebServlet("/savePokemon")
public class savePokemon extends HttpServlet{ 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Pokemon pokemon = (Pokemon) req.getSession().getAttribute("pokemon");
		
		PokemonDaoImp daoImp = new PokemonDaoImp();
		daoImp.insertPokemon(pokemon);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/randomPokemon");
		dispatcher.forward(req, resp);
	}
}
