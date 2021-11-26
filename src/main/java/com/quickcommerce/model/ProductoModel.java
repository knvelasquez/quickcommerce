package com.quickcommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.quickcommerce.enumerado.Color;
import com.quickcommerce.enumerado.Habilidad;

/**
 * @author Kevin Velásquez
 *
 */
@Entity(name = "Producto")
@Table(name = "PRODUCTO")
public class ProductoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@Column(name = "cantidad", nullable = true)
	private int cantidad;

	public ProductoModel() {
	}

	public ProductoModel(int id, String nombre, String descripcion, int cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
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
	 * @param identidadSecreta the identidadSecreta to set
	 */
	public void setDescripcion(String identidadSecreta) {
		this.descripcion = identidadSecreta;
	}

	/**
	 * @return the lugarResidencia
	 */
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}




}