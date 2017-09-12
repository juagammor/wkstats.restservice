package com.juanra.wkstats.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bson.Document;

import com.juanra.wkstats.bbdd.MongoFactory;
import com.juanra.wkstats.model.Jugador;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCursor;

public class JugadorDAO {

	public List<Jugador> getJugadores() {
		//db.estadisticas.aggregate({$group: {_id: {nombre: "$nombre", claveJugador: "$claveJugador"}}})
		MongoFactory factory = new MongoFactory();
		List<Jugador> lista = new ArrayList<Jugador>();
		
		try {
		
			Document d = (new Document()).append("nombre", "$nombre").append("claveJugador", "$claveJugador");
			Document d2 = (new Document()).append("_id", d);
			Document d3 = (new Document()).append("$group", d2);
			
			List<Document> aggrList = new ArrayList<Document>();
			aggrList.add(d3);
			
			AggregateIterable<Document> iter = factory.getCollection().aggregate(aggrList);
			
			MongoCursor<Document> iterator = iter.iterator();
			
			while (iterator.hasNext()) {
				Jugador j = new Jugador();
				Document document = (Document) iterator.next();
				//System.out.println(((Document) document.get("_id")).get("nombre") + " - " + ((Document) document.get("_id")).get("claveJugador"));
				j.setNombre((String) ((Document) document.get("_id")).get("nombre"));
				j.setClave((String) ((Document) document.get("_id")).get("claveJugador"));
				
				lista.add(j);
			}
			
			Collections.sort(lista);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}
		
		return lista;
		
	}
	
	
	public static void main(String[] args) {
		(new JugadorDAO()).getJugadores();
	}
	
}
