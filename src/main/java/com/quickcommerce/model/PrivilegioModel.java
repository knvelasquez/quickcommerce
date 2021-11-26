/**
 * 
 */
package com.quickcommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kevin Velásquez
 *
 */
@Entity(name = "Privilege")
@Table(name = "privilege")
public class PrivilegioModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_privilege", nullable = false)
	private int id_privilege;
	
	@Column(name = "name_privilege", nullable = false)
	private String name_privilege;
	
	@Column(name = "description_privilege", nullable = false)
	private String description_privilege;

	public int getId_privilege() {
		return id_privilege;
	}

	public void setId_privilege(int id_privilege) {
		this.id_privilege = id_privilege;
	}

	public String getName_privilege() {
		return name_privilege;
	}

	public void setName_privilege(String name_privilege) {
		this.name_privilege = name_privilege;
	}

	public String getDescription_privilege() {
		return description_privilege;
	}

	public void setDescription_privilege(String description_privilege) {
		this.description_privilege = description_privilege;
	}
}
