package com.telefonica.jee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import com.telefonica.jee.model.Producto;
import com.telefonica.jee.util.JPAUtil;


public class CategoriasDAOImpl implements ProductoDAO {
	
	EntityManager manager = null;
	
	@Override
	public List<Producto> get() {
				
		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<Producto> namedQuery = manager.createNamedQuery("Product.findAll", Producto.class);
			List<Producto> results = namedQuery.getResultList();
			manager.close();
			return results;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Producto>();
	}

	@Override
	public Producto get(int id) {
		Producto product = null;
		try {
			manager = JPAUtil.getEntityManager();
			product = manager.find(Producto.class, id);
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public boolean save(Producto producto) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.persist(producto); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(int id) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			Producto product = manager.find(Producto.class, id);
			if (product != null) {
				manager.remove(product);
				manager.getTransaction().commit(); 
				flag = true;
			}
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Producto producto) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.merge(producto); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}


}
