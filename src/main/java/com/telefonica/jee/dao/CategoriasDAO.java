package com.telefonica.jee.dao;

import java.util.List;

import com.telefonica.jee.model.Categorias;

/**
 * DAO
 * 
 * @author root
 * 
 */
public interface CategoriasDAO {

	/**
	 * It returns
	 * 
	 * @return
	 */
	List<Categorias> get();

	/**
	 * 
	 * @param
	 * @return
	 */
	Categorias get(int id);

	/**
	 * It saves
	 * 
	 * @param
	 * @return true
	 */
	boolean save(Categorias categorias);

	/**
	 * It deletes
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(int id);

	boolean update(Categorias categorias);
}
