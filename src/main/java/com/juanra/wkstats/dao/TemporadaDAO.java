package com.juanra.wkstats.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.juanra.wkstats.bbdd.MongoFactory;
import com.juanra.wkstats.model.Temporada;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCursor;

public class TemporadaDAO {

	public List<Temporada> getTemporadas() {
		List<Temporada> listadoTemporadas = new ArrayList<Temporada>();
		MongoFactory factory = new MongoFactory();
		try {
		
			DistinctIterable<String> cursor = factory.getCollection().distinct("temporada", String.class);
			MongoCursor<String> strCursor = cursor.iterator();
			
			while (strCursor.hasNext()) {
				String temporada = strCursor.next();
				
				Temporada temp = new Temporada();
				temp.setAnyos(temporada);
				
				listadoTemporadas.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}
		
		return listadoTemporadas;
	}
	
	
	public List<Temporada> getTemporadas(String keyPlayer) {
		List<Temporada> listadoTemporadas = new ArrayList<Temporada>();
		MongoFactory factory = new MongoFactory();
		try {
		
			/*Creamos el filtrado por jugador*/
			Document filtrado = new Document(); 
			filtrado.append("claveJugador", keyPlayer);
			
			DistinctIterable<String> cursor = factory.getCollection().distinct("temporada", String.class).filter(filtrado);
			MongoCursor<String> strCursor = cursor.iterator();
			
			while (strCursor.hasNext()) {
				String temporada = strCursor.next();
				
				Temporada temp = new Temporada();
				temp.setAnyos(temporada);
				
				listadoTemporadas.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}
		
		return listadoTemporadas;
	}
	
	
	public static void main(String[] args) {
		List<Temporada> listado = (new TemporadaDAO()).getTemporadas("AA4");
		System.out.println(listado.size());
	}

	
	
	
	
}
