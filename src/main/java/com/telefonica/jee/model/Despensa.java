
package com.telefonica.jee.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "despensa")
@NamedQuery(name = "Despensa.findAll", query = "SELECT d FROM Despensa d")

public class Despensa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne(mappedBy = "despensa", cascade = { CascadeType.ALL })
	private Usuarios usuarios;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_stock")
	private Stock stock;

	public Despensa(int id, Usuarios usuarios, Stock stock) {
		this.id = id;
		this.usuarios = usuarios;
		this.stock = stock;
	}

	public Despensa() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Despensa [id=" + id + "]";
	}

}
