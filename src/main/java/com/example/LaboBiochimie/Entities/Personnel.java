package com.example.LaboBiochimie.Entities;

import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Personnel")
public class Personnel  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NonNull
	private String nom_personnel;
	@NonNull
	private String prenom_personnel;
	@NonNull
	private String email;
	@NonNull
	private String hopitalOrigine;
	private String gouvernorat;
	/*
	@Lob
	private byte[] photoPersonnel;
	*/
	@OneToMany (mappedBy ="RDVPersonnel",cascade = CascadeType.ALL)
	private Set<Rendez_vous> Rendez_vous_personnel=new HashSet<>();
	
	@ManyToOne
	private Parametre parametre;
	
	@OneToMany (mappedBy ="AbsencePersonnel", cascade = CascadeType.ALL)
	private Set<Absence> Absence_personnel=new HashSet<>();
	
	public long getId() {
		return id;
	}

	public String getNom_personnel() {
		return nom_personnel;
	}

	public void setNom_personnel(String nom_personnel) {
		this.nom_personnel = nom_personnel;
	}

	public String getPrenom_personnel() {
		return prenom_personnel;
	}

	public void setPrenom_personnel(String prenom_personnel) {
		this.prenom_personnel = prenom_personnel;
	}

	public String getPoste_occupee() {
		return hopitalOrigine;
	}

	public void setPoste_occupee(String hopitalOrigine) {
		this.hopitalOrigine = hopitalOrigine;
	}

	public String getGouvernorat() {
		return gouvernorat;
	}

	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}

	/*
        public byte[] getPhotoPersonnel() {
            return photoPersonnel;
        }

        public void setPhotoPersonnel(byte[] photoPersonnel) {
            this.photoPersonnel = photoPersonnel;
        }
        */

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Personnel(){
		super();
	}

	public Personnel(@NonNull String nom_personnel, @NonNull String prenom_personnel, @NonNull String email, @NonNull String hopitalOrigine, String gouvernorat, Set<Rendez_vous> rendez_vous_personnel, Parametre parametre, Set<Absence> absence_personnel) {
		this.nom_personnel = nom_personnel;
		this.prenom_personnel = prenom_personnel;
		this.email = email;
		this.hopitalOrigine = hopitalOrigine;
		this.gouvernorat = gouvernorat;
		Rendez_vous_personnel = rendez_vous_personnel;
		this.parametre = parametre;
		Absence_personnel = absence_personnel;
	}
}
