/**
 * 
 */
package com.quickcommerce.ApiRestController;

import com.quickcommerce.Respuesta.EntidadProductRespuesta;
import com.quickcommerce.Respuesta.EntidadRespuesta;
import com.quickcommerce.Solicitud.PostProductoSolicitud;
import com.quickcommerce.Solicitud.PutProductoSolicitud;
import com.quickcommerce.model.ProductoModel;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
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
	 */
	@ApiOperation(value = "Este método es usado para Obtener una lista con información de todos los Productos de una compra en la web.")
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_CONSULTANT') OR hasRole('ROLE_CLIENTS')")
	@RequestMapping(value="products",method = RequestMethod.GET)
	public EntidadProductRespuesta<List<ProductoModel>> consultarTodos();

	@ApiOperation(value = "Este método es usado para Obtener el detalle con informacion de un producto indicado de una compra en la web.")
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_CONSULTANT') OR hasRole('ROLE_CLIENTS')")
	@RequestMapping(value="products/{code_product}",method = RequestMethod.GET)
	public ProductoModel consultarPorId(@PathVariable @NotNull int code_product);


	@ApiOperation(value = "Este método es usado para Agregar un nuevo Producto a la lista de una compra en la web.")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="products",method = RequestMethod.POST)
	public EntidadRespuesta<ProductoModel> crear(@RequestBody PostProductoSolicitud postProductoSolicitud, HttpServletResponse respuesta);

	@ApiOperation(value = "Este método es usado para Actualizar un Producto de la lista de una compra en la web.")
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_ROOT')")
	@RequestMapping(value="products",method = RequestMethod.PUT)
	public EntidadRespuesta<ProductoModel> actualizar(@RequestBody PutProductoSolicitud postProductoSolicitud, HttpServletResponse respuesta);

	@ApiOperation(value = "Este método es usado para Eliminar un Producto de la lista de una compra en la web.")
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_ROOT')")
	@RequestMapping(value="products/{code_product}",method = RequestMethod.DELETE)
	public EntidadRespuesta<ProductoModel> eliminar(@PathVariable @NotNull int code_product,HttpServletResponse respuesta);

	/*
	@ApiOperation(value = "Este método es usado para Obtener una lista con información de todos los Súper Héroes que contengan en su nombre el valor indicado.")
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_SUPERHEROE_CONSULTARNOMBRECONTENGA')")	
	@RequestMapping(value="superheroe/nombre/{nombre}",method = RequestMethod.GET)
	public EntidadRespuesta<List<ProductoModel>> consultarPorNombreContenga(@PathVariable @NotNull String nombre);*/
}
