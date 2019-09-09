package com.telefonica.jee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.telefonica.jee.model.Categorias;
import com.telefonica.jee.util.JPAUtil;


public class CategoriasDAOImpl implements CategoriasDAO {
	
	EntityManager manager = null;
	
	@Override
	public List<Categorias> get() {
				
		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<Categorias> namedQuery = manager.createNamedQuery("Stock.findAll", Categorias.class);
			List<Categorias> results = namedQuery.getResultList();
			manager.close();
			return results;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Categorias>();
	}

	@Override
	public Categorias get(int id) {
		Categorias categorias = null;
		try {
			manager = JPAUtil.getEntityManager();
			categorias = manager.find(Categorias.class, id);
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return categorias;
	}

	@Override
	public boolean save(Categorias categorias) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.persist(categorias); 
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
			Categorias categorias = manager.find(Categorias.class, id);
			if (categorias != null) {
				manager.remove(categorias);
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
	public boolean update(Categorias categorias) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.merge(categorias); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}


}
