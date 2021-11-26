/**
 * 
 */
package com.quickcommerce.Solicitud;

import com.google.gson.GsonBuilder;

/**
 * @author Kevin Velásquez
 *
 */
public class PutProductoSolicitud {
	private int id;
	private String nombre;
	private String descripcion;
	private int cantidad;

	/**
	 * @return the nombre
	 */
	public int getId() {
		return id;
	}

	/**
	 * set the nombre
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the identidadSecreta
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the identidadSecreta to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the lugarResidencia
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the lugarResidencia to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}

}
