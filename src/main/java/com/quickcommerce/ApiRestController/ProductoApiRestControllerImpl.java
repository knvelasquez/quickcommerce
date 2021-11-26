/**
 * 
 */
package com.quickcommerce.ApiRestController;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.quickcommerce.AnotacionPersonalizada.TotalTiempoEjecucion;
import com.quickcommerce.Respuesta.EntidadRespuesta;
import com.quickcommerce.Servicio.SuperHeroeServicio;
import com.quickcommerce.Solicitud.SuperHeroeSolicitud;
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
@Api(tags = "Producto")
public class ProductoApiRestControllerImpl implements ProductoApiRestController {

	private static final Logger logger = LogManager.getLogger(ProductoApiRestController.class);
	
	@Autowired
	private SuperHeroeServicio superHeroeServicio;

	/**
	 * Metodo para Obtener una lista con información
	 * de todos los Súper Héroes encontrados.
	 * */
	@TotalTiempoEjecucion
	@Override
	public EntidadRespuesta<List<ProductoModel>> consultarTodos() {
		logger.info("Iniciando Consulta de Todos los Súper Héroes");
		//logger.debug("@CLAIMS");
		
		EntidadRespuesta<List<ProductoModel>> listaSuperHeroes=superHeroeServicio.consultarTodos();
		
		logger.info("Fin Consulta de Todos de los Súper Héroes");
		logger.debug(listaSuperHeroes.toString());
		return listaSuperHeroes;		
	}

	/**
	 * Metodo para Crear un Súper Héroe.
	 * */
	@Override
	public EntidadRespuesta<ProductoModel> crear(@RequestBody SuperHeroeSolicitud superHeroeSolicitud, HttpServletResponse respuesta) {
		return superHeroeServicio.crear(superHeroeSolicitud);
	}

	/**
	 * Metodo usado para Actualizar la información
	 * de un Súper Héroe indicado.
	 * */
	@Override
	public EntidadRespuesta<ProductoModel> actualizar(SuperHeroeSolicitud superHeroeSolicitud, HttpServletResponse respuesta) {
		logger.info("Iniciando Actualización de Súper Héroe");
		logger.debug(superHeroeSolicitud.toString());

		EntidadRespuesta<ProductoModel> resultado=superHeroeServicio.modificar(superHeroeSolicitud);
		respuesta.setStatus(resultado.getEstatus());

		logger.info("Fin Actualización de Súper Héroe");
		logger.debug(resultado.toString());

		return resultado;
	}

	/**
	 * Metodo usado para Eliminar la información
	 * de un Súper Héroe indicado.
	 * */
	@Override
	public EntidadRespuesta<ProductoModel> eliminar(int identificacion, HttpServletResponse respuesta) {
		logger.info("Iniciando Eliminación de  Súper Héroe");
		logger.debug(String.format("identificacion: %s", identificacion));

		EntidadRespuesta<ProductoModel> resultado=superHeroeServicio.eliminar(identificacion);
		respuesta.setStatus(resultado.getEstatus());

		logger.info("Fin Eliminación de Súper Héroe");
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
