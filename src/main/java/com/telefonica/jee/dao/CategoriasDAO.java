package com.telefonica.jee.dao;

import java.util.List;

import com.telefonica.jee.model.Categorias;


/**
 * DAO for employee operations
 * @author root
 * 
 */
public interface CategoriasDAO {
	
	/**
	 * It returns a list of all products
	 * @return
	 */
	List<Categorias> get();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Categorias get(int id);
	
	/**
	 * It saves a Product
	 * @param product
	 * @return true if product is correctly saved or false if there is an error
	 */
	boolean save(Categorias categorias);
	
	/**
	 * 
	 * @param id
	 * @return 
	 */
	boolean delete(int id);
	
	boolean update(Categorias categorias);
}
