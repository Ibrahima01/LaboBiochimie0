package com.example.LaboBiochimie.Entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.NonNull;

@Entity
@Table(name = "Admin")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NonNull
	private String nom;
	@NonNull
	private String prenom;
	@NonNull
	private String login;
	@NonNull
	private String password;
	/*
	@Lob
	private byte[] photoAdmin;
	*/
	@OneToMany (mappedBy ="RDVAdmin", cascade = CascadeType.ALL)
	private Set<Rendez_vous> Rendez_vous_admin=new HashSet<>();
	
	@OneToMany (mappedBy ="AbsenceAdmin", cascade = CascadeType.ALL)
	private Set<Absence> Absence_admin=new HashSet<>();
	
	@ManyToOne
	private Parametre parametre;
	
	public long getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*
	public byte[] getPhotoAdmin() {
		return photoAdmin;
	}
	public void setPhotoAdmin(byte[] photoAdmin) {
		this.photoAdmin = photoAdmin;
	}
	 */
	public Admin(@NonNull String nom, @NonNull String prenom, @NonNull String login, @NonNull String password
			/*byte[] photoAdmin*/) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		//this.photoAdmin = photoAdmin;
	}
	
	
}
