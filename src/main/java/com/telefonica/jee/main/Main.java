package com.telefonica.jee.main;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.telefonica.jee.model.Producto;
import com.telefonica.jee.model.Despensa;
import com.telefonica.jee.model.Categorias;
import com.telefonica.jee.model.Stock;
import com.telefonica.jee.model.Unidades;
import com.telefonica.jee.model.Usuarios;



public class Main {
	
	static EntityManagerFactory emf;
	static EntityManager manager;

	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("BlaBlaShop");
		
		
	}

}
