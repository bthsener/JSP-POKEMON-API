package Controller;

import java.io.IOException;
import java.io.Writer;
import java.net.URI;

import Connection.HttpConnection;
import POJO.Pokemon;
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
		URI uri = URI.create(imgUrl);
		
		req.getSession().setAttribute("imageUrl", uri);
		req.getSession().setAttribute("id", pokemon.getId());
		req.getSession().setAttribute("name", pokemon.getName());
		
		resp.sendRedirect("home.jsp");
	}
}
