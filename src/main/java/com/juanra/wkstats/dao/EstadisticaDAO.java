package com.juanra.wkstats.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.juanra.wkstats.bbdd.MongoFactory;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;

public class EstadisticaDAO {
	
	public List<Document> getEstadisticas() {
		return getEstadisticas(0);
	}
	
	public List<Document> getEstadisticas(int pagina) {
		List<Document> listadoStat = new ArrayList<Document>();
		MongoFactory factory = new MongoFactory();
		try {
		
			FindIterable<Document> fcursor;
			MongoCursor<Document> docCursor;
			if	(pagina > 0) {

				final int longitud_pagina = 10;
				
				fcursor = factory.getCollection().find().skip((pagina - 1) * longitud_pagina).limit(longitud_pagina);
			} else {
				fcursor = factory.getCollection().find();	
			}
			
			docCursor = fcursor.iterator();
			
			
			while (docCursor.hasNext()) {
				Document doc = docCursor.next();
				
				listadoStat.add(doc);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}
		
		return listadoStat;
	}

}
