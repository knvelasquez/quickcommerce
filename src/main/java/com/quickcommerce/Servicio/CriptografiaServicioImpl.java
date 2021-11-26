/**
 * 
 */
package com.quickcommerce.Servicio;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import com.quickcommerce.Respuesta.EntidadRespuesta;
import com.quickcommerce.Seguridad.CriptografiaPBKDF2;
import com.quickcommerce.config.Tiempo;
import com.quickcommerce.exception.ExceptionGlobalHandler;

/**
 * @author Kevin Velásquez
 *
 */
@Service
public class CriptografiaServicioImpl implements CriptografiaServicio {

	/**
	 * Método para encriptar cadenas de valores
	 * El algoritmo utilizado es PBKDF2
	 * */
	@Override
	public EntidadRespuesta<String> cifrar(String valor) {
		try {			
			//Encrypta una cadena de valores con el algoritmo PBKDF2
			return new EntidadRespuesta<String>(HttpServletResponse.SC_OK,null,CriptografiaPBKDF2.cifrar(valor),Tiempo.obtener());			 
		} catch (NoSuchAlgorithmException  excepcion) {
			//Envia el detalle de la exepcion a la clase global manejadora
			return new ExceptionGlobalHandler().noSuchAlgorithmException(excepcion).getBody();
		}catch(InvalidKeySpecException excepcion) {
			//Envia el detalle de la exepcion a la clase global manejadora
			return new ExceptionGlobalHandler().invalidKeySpecException(excepcion).getBody();
		}
	}	
}
