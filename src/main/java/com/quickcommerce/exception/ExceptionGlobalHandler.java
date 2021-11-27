/**
 * 
 */
package com.quickcommerce.exception;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.servlet.http.HttpServletResponse;

import com.quickcommerce.Respuesta.EntidadErrorRespuesta;
import com.quickcommerce.Respuesta.EntidadRespuesta;
import com.quickcommerce.config.Tiempo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

/**
 * @author Kevin Velásquez
 *
 */
@ControllerAdvice
public class ExceptionGlobalHandler {		
	
	/**
	 * 
	 * Método Para Manejar Excepciones En tiempo de Ejecucion
	 * */
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<EntidadErrorRespuesta> runtimeException(RuntimeException excepcion) {
		return new ResponseEntity<>(
				new EntidadErrorRespuesta(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
											  excepcion.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Método Para Manejar Excepciones
	 * 
	 * */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<EntidadErrorRespuesta> exception(Exception excepcion) {
		return new ResponseEntity<>(
				new EntidadErrorRespuesta(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
				    excepcion.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	
	/**
	 * Método Para Manejar Excepciones de Tipo Acceso Denegado
	 * 
	 * */
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<EntidadErrorRespuesta> accessDeniedException(AccessDeniedException excepcion) {
		return new ResponseEntity<>(
				new EntidadErrorRespuesta(HttpServletResponse.SC_UNAUTHORIZED,
						"Acceso denegado, Favor contactar con el administrador"), HttpStatus.UNAUTHORIZED);
	}
	
	/**
	 * Método Para Manejar Excepciones de Tipo Jwt Expirado
	 * 
	 * */
	@ExceptionHandler(ExpiredJwtException.class)
	public  ResponseEntity<EntidadErrorRespuesta> expiredJwtException(ExpiredJwtException excepcion){
		return new ResponseEntity<>(
				new EntidadErrorRespuesta(HttpServletResponse.SC_UNAUTHORIZED,
					"El jwt Token ha expirado, Usted debe autenticarse para generar uno nuevo."), HttpStatus.UNAUTHORIZED);
	}
	
	/**
	 * Método Para Manejar Excepciones de Jwt Mal Formado
	 * 
	 * */
	@ExceptionHandler(MalformedJwtException.class)
	public ResponseEntity<EntidadErrorRespuesta> malFormedException(MalformedJwtException excepcion){
		return new ResponseEntity<>(
				new EntidadErrorRespuesta(HttpServletResponse.SC_UNAUTHORIZED,
					"La cadena JWT está mal formada, revisar que contenga la longitud y la cantidad de carácteres adecuada."), HttpStatus.UNAUTHORIZED);
	}
	
	/**
	 * Método Para Manejar Excepciones de Tipo Encabezado No Encontrado
	 * 
	 * */
	@ExceptionHandler(EncabezadoNoEcontradoExeption.class)
	public ResponseEntity<EntidadErrorRespuesta> encabezadoNoEncontradoException(EncabezadoNoEcontradoExeption excepcion){
		return new ResponseEntity<>(
				new EntidadErrorRespuesta(HttpServletResponse.SC_UNAUTHORIZED,
					excepcion.getMessage()), HttpStatus.UNAUTHORIZED);
	}
	
	/**
	 * Método Para Manejar Excepciones de Tipo Privilegio No Encontrado
	 * 
	 * */
	@ExceptionHandler(PrivilegioNoEcontradoException.class)
	public ResponseEntity<EntidadErrorRespuesta> privilegioNoEncontradoException(PrivilegioNoEcontradoException excepcion){
		return new ResponseEntity<>(
				new EntidadErrorRespuesta(HttpServletResponse.SC_UNAUTHORIZED,
					excepcion.getMessage()), HttpStatus.UNAUTHORIZED);
	}
	
	/**
	 * Método Para Manejar Excepciones de Tipo No existe Algoritmo
	 * 
	 * */
	@ExceptionHandler(NoSuchAlgorithmException.class)
	public ResponseEntity<EntidadErrorRespuesta> noSuchAlgorithmException(NoSuchAlgorithmException excepcion){
		return new ResponseEntity<>(
				new EntidadErrorRespuesta(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
					excepcion.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Método Para Manejar Excepciones de Tipo Clave Iválida en la Especificación
	 * 
	 * */
	@ExceptionHandler(InvalidKeySpecException.class)
	public ResponseEntity<EntidadErrorRespuesta> invalidKeySpecException(InvalidKeySpecException excepcion){
		return new ResponseEntity<>(
				new EntidadErrorRespuesta(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
					excepcion.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
}
