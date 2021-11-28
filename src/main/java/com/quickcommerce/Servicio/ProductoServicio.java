/**
 * 
 */
package com.quickcommerce.Servicio;

import java.util.List;

import com.quickcommerce.Respuesta.EntidadProductRespuesta;
import com.quickcommerce.Solicitud.PutProductoSolicitud;
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
	 * de todos los Productos de una compra en la web.
	 * */
	public EntidadProductRespuesta<List<ProductoModel>> consultarTodos();

	/**
	 * Metodo para Obtener informacion detalle con informacion
	 * de un producto indicado de una compra en la web.
	 * */
	public ProductoModel consultarPorCodeProduct(int codeProduct);

	/**
	 * Metodo usado para Agregar un nuevo
	 * Producto a la lista de una compra en la web.
	 *
	 */
	public EntidadRespuesta<ProductoModel> crear(PostProductoSolicitud postProductoSolicitud);

	/**
	 * Metodo usado para Actualizar la información
	 * de un Producto de la lista de una compra en la web.
	 * */
	public EntidadRespuesta<ProductoModel> modificar(PutProductoSolicitud productoSolicitud);

	/**
	 * Metodo usado para Eliminar la información
	 * de un Producto de la lista en una compra en la web.
	 * */
	public EntidadRespuesta<ProductoModel> eliminar(int identificacion);

}
