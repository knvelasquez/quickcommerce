/**
 * 
 */
package com.quickcommerce.ApiRestController;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.quickcommerce.AnotacionPersonalizada.TotalTiempoEjecucion;
import com.quickcommerce.Respuesta.EntidadRespuesta;
import com.quickcommerce.Servicio.ProductoServicio;
import com.quickcommerce.Solicitud.PostProductoSolicitud;
import com.quickcommerce.Solicitud.PutProductoSolicitud;
import com.quickcommerce.model.ProductoModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

/**
 * @author Kevin Velásquez
 *
 */
@RestController
@RequestMapping("/quickcommerce")
@Api(tags = "Products")
public class ProductoApiRestControllerImpl implements ProductoApiRestController {

	private static final Logger logger = LogManager.getLogger(ProductoApiRestController.class);
	
	@Autowired
	private ProductoServicio productoServicio;

	/**
	 * Metodo para Obtener una lista con información
	 * de todos los Productos encontrados.
	 * */
	@TotalTiempoEjecucion
	@Override
	public EntidadRespuesta<List<ProductoModel>> consultarTodos() {
		logger.info("Iniciando Consulta de Todos los productos");
		//logger.debug("@CLAIMS");
		
		EntidadRespuesta<List<ProductoModel>> listaProducto= productoServicio.consultarTodos();
		
		logger.info("Fin Consulta de Todos de los productos");
		logger.debug(listaProducto.toString());
		return listaProducto;
	}

	/**
	 * Metodo para Crear un producto en la lista.
	 * */
	@Override
	public EntidadRespuesta<ProductoModel> crear(@RequestBody PostProductoSolicitud postProductoSolicitud, HttpServletResponse respuesta) {
		return productoServicio.crear(postProductoSolicitud);
	}

	/**
	 * Metodo usado para Actualizar la información
	 * de un producto en una compra web.
	 * */
	@Override
	public EntidadRespuesta<ProductoModel> actualizar(PutProductoSolicitud productoSolicitud, HttpServletResponse respuesta) {
		logger.info("Iniciando Actualización de un producto");
		logger.debug(productoSolicitud.toString());

		EntidadRespuesta<ProductoModel> resultado= productoServicio.modificar(productoSolicitud);
		respuesta.setStatus(resultado.getEstatus());

		logger.info("Fin Actualización de un producto");
		logger.debug(resultado.toString());

		return resultado;
	}

	/**
	 * Metodo usado para Eliminar la información
	 * de un Producto en una compra en la web.
	 * */
	@Override
	public EntidadRespuesta<ProductoModel> eliminar(int code_product, HttpServletResponse respuesta) {
		logger.info("Iniciando Eliminación de un producto");
		logger.debug(String.format("id: %s", code_product));

		EntidadRespuesta<ProductoModel> resultado= productoServicio.eliminar(code_product);
		respuesta.setStatus(resultado.getEstatus());

		logger.info("Fin Eliminación de un producto");
		logger.debug(resultado.toString());
		return resultado;
	}

	/**
	 * Metodo usado para Obtener información de cada Súper Héroe
	 * indicado por medio de un Id.
	 * */	
	/*@Override
	public EntidadRespuesta<ProductoModel> consultarPorId(int identificacion) {
		logger.info("Iniciando Consulta de Súper Héroe Por Identificación");
		logger.debug(String.format("Identificacion: '%s'", identificacion));
		
		EntidadRespuesta<ProductoModel> superHeroe=superHeroeServicio.consultarPorId(identificacion);
		
		logger.info("Fin Consulta de Súper Héroe Por Identificación");
		logger.debug(superHeroe.toString());
		return superHeroe;
	}*/

	/**
	 * Metodo usado para Obtener una lista con información
	 * de todos los Súper Héroes que contengan en su nombre el valor indicado.
	 * */
	/*@Override
	public EntidadRespuesta<List<ProductoModel>> consultarPorNombreContenga(String nombre) {
		logger.info("Iniciando Consulta de Todos los Súper Héroe que en el nombre contengan el valor indicado");
		logger.debug(String.format("Nombre: '%s'", nombre));
		
		EntidadRespuesta<List<ProductoModel>> listSuperHeroes=superHeroeServicio.consultarPorNombreContenga(nombre);
		logger.info("Iniciando Consulta de Todos los Súper Héroe que en el nombre contengan el valor indicado");
		logger.debug(listSuperHeroes.toString());
		
		return listSuperHeroes;
	}*/
}
