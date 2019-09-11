package com.telefonica.jee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.telefonica.jee.model.Stock;
import com.telefonica.jee.util.JPAUtil;

public class StockDAOImpl implements StockDAO {

	EntityManager manager = null;

	@Override
	public List<Stock> get() {

		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<Stock> namedQuery = manager.createNamedQuery("Stock.findAll", Stock.class);
			List<Stock> results = namedQuery.getResultList();
			manager.close();
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Stock>();
	}

	@Override
	public Stock get(int id) {
		Stock stock = null;
		try {
			manager = JPAUtil.getEntityManager();
			stock = manager.find(Stock.class, id);
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stock;
	}

	@Override
	public boolean save(Stock stock) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.persist(stock);
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
			Stock stock = manager.find(Stock.class, id);
			if (stock != null) {
				manager.remove(stock);
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
	public boolean update(Stock stock) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.merge(stock);
			manager.getTransaction().commit();
			manager.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
