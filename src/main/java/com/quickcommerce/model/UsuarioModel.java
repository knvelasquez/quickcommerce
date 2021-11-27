/**
 * 
 */
package com.quickcommerce.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Kevin Velásquez
 *
 */
@Entity(name = "Users")
@Table(name = "USERS")
public class UsuarioModel {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iduser", nullable = false)
	private int id_user;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "signpassword", nullable = false)
	private String signpassword;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "apellido", nullable = false)
	private String apellido;
	
	//@ManyToMany()
	@OneToMany(fetch = FetchType.EAGER)
	private List<PrivilegioModel> privilege;

	/**
	 * 
	 */
	public UsuarioModel() {
	}

	/**
	 * @param username
	 */
	public UsuarioModel(String username) {
		this.username = username;
	}

	/**
	 * @param username
	 * @param sign_password
	 */
	public UsuarioModel(String username, String sign_password) {
		this.username = username;
		this.signpassword = sign_password;
	}

	/**
	 * @param username
	 * @param sign_password
	 * @param privilege
	 */
	public UsuarioModel(String username, String sign_password, List<PrivilegioModel> privilege) {
		this.username = username;
		this.signpassword = sign_password;
		this.privilege = privilege;
	}
	
	/**
	 * @param username
	 * @param privilege
	 */
	public UsuarioModel(String username, List<PrivilegioModel> privilege) {
		this.username = username;
		this.privilege = privilege;
	}

	/**
	 * @return the usuario
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the usuario to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the sign_password
	 */
	public String getSignpassword() {
		return signpassword;
	}

	/**
	 * @param sign_password the contrasenia to set
	 */
	public void setSignpassword(String sign_password) {
		this.signpassword = sign_password;
	}	

	/**
	 * @return the id
	 */
	public int getId_user() {
		return id_user;
	}

	/**
	 * @param id the id to set
	 */
	public void setId_user(int id) {
		this.id_user = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the privilegio
	 */
	public List<PrivilegioModel> getPrivilege() {
		return privilege;
	}

	/**
	 * @param privilege the privilegio to set
	 */
	public void setPrivilege(List<PrivilegioModel> privilege) {
		this.privilege = privilege;
	}	
	
}
