package com.telefonica.jee.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
@NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c")

public class Categorias implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int idcategorias;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "categorias", cascade = CascadeType.ALL)
	List<Producto> producto = new ArrayList <> ();

	public Categorias(int idcategorias, String name, List<Producto> producto) {
		this.idcategorias = idcategorias;
		this.name = name;
		this.producto = producto;
	}

	public Categorias() {
		
	}

	public int getIdcategorias() {
		return idcategorias;
	}

	public void setIdcategorias(int idcategorias) {
		this.idcategorias = idcategorias;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Categorias [idcategorias=" + idcategorias + ", name=" + name + ", producto=" + producto + "]";
	}

	
}
