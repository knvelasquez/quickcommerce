/**
 * 
 */
package com.quickcommerce.Servicio;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quickcommerce.Repository.UsuarioRepository;
import com.quickcommerce.Respuesta.EntidadRespuesta;
import com.quickcommerce.Solicitud.UsuarioSolicitud;
import com.quickcommerce.model.UsuarioModel;
import com.quickcommerce.config.Tiempo;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Kevin Velásquez
 *
 */
@Service
public class UsuarioServicioImpl implements UsuarioServicio {
	
	//private static final Logger logger = LogManager.getLogger(UsuarioServicio.class);
	
	@Autowired
    private UsuarioRepository usuarioRepository;
	
	@Autowired
    private JwtServicio jwtServicio;
	
	@Autowired
    private CriptografiaServicio criptografiaServicio;
	
	/**
	 * Método utilizado para autenticar un usuario por medio del usuario y contrasenia
	 * debe retornar un Jwt Token con la informacion del usuario autenticado
	 * */
	@Override
	public EntidadRespuesta<String> autenticar(UsuarioSolicitud usuario) {	
		//Realiza el cifrado de la contrasenia
		EntidadRespuesta<String> contraseniaCifrada = criptografiaServicio.cifrar(usuario.getContrasenia());						
		if(contraseniaCifrada.getData()==null) {
			//Envia la contrasenia cifrada
			return contraseniaCifrada;
		}
		//Obtiene la informacion del usuario
		UsuarioModel usuarioModel=usuarioRepository.findByUsernameAndSignpassword(usuario.getUsuario(), contraseniaCifrada.getData());
		//Valida si el usuario resultado es diferente de null
		if(usuarioModel!=null) {
			//Envia la entidad respuesta
			return new EntidadRespuesta<String>(HttpServletResponse.SC_OK,
						"Bienvenido ".concat(usuarioModel.getNombre()),
						jwtServicio.generar(usuarioModel),Tiempo.obtener());											
		}else {
			//Enviar la entidad respuesta indicando que el usuario no ha sido encontrado
			return new EntidadRespuesta<String>(HttpServletResponse.SC_FORBIDDEN,
					"El Usuario o contrasenia indicada son incorrectas.",
					null,Tiempo.obtener());	
		}					
	}	
}
