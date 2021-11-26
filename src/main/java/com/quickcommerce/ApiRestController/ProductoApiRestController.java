/**
 * 
 */
package com.quickcommerce.ApiRestController;

import com.quickcommerce.Respuesta.EntidadRespuesta;
import com.quickcommerce.Solicitud.ProductoSolicitud;
import com.quickcommerce.model.ProductoModel;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Kevin Velásquez
 *
 */
public interface ProductoApiRestController {
	
	/*@PreAuthorize:Es una anotación más nueva que @Secured (disponible desde la versión 3 de Spring Security) 
	 * mucho más flexible.
	 * Sintaxis: "hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')
	 *
	 */
	@ApiOperation(value = "Este método es usado para Obtener una lista con información de todos los Productos de una compra en la web.")
	//@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_SUPERHEROE_CONSULTARTODOS')")
	@RequestMapping(value="producto",method = RequestMethod.GET)
	public EntidadRespuesta<List<ProductoModel>> consultarTodos();

	@ApiOperation(value = "Este método es usado para Agregar un nuevo Producto a la lista de una compra en la web.")
	//@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_SUPERHEROE_CONSULTARTODOS')")
	@RequestMapping(value="producto",method = RequestMethod.POST)
	public EntidadRespuesta<ProductoModel> crear(@RequestBody ProductoSolicitud productoSolicitud, HttpServletResponse respuesta);

	@ApiOperation(value = "(En Construcción)Este método es usado para Actualizar un Producto de la lista de una compra en la web-")
	//@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_SUPERHEROE_MODIFICAR')")
	@RequestMapping(value="producto",method = RequestMethod.PUT)
	public EntidadRespuesta<ProductoModel> actualizar(@RequestBody ProductoSolicitud productoSolicitud, HttpServletResponse respuesta);

	@ApiOperation(value = "(En Construcción)Este método es usado para Eliminar un Producto de la lista de una compra en la web.")
	//@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_SUPERHEROE_ELIMINAR')")
	@RequestMapping(value="producto/{identificacion}",method = RequestMethod.DELETE)
	public EntidadRespuesta<ProductoModel> eliminar(@PathVariable @NotNull int identificacion,HttpServletResponse respuesta);

	/*@ApiOperation(value = "Este método es usado para Obtener información de cada Súper Héroe indicado por medio de un Id.")
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_SUPERHEROE_CONSULTARPORID')")	
	@RequestMapping(value="superheroe/{identificacion}",method = RequestMethod.GET)
	public EntidadRespuesta<ProductoModel> consultarPorId(@PathVariable @NotNull int identificacion);

	@ApiOperation(value = "Este método es usado para Obtener una lista con información de todos los Súper Héroes que contengan en su nombre el valor indicado.")
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_SUPERHEROE_CONSULTARNOMBRECONTENGA')")	
	@RequestMapping(value="superheroe/nombre/{nombre}",method = RequestMethod.GET)
	public EntidadRespuesta<List<ProductoModel>> consultarPorNombreContenga(@PathVariable @NotNull String nombre);*/
}
