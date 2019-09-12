package com.telefonica.jee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.telefonica.jee.model.Usuarios;
import com.telefonica.jee.util.JPAUtil;

public class UsuariosDAOImpl implements UsuariosDAO {

	EntityManager manager = null;

	@Override
	public List<Usuarios> get() {

		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<Usuarios> namedQuery = manager.createNamedQuery("Usuarios.findAll", Usuarios.class);
			List<Usuarios> results = namedQuery.getResultList();
			manager.close();
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Usuarios>();
	}

	@Override
	public Usuarios get(int id) {
		Usuarios usuarios = null;
		try {
			manager = JPAUtil.getEntityManager();
			usuarios = manager.find(Usuarios.class, id);
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	@Override
	public boolean save(Usuarios usuarios) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.persist(usuarios);
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
			Usuarios usuarios = manager.find(Usuarios.class, id);
			if (usuarios != null) {
				manager.remove(usuarios);
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
	public boolean update(Usuarios usuarios) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.merge(usuarios);
			manager.getTransaction().commit();
			manager.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
