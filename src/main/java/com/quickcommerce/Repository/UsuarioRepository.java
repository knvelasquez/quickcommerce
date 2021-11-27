/**
 * 
 */
package com.quickcommerce.Repository;

import com.quickcommerce.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kevin Velásquez
 *
 */
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	
	/**
	 * Este metodo es usado para obtener un usuario por medio de la identificacion
	 * 
	 * */
	//public UsuarioModel findByiduser(int idUser);

	/**
	 * Este metodo es usado para obtener un usuario por medio del usuario y contrasenia
	 * 
	 * */
	public UsuarioModel findByUsernameAndSignpassword(String username, String sign_password);
}
