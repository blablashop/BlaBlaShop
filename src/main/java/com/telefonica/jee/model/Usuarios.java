package com.telefonica.jee.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")

public class Usuarios implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "user")
	private String user;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_despensa")
	private Despensa despensa;

	public Usuarios(int id, String name, String user, String password, String email, Despensa despensa) {
		this.id = id;
		this.name = name;
		this.user = user;
		this.password = password;
		this.email = email;
		this.despensa = despensa;
	}

	public Usuarios() {

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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", name=" + name + ", user=" + user + ", password=" + password + ", email="
				+ email + "]";
	}

}
