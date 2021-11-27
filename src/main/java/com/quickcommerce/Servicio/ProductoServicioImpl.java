/**
 * 
 */
package com.quickcommerce.Servicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;

import com.quickcommerce.Respuesta.EntidadProductRespuesta;
import com.quickcommerce.Solicitud.PutProductoSolicitud;
import com.quickcommerce.config.Tiempo;
import com.quickcommerce.model.ProductoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quickcommerce.Repository.ProductoRepository;
import com.quickcommerce.Respuesta.EntidadRespuesta;
import com.quickcommerce.Solicitud.PostProductoSolicitud;

/**
 * @author Kevin Velásquez
 */
@Service
public class ProductoServicioImpl implements ProductoServicio {

	@Autowired
	private ProductoRepository productoRepository;

	/**
	 * Metodo para Obtener una lista con información
	 * de todos los Productos de una compra en la web.
	 * */
	@Override
	public EntidadProductRespuesta<List<ProductoModel>> consultarTodos() {
		List<ProductoModel> listaResultado= productoRepository.findByStatusProduct("Active");
		//Envia la entidad respuesta
		return new EntidadProductRespuesta<List<ProductoModel>>(
				listaResultado,
				listaResultado.size()
		);
	}

	/**
	 * Metodo para Agregar un nuevo Producto a la lista
	 * de una compra en la web.
	 * */
	@Override
	public EntidadRespuesta<ProductoModel> crear(PostProductoSolicitud postProductoSolicitud) {
		ProductoModel productoModel=new ProductoModel();
		productoModel.setNameProduct(postProductoSolicitud.getName_product());
		productoModel.setCategoryProduct(postProductoSolicitud.getCategory_product());
		productoModel.setPriceProduct(postProductoSolicitud.getPrice_product());
		productoModel.setCurrency(postProductoSolicitud.getCurrency_product());
		productoModel.setStatusProduct(postProductoSolicitud.getStatus_product());
		productoModel.setStockProduct(postProductoSolicitud.getStock_product());

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss", Locale.ENGLISH);
		String dateInString = "2021-11-26 00:00:00";
		Date date = null;
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		productoModel.setCreationProductDate("2021-11-26 00:00:00");
		productoRepository.save(productoModel);
		//Envia la entidad respuesta
		return new EntidadRespuesta<ProductoModel>(HttpServletResponse.SC_ACCEPTED,
				"El producto ha sido agregado correctamente",productoModel,Tiempo.obtener());
	}

	/**
	 * Metodo usado para Obtener información de cada Súper Héroe
	 * indicado por medio de un Id.
	 * */
	@Override
	public EntidadRespuesta<ProductoModel> consultarPorId(int id) {
		//Envia la entidad respuesta
		return null;
		//return new EntidadRespuesta<ProductoModel>(
		//		HttpServletResponse.SC_OK,
		//		"Súper Héroe encontrado",
		//		productoRepository.findById(id),Tiempo.obtener());
	}

	/**
	 * Metodo usado para Obtener una lista con información
	 * de todos los Súper Héroes que contengan en su nombre el valor indicado.
	 * */
	@Override
	public EntidadRespuesta<List<ProductoModel>> consultarPorNombreContenga(String nombre) {
		return null;
		/*//Obtiene la informacion del servicio
		List<ProductoModel> listaResultado= productoRepository.findByNombreContainingIgnoreCase(nombre);
		//Envia la entidad respuesta
		return new EntidadRespuesta<List<ProductoModel>>(
				HttpServletResponse.SC_OK,
				"Total Súper Héroes encontrados " + listaResultado.size(), 
				listaResultado,Tiempo.obtener());	*/
	}

	/**
	 * Metodo usado para Actualizar la información
	 * de un producto en una comra en la web.
	 * */
	@Override
	public EntidadRespuesta<ProductoModel> modificar(PutProductoSolicitud productoSolicitud) {
		ProductoModel productoModel=null;
		//Valida si se ha indicado una identificacion para el usuario
		if(productoSolicitud.getCode_product()==0) {
			return new EntidadRespuesta<ProductoModel>(HttpServletResponse.SC_NOT_FOUND,
					"El producto no ha sido encontrado",productoModel,Tiempo.obtener());
		}
		//Obtiene la informacion del producto por medio del id indicado
		productoModel= productoRepository.findByCodeProduct(productoSolicitud.getCode_product());

		if(productoModel==null) {
			return new EntidadRespuesta<ProductoModel>(HttpServletResponse.SC_NOT_FOUND,
					"El producto no ha sido encontrado",productoModel,Tiempo.obtener());
		}						
		//Valida que la informacion obtenida para actualizar no sea null
		if(productoSolicitud.getName_product()!=null) {
			productoModel.setNameProduct(productoSolicitud.getName_product());
		}
		if(productoSolicitud.getCategory_product()!=null) {
			productoModel.setCategoryProduct(productoSolicitud.getCategory_product());
		}			
		if(productoSolicitud.getPrice_product()!=0) {
			productoModel.setPriceProduct(productoSolicitud.getPrice_product());
		}

		if(productoSolicitud.getCurrency_product()!=null) {
			productoModel.setCurrency(productoSolicitud.getCurrency_product());
		}
		if(productoSolicitud.getStatus_product()!=null) {
			productoModel.setStatusProduct(productoSolicitud.getStatus_product());
		}
		if(productoSolicitud.getStock_product()!=0) {
			productoModel.setStockProduct(productoSolicitud.getPrice_product());
		}

		//Ejecuta la actualizacion en la base de datos
		productoRepository.save(productoModel);

		//Envia la entidad respuesta
		return new EntidadRespuesta<ProductoModel>(HttpServletResponse.SC_ACCEPTED,
				"El producto ha sido modificado correctamente",productoModel,Tiempo.obtener());

	}

	/**
	 * Metodo usado para Eliminar la información
	 * de un Súper Héroe indicado.
	 * */
	@Override
	public EntidadRespuesta<ProductoModel> eliminar(int codeProduct) {
		ProductoModel productoModel= productoRepository.findByCodeProduct(codeProduct);
		if(productoModel==null) {
			return new EntidadRespuesta<ProductoModel>(HttpServletResponse.SC_NOT_FOUND,
					"Produco no encontrado",productoModel,Tiempo.obtener());
		}	
		productoRepository.delete(productoModel);
		//Envia la entidad respuesta
		return new EntidadRespuesta<ProductoModel>(HttpServletResponse.SC_ACCEPTED,
				"Producto eliminado correctamente",productoModel,Tiempo.obtener());
	}
}
