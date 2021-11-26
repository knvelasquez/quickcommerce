/**
 * 
 */
package com.quickcommerce.Servicio;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.quickcommerce.config.Tiempo;
import com.quickcommerce.model.ProductoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quickcommerce.Repository.ProductoRepository;
import com.quickcommerce.Respuesta.EntidadRespuesta;
import com.quickcommerce.Solicitud.ProductoSolicitud;

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
	public EntidadRespuesta<List<ProductoModel>> consultarTodos() {
		List<ProductoModel> listaResultado= productoRepository.findAll();
		//Envia la entidad respuesta
		return new EntidadRespuesta<List<ProductoModel>>(
				HttpServletResponse.SC_OK,
				"Total de Productos encontrados "+ listaResultado.size(),
				listaResultado, Tiempo.obtener());
	}

	/**
	 * Metodo para Agregar un nuevo Producto a la lista
	 * de una compra en la web.
	 * */
	@Override
	public EntidadRespuesta<ProductoModel> crear(ProductoSolicitud productoSolicitud) {
		ProductoModel productoModel=new ProductoModel();
		productoModel.setNombre(productoSolicitud.getNombre());
		productoModel.setDescripcion(productoSolicitud.getDescripcion());
		productoModel.setCantidad(productoSolicitud.getCantidad());
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
		return new EntidadRespuesta<ProductoModel>(
				HttpServletResponse.SC_OK,
				"Súper Héroe encontrado", 
				productoRepository.findById(id),Tiempo.obtener());
	}

	/**
	 * Metodo usado para Obtener una lista con información
	 * de todos los Súper Héroes que contengan en su nombre el valor indicado.
	 * */
	@Override
	public EntidadRespuesta<List<ProductoModel>> consultarPorNombreContenga(String nombre) {
		//Obtiene la informacion del servicio
		List<ProductoModel> listaResultado= productoRepository.findByNombreContainingIgnoreCase(nombre);
		//Envia la entidad respuesta
		return new EntidadRespuesta<List<ProductoModel>>(
				HttpServletResponse.SC_OK,
				"Total Súper Héroes encontrados " + listaResultado.size(), 
				listaResultado,Tiempo.obtener());	
	}

	/**
	 * Metodo usado para Actualizar la información
	 * de un Súper Héroe indicado.
	 * */
	@Override
	public EntidadRespuesta<ProductoModel> modificar(ProductoSolicitud productoSolicitud) {
		ProductoModel superHeroeModel=null;
		//Valida si se ha indicado una identificacion para el usuario
		if(productoSolicitud.getId()==0) {
			return new EntidadRespuesta<ProductoModel>(HttpServletResponse.SC_NOT_FOUND,
					"Súper Héroe no encontrado",superHeroeModel,Tiempo.obtener());
		}
		//Obtiene la informacion del super heroe por medio de la identificacion indicada
		superHeroeModel= productoRepository.findById(productoSolicitud.getId());
		if(superHeroeModel==null) {
			return new EntidadRespuesta<ProductoModel>(HttpServletResponse.SC_NOT_FOUND,
					"Súper Héroe no encontrado",superHeroeModel,Tiempo.obtener());
		}						
		//Valida que la informacion obtenida para actualizar no sea null
		if(productoSolicitud.getNombre()!=null) {
			superHeroeModel.setNombre(productoSolicitud.getNombre());
		}
		if(productoSolicitud.getDescripcion()!=null) {
			superHeroeModel.setDescripcion(productoSolicitud.getDescripcion());
		}			
		//if(productoSolicitud.getCantidad()!=null) {
			//superHeroeModel.setCantidad(superHeroeSolicitud.getLugarResidencia());
		//}
		//if(productoSolicitud.getSuperPoder()!=null) {
			//superHeroeModel.setSuperPoder(superHeroeSolicitud.getSuperPoder());
		//}
		//if(productoSolicitud.getLogo()!=null) {
			//superHeroeModel.setLogo(superHeroeSolicitud.getLogo());
		//}
		//if(productoSolicitud.getColor()!=null) {
			//superHeroeModel.setColor(superHeroeSolicitud.getColor());
		//}
		//if(productoSolicitud.getArchiEnemigo()!=null) {
			//superHeroeModel.setArchiEnemigo(superHeroeSolicitud.getArchiEnemigo());
		//}
		//Ejecuta la actualizacion en la base de datos
		productoRepository.save(superHeroeModel);
		//Envia la entidad respuesta
		return new EntidadRespuesta<ProductoModel>(HttpServletResponse.SC_ACCEPTED,
				"Súper Héroe modificado correctamente",superHeroeModel,Tiempo.obtener());		
	}

	/**
	 * Metodo usado para Eliminar la información
	 * de un Súper Héroe indicado.
	 * */
	@Override
	public EntidadRespuesta<ProductoModel> eliminar(int identificacion) {
		ProductoModel superHeroeModel= productoRepository.findById(identificacion);
		if(superHeroeModel==null) {
			return new EntidadRespuesta<ProductoModel>(HttpServletResponse.SC_NOT_FOUND,
					"Súper Héroe no encontrado",superHeroeModel,Tiempo.obtener());
		}	
		productoRepository.delete(superHeroeModel);
		//Envia la entidad respuesta
		return new EntidadRespuesta<ProductoModel>(HttpServletResponse.SC_ACCEPTED,
				"Súper Héroe eliminado correctamente",superHeroeModel,Tiempo.obtener());						
	}
}
