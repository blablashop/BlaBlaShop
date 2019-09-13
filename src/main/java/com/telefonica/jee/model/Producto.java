package com.telefonica.jee.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "producto")
@NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")

public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "precio")
	private BigDecimal precio;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_categorias")
	private Categorias categorias;

	@OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
	List<Stock> stock = new ArrayList<>();

	public Producto(int id, String name, BigDecimal precio, Categorias categorias) {
		this.id = id;
		this.name = name;
		this.precio = precio;
		this.categorias = categorias;
	}

	public Producto() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", name=" + name + ", precio=" + precio + "]";
	}

}
