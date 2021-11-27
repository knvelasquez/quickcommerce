/**
 * 
 */
package com.quickcommerce.Respuesta;

import com.google.gson.GsonBuilder;

/**
 * @author Kevin Velásquez
 *
 */
public class EntidadProductRespuesta<E> {
	private int totalProducts;
	private E products;

	public EntidadProductRespuesta(E products,int totalProduct) {
		this.products = products;
		this.totalProducts =totalProduct;
	}

	public E getProducts() {
		return products;
	}

	public void setProducts(E products) {
		this.products = products;
	}

	public int getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(int totalProducts) {
		this.totalProducts = totalProducts;
	}

	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}

}
