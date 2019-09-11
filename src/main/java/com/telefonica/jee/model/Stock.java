package com.telefonica.jee.model;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name = "producto")
@NamedQuery(name = "Stock.findAll", query = "SELECT d FROM Producto d")

public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	

	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name="minimo")
	private int minimo;

	@OneToOne(mappedBy = "stock",cascade = { CascadeType.ALL })
	private Despensa despensa;
}