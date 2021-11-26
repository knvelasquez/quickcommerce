/**
 * 
 */
package com.quickcommerce.Repository;

import java.util.List;

import com.quickcommerce.model.SuperHeroeModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kevin Velásquez
 *
 */
public interface SuperHeroeRepository extends JpaRepository<SuperHeroeModel,Long>{

	/**
	 * 
	 * 
	 * */
	SuperHeroeModel findById(int id);
	
	/**
	 * 
	 * 
	 * */
	List<SuperHeroeModel> findByNombreContainingIgnoreCase(String nombre);
	
}
