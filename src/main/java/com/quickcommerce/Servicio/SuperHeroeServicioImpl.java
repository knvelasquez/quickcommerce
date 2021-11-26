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
import com.quickcommerce.Repository.SuperHeroeRepository;
import com.quickcommerce.Respuesta.EntidadRespuesta;
import com.quickcommerce.Solicitud.SuperHeroeSolicitud;

/**
 * @author Kevin Velásquez
 */
@Service
public class SuperHeroeServicioImpl implements SuperHeroeServicio {

	@Autowired
	private SuperHeroeRepository superHeroeRepository;

	/**
	 * Metodo para Obtener una lista con información
	 * de todos los Súper Héroes encontrados.
	 * */
	@Override
	public EntidadRespuesta<List<ProductoModel>> consultarTodos() {
		List<ProductoModel> listaResultado=superHeroeRepository.findAll();
		//Envia la entidad respuesta
		return new EntidadRespuesta<List<ProductoModel>>(
				HttpServletResponse.SC_OK,
				"Total de Productos encontrados "+ listaResultado.size(),
				listaResultado, Tiempo.obtener());
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
				superHeroeRepository.findById(id),Tiempo.obtener());				
	}

	/**
	 * Metodo usado para Obtener una lista con información
	 * de todos los Súper Héroes que contengan en su nombre el valor indicado.
	 * */
	@Override
	public EntidadRespuesta<List<ProductoModel>> consultarPorNombreContenga(String nombre) {
		//Obtiene la informacion del servicio
		List<ProductoModel> listaResultado=superHeroeRepository.findByNombreContainingIgnoreCase(nombre);
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
	public EntidadRespuesta<ProductoModel> modificar(SuperHeroeSolicitud superHeroeSolicitud) {
		ProductoModel superHeroeModel=null;
		//Valida si se ha indicado una identificacion para el usuario
		if(superHeroeSolicitud.getIdentificacion()==0) {
			return new EntidadRespuesta<ProductoModel>(HttpServletResponse.SC_NOT_FOUND,
					"Súper Héroe no encontrado",superHeroeModel,Tiempo.obtener());
		}
		//Obtiene la informacion del super heroe por medio de la identificacion indicada
		superHeroeModel=superHeroeRepository.findById(superHeroeSolicitud.getIdentificacion()); 
		if(superHeroeModel==null) {
			return new EntidadRespuesta<ProductoModel>(HttpServletResponse.SC_NOT_FOUND,
					"Súper Héroe no encontrado",superHeroeModel,Tiempo.obtener());
		}						
		//Valida que la informacion obtenida para actualizar no sea null
		if(superHeroeSolicitud.getNombre()!=null) {
			superHeroeModel.setNombre(superHeroeSolicitud.getNombre());
		}
		if(superHeroeSolicitud.getIdentidadSecreta()!=null) {
			superHeroeModel.setDescripcion(superHeroeSolicitud.getIdentidadSecreta());
		}			
		if(superHeroeSolicitud.getLugarResidencia()!=null) {
			//superHeroeModel.setCantidad(superHeroeSolicitud.getLugarResidencia());
		}
		if(superHeroeSolicitud.getSuperPoder()!=null) {
			//superHeroeModel.setSuperPoder(superHeroeSolicitud.getSuperPoder());
		}
		if(superHeroeSolicitud.getLogo()!=null) {
			//superHeroeModel.setLogo(superHeroeSolicitud.getLogo());
		}
		if(superHeroeSolicitud.getColor()!=null) {
			//superHeroeModel.setColor(superHeroeSolicitud.getColor());
		}			
		if(superHeroeSolicitud.getArchiEnemigo()!=null) {
			//superHeroeModel.setArchiEnemigo(superHeroeSolicitud.getArchiEnemigo());
		}											
		//Ejecuta la actualizacion en la base de datos
		superHeroeRepository.save(superHeroeModel);
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
		ProductoModel superHeroeModel=superHeroeRepository.findById(identificacion);
		if(superHeroeModel==null) {
			return new EntidadRespuesta<ProductoModel>(HttpServletResponse.SC_NOT_FOUND,
					"Súper Héroe no encontrado",superHeroeModel,Tiempo.obtener());
		}	
		superHeroeRepository.delete(superHeroeModel);
		//Envia la entidad respuesta
		return new EntidadRespuesta<ProductoModel>(HttpServletResponse.SC_ACCEPTED,
				"Súper Héroe eliminado correctamente",superHeroeModel,Tiempo.obtener());						
	}

	@Override
	public EntidadRespuesta<ProductoModel> crear(SuperHeroeSolicitud superHeroeSolicitud) {
		ProductoModel superHeroeModel=new ProductoModel();
		superHeroeModel.setNombre(superHeroeSolicitud.getNombre());
		//superHeroeModel.setCantidad(superHeroeSolicitud.getLugarResidencia());
		//superHeroeModel.setSuperPoder(superHeroeSolicitud.getSuperPoder());
		//superHeroeModel.setSuperPoder(superHeroeSolicitud.getSuperPoder());
		//superHeroeModel.setLogo(superHeroeSolicitud.getLogo());
		//superHeroeModel.setArchiEnemigo(superHeroeSolicitud.getArchiEnemigo());
		superHeroeModel.setDescripcion(superHeroeSolicitud.getIdentidadSecreta());
		superHeroeRepository.save(superHeroeModel);
		//Envia la entidad respuesta
		return new EntidadRespuesta<ProductoModel>(HttpServletResponse.SC_ACCEPTED,
				"Súper Héroe creado correctamente",superHeroeModel,Tiempo.obtener());
	}
}
