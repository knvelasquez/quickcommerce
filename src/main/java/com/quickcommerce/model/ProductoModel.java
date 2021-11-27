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
	private String nameProduct;

	@Column(name = "categoryproduct", nullable = false)
	private String categoryProduct;

	@Column(name = "priceproduct", nullable = true)
	private float priceProduct;

	@Column(name = "currencyproduct", nullable = true)
	private String currency;

	@Column(name = "stockproduct", nullable = true)
	private int stockProduct;

	@Column(name = "statusproduct", nullable = true)
	private String statusProduct;

	@Column(name = "creationdateproduct", nullable = true)
	private String creationProductDate;

	public ProductoModel() {
	}

	public ProductoModel(int id, String nombre, String descripcion, float priceProduct) {
		this.codeProduct = id;
		this.nameProduct = nombre;
		this.categoryProduct = descripcion;
		this.priceProduct = priceProduct;
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
	public String getNameProduct() {
		return nameProduct;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNameProduct(String nombre) {
		this.nameProduct = nombre;
	}

	/**
	 * @return the identidadSecreta
	 */
	public String getCategoryProduct() {
		return categoryProduct;
	}

	/**
	 * @param identidadSecreta the identidadSecreta to set
	 */
	public void setCategoryProduct(String identidadSecreta) {
		this.categoryProduct = identidadSecreta;
	}

	/**
	 * @return the lugarResidencia
	 */
	public float getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(float priceProduct) {
		this.priceProduct = priceProduct;
	}


	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency_product) {
		this.currency = currency_product;
	}

	public int getStockProduct() {
		return stockProduct;
	}

	public void setStockProduct(int stock_product) {
		this.stockProduct = stock_product;
	}

	public String getStatusProduct() {
		return statusProduct;
	}

	public void setStatusProduct(String status_product) {
		this.statusProduct = status_product;
	}

	public String getCreationProductDate() {
		return creationProductDate;
	}

	public void setCreationProductDate(String creation_date_product) {
		this.creationProductDate = creation_date_product;
	}
}