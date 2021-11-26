/**
 * 
 */
package com.quickcommerce.Servicio;

import com.quickcommerce.model.UsuarioModel;

/**
 * @author Kevin Velásquez
 *
 */
public interface JwtServicio {
	
	/**
	 * 
	 * 
	 * */
	public String generar(UsuarioModel usuario);
	
}
