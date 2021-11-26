/**
 * 
 */
package com.quickcommerce.Repository;

import java.util.List;

import com.quickcommerce.model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Kevin Velásquez
 *
 */
public interface ProductoRepository extends JpaRepository<ProductoModel,Long>{

	/**
	 * 
	 * 
	 * */
	ProductoModel findByCodeProduct(int code_product);
	
	/**
	 * 
	 * 
	 * */
	//List<ProductoModel> findByNombreContainingIgnoreCase(String nombre);
	
}
