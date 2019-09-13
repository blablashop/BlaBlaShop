package com.telefonica.jee.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "stock")
@NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")

public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "minimo")
	private int minimo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_producto")
	private Producto producto;

	@OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
	List<Despensa> despensa = new ArrayList<>();

	public Stock(int id, int cantidad, int minimo, List<Despensa> despensa) {
		this.id = id;
		this.cantidad = cantidad;
		this.minimo = minimo;
		this.despensa = despensa;
	}

	public Stock() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public List<Despensa> getDespensa() {
		return despensa;
	}

	public void setDespensa(List<Despensa> despensa) {
		this.despensa = despensa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", cantidad=" + cantidad + ", minimo=" + minimo + ", despensa=" + despensa + "]";
	}

}