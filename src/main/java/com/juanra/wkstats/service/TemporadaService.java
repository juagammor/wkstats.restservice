package com.juanra.wkstats.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.juanra.wkstats.dao.TemporadaDAO;
import com.juanra.wkstats.model.Temporada;


@Path("/TemporadaService")
public class TemporadaService {
	
	TemporadaDAO temporadaDAO = new TemporadaDAO();
	
	@GET
	@Path("/temporadas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Temporada> getTemporadas() {
		return temporadaDAO.getTemporadas();
	}
	
	@GET
	@Path("/temporadasByPlayer/{keyPlayer}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Temporada> getTemporadas(@PathParam("keyPlayer") String keyPlayer) {
		return temporadaDAO.getTemporadas(keyPlayer);
	}
	
}
