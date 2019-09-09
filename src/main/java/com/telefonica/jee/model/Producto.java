package com.telefonica.jee.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "direction")
@NamedQuery(name = "direction.findAll", query = "SELECT d FROM Direction d")

public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "street")
	private String street;

	@Column(name = "postalCode")
	private int postalCode;

	@Column(name = "city")
	private String city;

	@Column(name = "country")
	private String country;


	

	protected Producto(){
		super();
//		int id, 
//		this.id = id;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
		}

	public int getIddirection() {
		return id;
	}

	public void setIddirection(int iddirection) {
		this.id = iddirection;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", street=" + street + ", postalCode=" + postalCode + ", city=" + city
				+ ", country=" + country + "]";
	}

	//A ver si esta vaina funcionaaaaaaaa
	//putabasur

}
