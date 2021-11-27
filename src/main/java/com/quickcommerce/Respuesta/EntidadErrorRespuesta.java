/**
 * 
 */
package com.quickcommerce.Respuesta;

import com.google.gson.GsonBuilder;

/**
 * @author Kevin Velásquez
 *
 */
public class EntidadErrorRespuesta {
	private int code;
	private String message;


	public EntidadErrorRespuesta(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}

}
