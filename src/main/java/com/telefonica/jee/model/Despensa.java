
package com.telefonica.jee.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "despensa")
@NamedQuery(name = "despensa.findAll", query = "SELECT d FROM Despensa d")

public class Despensa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@OneToOne(mappedBy = "despensa", cascade = { CascadeType.ALL })
	private Usuarios usuarios;


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
