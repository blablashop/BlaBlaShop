package com.telefonica.jee.dao;

import java.util.List;

import com.telefonica.jee.model.Producto;

/**
 * DAO for employee operations
 * 
 * @author root
 * 
 */
public interface ProductoDAO {

	/**
	 * It returns a list of all products
	 * 
	 * @return
	 */
	List<Producto> get();

	/**
	 * 
	 * @param id
	 * @return
	 */
	Producto get(int id);

	/**
	 * It saves a Product
	 * 
	 * @param product
	 * @return true if product is correctly saved or false if there is an error
	 */
	boolean save(Producto product);

	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(int id);

	boolean update(Producto product);
}
