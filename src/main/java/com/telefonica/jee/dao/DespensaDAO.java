package com.telefonica.jee.dao;

import java.util.List;

import com.telefonica.jee.model.Despensa;


/**
 * DAO for employee operations
 * @author root
 * 
 */
public interface DespensaDAO {
	
	/**
	 * It returns a list of all products
	 * @return
	 */
	List<Despensa> get();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Despensa get(int id);
	
	/**
	 * It saves a Product
	 * @param product
	 * @return true if product is correctly saved or false if there is an error
	 */
	boolean save(Despensa despensa);
	
	/**
	 * 
	 * @param id
	 * @return 
	 */
	boolean delete(int id);
	
	boolean update(Despensa despensa);
}
