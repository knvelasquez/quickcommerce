/**
 * 
 */
package com.quickcommerce.Solicitud;

import com.google.gson.GsonBuilder;

import java.sql.Date;

/**
 * @author Kevin Velásquez
 *
 */
public class PutProductoSolicitud {
	private int code_product;
	private String name_product;
	private String category_product;
	private int price_product;
	private String currency_product;
	private int stock_product;
	private String status_product;
	private Date creation_date_product;

	public int getCode_product() {
		return code_product;
	}

	public void setCode_product(int code_product) {
		this.code_product = code_product;
	}

	public String getName_product() {
		return name_product;
	}

	public void setName_product(String name_product) {
		this.name_product = name_product;
	}

	public String getCategory_product() {
		return category_product;
	}

	public void setCategory_product(String category_product) {
		this.category_product = category_product;
	}

	public int getPrice_product() {
		return price_product;
	}

	public void setPrice_product(int price_product) {
		this.price_product = price_product;
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

	public Date getCreation_date_product() {
		return creation_date_product;
	}

	public void setCreation_date_product(Date creation_date_product) {
		this.creation_date_product = creation_date_product;
	}

	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}

}
