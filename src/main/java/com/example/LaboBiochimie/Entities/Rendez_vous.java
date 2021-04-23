package com.example.LaboBiochimie.Entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.NonNull;

@Entity
@Table(name = "RDV")
public class Rendez_vous implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_RDV;
	@NonNull
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
	private LocalDateTime date_heure_RDV;
	@NonNull
	private int numero_box;
	
	@ManyToOne
    @JoinColumn(name="patient_id", referencedColumnName="id")
    private Patient RDVPatient;
	
	@ManyToOne
    @JoinColumn(name="personnel_id", referencedColumnName="id")
    private Personnel RDVPersonnel;
	
	@ManyToOne
    @JoinColumn(name="Admin_id", referencedColumnName="id")
    private Admin RDVAdmin;
	
	public int getId_RDV() {
		return id_RDV;
	}
	public LocalDateTime getDate_heure_RDV() {
		return date_heure_RDV;
	}
	public void setDate_heure_RDV(LocalDateTime date_heure_RDV) {
		this.date_heure_RDV = date_heure_RDV;
	}
	public int getNumero_box() {
		return numero_box;
	}
	public void setNumero_box(int numero_box) {
		this.numero_box = numero_box;
	}
	public Patient getRDVPatient(){return this.RDVPatient;}
	public void setRDVPatient(Patient patient){this.RDVPatient=patient;}
	public Personnel getRDVPersonnel(){return this.RDVPersonnel;}
	public void setRDVPersonnel(Personnel personnel){this.RDVPersonnel=personnel;}
	public Admin getRDVAdmin(){return this.RDVAdmin;}
	public void setRDVAdmin(Admin admin){this.RDVAdmin=admin;}

	public Rendez_vous(){
		super();
	}
	
	public Rendez_vous(@NonNull LocalDateTime date_heure_RDV, @NonNull int numero_box) {
		super();
		this.date_heure_RDV = date_heure_RDV;
		this.numero_box = numero_box;
	}

}
