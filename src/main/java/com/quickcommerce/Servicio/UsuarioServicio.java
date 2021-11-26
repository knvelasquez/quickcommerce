/**
 * 
 */
package com.quickcommerce.Servicio;

import com.quickcommerce.Respuesta.EntidadRespuesta;
import com.quickcommerce.Solicitud.UsuarioSolicitud;

/**
 * @author Kevin Velásquez
 *
 */
public interface UsuarioServicio {
	/**
	 * 
	 * 
	 * */	
	public EntidadRespuesta<String> autenticar(UsuarioSolicitud usuario);
}
