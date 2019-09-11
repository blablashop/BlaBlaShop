package com.telefonica.jee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.telefonica.jee.model.Unidades;
import com.telefonica.jee.util.JPAUtil;

public class UnidadesDAOImpl implements UnidadesDAO {

	EntityManager manager = null;

	@Override
	public List<Unidades> get() {

		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<Unidades> namedQuery = manager.createNamedQuery("Unidades.findAll", Unidades.class);
			List<Unidades> results = namedQuery.getResultList();
			manager.close();
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Unidades>();
	}

	@Override
	public Unidades get(int id) {
		Unidades unidades = null;
		try {
			manager = JPAUtil.getEntityManager();
			unidades = manager.find(Unidades.class, id);
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return unidades;
	}

	@Override
	public boolean save(Unidades unidades) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.persist(unidades);
			manager.getTransaction().commit();
			manager.close();
			flag = true;
		} catch (Exception ex) {
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
			Unidades unidades = manager.find(Unidades.class, id);
			if (unidades != null) {
				manager.remove(unidades);
				manager.getTransaction().commit();
				flag = true;
			}
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Unidades unidades) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.merge(unidades);
			manager.getTransaction().commit();
			manager.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
