/**
 * 
 */
package com.quickcommerce.Servicio;

import java.util.List;

import com.quickcommerce.model.ProductoModel;
import com.quickcommerce.Respuesta.EntidadRespuesta;
import com.quickcommerce.Solicitud.PostProductoSolicitud;

/**
 * @author Kevin Velásquez
 *
 */
public interface ProductoServicio {
	
	/**
	 * Metodo para Obtener una lista con información
	 * de todos los Súper Héroes encontrados.
	 * */
	public EntidadRespuesta<List<ProductoModel>> consultarTodos();

	/**
	 * Metodo usado para Obtener información de cada Súper Héroe
	 * indicado por medio de un Id.
	 * */
	public EntidadRespuesta<ProductoModel> consultarPorId(int identificacion);

	/**
	 * Metodo usado para Obtener una lista con información
	 * de todos los Súper Héroes que contengan en su nombre el valor indicado.
	 * */
	public EntidadRespuesta<List<ProductoModel>> consultarPorNombreContenga(String nombre);
	
	/**
	 * Metodo usado para Actualizar la información
	 * de un Súper Héroe indicado.
	 * */
	public EntidadRespuesta<ProductoModel> modificar(PostProductoSolicitud postProductoSolicitud);
	
	/**
	 * Metodo usado para Eliminar la información
	 * de un Súper Héroe indicado.
	 * */
	public EntidadRespuesta<ProductoModel> eliminar(int identificacion);

	/**
	 * Metodo usado para Crear un Súper Héroe
	 *
	 */
	public EntidadRespuesta<ProductoModel> crear(PostProductoSolicitud postProductoSolicitud);
}
