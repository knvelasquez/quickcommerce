/**
 * 
 */
package com.quickcommerce.Servicio;

import java.util.List;

import com.quickcommerce.model.SuperHeroeModel;
import com.quickcommerce.Respuesta.EntidadRespuesta;
import com.quickcommerce.Solicitud.SuperHeroeSolicitud;

/**
 * @author Kevin Velásquez
 *
 */
public interface SuperHeroeServicio {
	
	/**
	 * Metodo para Obtener una lista con información
	 * de todos los Súper Héroes encontrados.
	 * */
	public EntidadRespuesta<List<SuperHeroeModel>> consultarTodos();

	/**
	 * Metodo usado para Obtener información de cada Súper Héroe
	 * indicado por medio de un Id.
	 * */
	public EntidadRespuesta<SuperHeroeModel> consultarPorId(int identificacion);

	/**
	 * Metodo usado para Obtener una lista con información
	 * de todos los Súper Héroes que contengan en su nombre el valor indicado.
	 * */
	public EntidadRespuesta<List<SuperHeroeModel>> consultarPorNombreContenga(String nombre);
	
	/**
	 * Metodo usado para Actualizar la información
	 * de un Súper Héroe indicado.
	 * */
	public EntidadRespuesta<SuperHeroeModel> modificar(SuperHeroeSolicitud superHeroeSolicitud);
	
	/**
	 * Metodo usado para Eliminar la información
	 * de un Súper Héroe indicado.
	 * */
	public EntidadRespuesta<SuperHeroeModel> eliminar(int identificacion);

	/**
	 * Metodo usado para Crear un Súper Héroe
	 *
	 */
	public EntidadRespuesta<SuperHeroeModel> crear(SuperHeroeSolicitud superHeroeSolicitud);
}
