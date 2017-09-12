package com.juanra.wkstats.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.juanra.wkstats.dao.JugadorDAO;
import com.juanra.wkstats.model.Jugador;


@Path("/JugadorService")
public class JugadorService {
	
	private JugadorDAO jugadorDAO = new JugadorDAO();
	
	@GET
	@Path("/jugadores")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Jugador> getJugadores() {
		return jugadorDAO.getJugadores();
	}

}
