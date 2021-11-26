package com.quickcommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kevin Velásquez
 *
 */
@Entity(name = "Productd")
@Table(name = "PRODUCTS")
public class ProductoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codeproduct", nullable = false)
	private int codeProduct;

	@Column(name = "nameproduct", nullable = false)
	private String name_product;

	@Column(name = "categoryproduct", nullable = false)
	private String category_product;

	@Column(name = "priceproduct", nullable = true)
	private int price_product;

	@Column(name = "currencyproduct", nullable = true)
	private String currency_product;

	@Column(name = "stockproduct", nullable = true)
	private int stock_product;

	@Column(name = "statusproduct", nullable = true)
	private String status_product;

	@Column(name = "creationdateproduct", nullable = true)
	private String creation_date_product;

	public ProductoModel() {
	}

	public ProductoModel(int id, String nombre, String descripcion, int cantidad) {
		this.codeProduct = id;
		this.name_product = nombre;
		this.category_product = descripcion;
		this.price_product = cantidad;
	}

	public int getCodeProduct() {
		return codeProduct;
	}

	public void setCodeProduct(int codeProduct) {
		this.codeProduct = codeProduct;
	}

	/**
	 * @return the nombre
	 */
	public String getName_product() {
		return name_product;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setName_product(String nombre) {
		this.name_product = nombre;
	}

	/**
	 * @return the identidadSecreta
	 */
	public String getCategory_product() {
		return category_product;
	}

	/**
	 * @param identidadSecreta the identidadSecreta to set
	 */
	public void setCategory_product(String identidadSecreta) {
		this.category_product = identidadSecreta;
	}

	/**
	 * @return the lugarResidencia
	 */
	public int getPrice_product() {
		return price_product;
	}

	public void setPrice_product(int cantidad) {
		this.price_product = cantidad;
	}


	public String getCurrency_product() {
		return currency_product;
	}

	public void setCurrency_product(String currency_product) {
		this.currency_product = currency_product;
	}

	public int getStock_product() {
		return stock_product;
	}

	public void setStock_product(int stock_product) {
		this.stock_product = stock_product;
	}

	public String getStatus_product() {
		return status_product;
	}

	public void setStatus_product(String status_product) {
		this.status_product = status_product;
	}

	public String getCreation_date_product() {
		return creation_date_product;
	}

	public void setCreation_date_product(String creation_date_product) {
		this.creation_date_product = creation_date_product;
	}
}