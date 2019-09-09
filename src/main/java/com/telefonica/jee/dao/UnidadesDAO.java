package com.telefonica.jee.dao;

import java.util.List;

import com.telefonica.jee.model.Unidades;

/**
 * DAO for employee operations
 * @author root
 * 
 */
public interface UnidadesDAO {
	
	/**
	 * It returns a list of all products
	 * @return
	 */
	List<Unidades> get();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Unidades get(int id);
	
	/**
	 * It saves a Product
	 * @param product
	 * @return true if product is correctly saved or false if there is an error
	 */
	boolean save(Unidades unidades);
	
	/**
	 * 
	 * @param id
	 * @return 
	 */
	boolean delete(int id);
	
	boolean update(Unidades unidades);
}
