package com.juanra.wkstats.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.Document;

import com.juanra.wkstats.dao.EstadisticaDAO;


@Path("/EstadisticasService")
public class EstadisticaService {
	
	EstadisticaDAO estadisticaDAO = new EstadisticaDAO();
	
	@GET
	@Path("/estadisticas")
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Document> getEstadisticas() {
		return estadisticaDAO.getEstadisticas();
	}
	
	@GET
	@Path("/estadisticas/{pagina}")
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Document> getEstadisticas(@PathParam("pagina") int pagina) {
		return estadisticaDAO.getEstadisticas(pagina);
	}
	

}
