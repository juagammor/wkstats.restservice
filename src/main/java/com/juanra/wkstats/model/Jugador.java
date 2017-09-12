package com.juanra.wkstats.model;

public class Jugador implements Comparable<Jugador>{

	private String clave;
	private String nombre;
	
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int compareTo(Jugador o) {
		return this.nombre.compareTo(o.getNombre());
	}
	
	
}
