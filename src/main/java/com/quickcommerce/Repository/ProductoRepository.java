/**
 * 
 */
package com.quickcommerce.Repository;

import java.util.List;

import com.quickcommerce.model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kevin Velásquez
 *
 */
public interface ProductoRepository extends JpaRepository<ProductoModel,Long>{

	/**
	 * 
	 * 
	 * */
	ProductoModel findById(int id);
	
	/**
	 * 
	 * 
	 * */
	List<ProductoModel> findByNombreContainingIgnoreCase(String nombre);
	
}
