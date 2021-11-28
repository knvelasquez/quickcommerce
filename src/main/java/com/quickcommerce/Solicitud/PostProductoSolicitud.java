/**
 * 
 */
package com.quickcommerce.Solicitud;

import com.google.gson.GsonBuilder;
import com.quickcommerce.model.CurrencyEnum;
import com.quickcommerce.model.StatusEnum;

import java.sql.Date;

/**
 * @author Kevin Velásquez
 *
 */

public class PostProductoSolicitud {
	private String nameProduct;
	private String categoryProduct;
	private int priceProduct;
	private CurrencyEnum currency;
	private int stockProduct;
	private Date creation_date_product;
	public StatusEnum statusProduct;
	private String markProduct;

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(String categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

	public int getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(int priceProduct) {
		this.priceProduct = priceProduct;
	}

	public CurrencyEnum getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyEnum currency) {
		this.currency = currency;
	}

	public int getStockProduct() {
		return stockProduct;
	}

	public void setStockProduct(int stockProduct) {
		this.stockProduct = stockProduct;
	}

	public Date getCreation_date_product() {
		return creation_date_product;
	}

	public void setCreation_date_product(Date creation_date_product) {
		this.creation_date_product = creation_date_product;
	}

	public StatusEnum getStatusProduct() {
		return statusProduct;
	}

	public void setStatusProduct(StatusEnum statusProduct) {
		this.statusProduct = statusProduct;
	}

	public String getMarkProduct() {
		return markProduct;
	}

	public void setMarkProduct(String markProduct) {
		this.markProduct = markProduct;
	}

	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}

}
