package com.telefonica.jee.dao;

import java.util.List;

import com.telefonica.jee.model.Stock;

/**
 * DAO for employee operations
 * 
 * @author root
 * 
 */
public interface StockDAO {

	/**
	 * It returns a list of all products
	 * 
	 * @return
	 */
	List<Stock> get();

	/**
	 * 
	 * @param id
	 * @return
	 */
	Stock get(int id);

	/**
	 * It saves a Product
	 * 
	 * @param product
	 * @return true if product is correctly saved or false if there is an error
	 */
	boolean save(Stock stock);

	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(int id);

	boolean update(Stock stock);
}
