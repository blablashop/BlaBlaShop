package com.telefonica.jee.dao;

import java.util.List;

import com.telefonica.jee.model.Usuarios;

/**
 * DAO for employee operations
 * 
 * @author root
 * 
 */
public interface UsuariosDAO {

	/**
	 * It returns a list of all products
	 * 
	 * @return
	 */
	List<Usuarios> get();

	/**
	 * 
	 * @param id
	 * @return
	 */
	Usuarios get(int id);

	/**
	 * It saves a Product
	 * 
	 * @param product
	 * @return true if product is correctly saved or false if there is an error
	 */
	boolean save(Usuarios usuarios);

	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(int id);

	boolean update(Usuarios usuarios);
}
