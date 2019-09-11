package com.telefonica.jee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.telefonica.jee.model.Despensa;
import com.telefonica.jee.util.JPAUtil;


public class DespensaDAOImpl implements DespensaDAO {
	
	EntityManager manager = null;
	
	@Override
	public List<Despensa> get() {
				
		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<Despensa> namedQuery = manager.createNamedQuery("Despensa.findAll", Despensa.class);
			List<Despensa> results = namedQuery.getResultList();
			manager.close();
			return results;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Despensa>();
	}

	@Override
	public Despensa get(int id) {
		Despensa despensa = null;
		try {
			manager = JPAUtil.getEntityManager();
			despensa = manager.find(Despensa.class, id);
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return despensa;
	}

	@Override
	public boolean save(Despensa despensa) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.persist(despensa); 
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
			Despensa despensa= manager.find(Despensa.class, id);
			if (despensa != null) {
				manager.remove(despensa);
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
	public boolean update(Despensa despensa) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.merge(despensa); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	
}
