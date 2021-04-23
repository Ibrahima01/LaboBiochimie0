package com.example.LaboBiochimie.Entities;

import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Patient")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NonNull
	private String nom_Patient;
	@NonNull
    private String prenom_Patient;
	private String commentaires;
	private String tel;
	//@Lob
	//private byte[] photoPatient;
	@OneToOne(mappedBy = "patient",cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private AppUser appUser;

	@OneToMany (mappedBy = "RDVPatient", cascade = CascadeType.ALL)
	private Set<Rendez_vous> Rendez_vous_patient=new HashSet<>();

	public Long getId() {
		return id;
	}
	public String getNom_Patient() {
		return nom_Patient;
	}
	public void setNom_Patient(String nom_Patient) {
		this.nom_Patient = nom_Patient;
	}
	public String getPrenom_Patient() {
		return prenom_Patient;
	}
	public void setPrenom_Patient(String prenom_Patient) {
		this.prenom_Patient = prenom_Patient;
	}
	/*public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
	public String getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Set<Rendez_vous> getRendez_vous_patient() {
		return Rendez_vous_patient;
	}
	public void setRendez_vous_patient(Set<Rendez_vous> rendez_vous_patient) {
		Rendez_vous_patient = rendez_vous_patient;
	}
	public Patient(){super();}
/*
	public Patient(@NonNull String nom_Patient, @NonNull String prenom_Patient, @NonNull User user, String commentaires, String tel, Set<Rendez_vous> rendez_vous_patient) {
		this.nom_Patient = nom_Patient;
		this.prenom_Patient = prenom_Patient;
		this.user = user;
		this.commentaires = commentaires;
		this.tel = tel;
		Rendez_vous_patient = rendez_vous_patient;
	}
	/*
	public void prendreRDV(){

	}
	*/
}
