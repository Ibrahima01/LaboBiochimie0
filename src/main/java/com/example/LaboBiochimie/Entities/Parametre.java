package com.example.LaboBiochimie.Entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Parametre")
public class Parametre implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private static int nombre_chaises;
	private static int nombre_box;
	private static int duree_prelevement;
	
	@OneToMany (mappedBy ="parametre",cascade = CascadeType.ALL)
	private Set<Personnel> Parametre_personnel=new HashSet<>();
	
	@OneToMany (mappedBy ="parametre",cascade = CascadeType.ALL)
	private Set<Admin> Parametre_admin=new HashSet<>();
	
	public int getNombre_chaises() {
		return nombre_chaises;
	}
	
	public void setNombre_chaises(int nombre_chaises) {
		this.nombre_chaises = nombre_chaises;
	}
	public int getNombre_box() {
		return nombre_box;
	}
	public void setNombre_box(int nombre_box) {
		this.nombre_box = nombre_box;
	}
	public int getDuree_prelevement() {
		return duree_prelevement;
	}
	public void setDuree_prelevement(int duree_prelevement) {
		this.duree_prelevement = duree_prelevement;
	}

	public Parametre(int nombre_chaises, int nombre_box, int duree_prelevement) {
		super();
		this.nombre_chaises = nombre_chaises;
		this.nombre_box = nombre_box;
		this.duree_prelevement = duree_prelevement;
	}
	
}
