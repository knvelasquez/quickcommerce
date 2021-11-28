/**
 * 
 */
package com.quickcommerce.Respuesta;

import com.google.gson.GsonBuilder;

/**
 * @author Kevin Velásquez
 *
 */
public class EntidadProductDetailRespuesta<E> {
	private E products;

	public EntidadProductDetailRespuesta(E products) {
		this.products = products;
	}

	public E getProducts() {
		return products;
	}

	public void setProducts(E products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}

}
