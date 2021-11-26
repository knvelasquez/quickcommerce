/**
 * 
 */
package com.quickcommerce.Servicio;

import com.quickcommerce.Respuesta.EntidadRespuesta;

/**
 * @author Kevin Velásquez
 *
 */
public interface CriptografiaServicio {

	/**
	 * 
	 * 
	 * */
	public EntidadRespuesta<String> cifrar(String valor);
	
}
