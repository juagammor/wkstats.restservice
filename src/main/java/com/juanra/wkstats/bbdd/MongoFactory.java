package com.juanra.wkstats.bbdd;

import java.util.ResourceBundle;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoFactory {
	
	private MongoClient client;
	
	public MongoFactory() {}
	
	public MongoCollection<Document> getCollection() {
		ResourceBundle bundle = ResourceBundle.getBundle("com/juanra/wkstats/config/database");
		
		//Datos de conexion para el cliente
		String host = bundle.getString("mongodb.url");
		int port = 0;
		try {
			port = new Integer(bundle.getString("mongodb.port"));
		} catch (Exception ex) {
			//pongo el puerto por defecto
			port = 27017;
		}
				
		client = new MongoClient(host, port);
		MongoDatabase db = client.getDatabase(bundle.getString("mongodb.db"));
		
		return db.getCollection(bundle.getString("mongodb.collection"));
	}
	
	public void close() {
		client.close();
	}

	public MongoClient getClient() {
		return client;
	}

	public void setClient(MongoClient client) {
		this.client = client;
	}
	

}
