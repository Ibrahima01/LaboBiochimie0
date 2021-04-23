package com.example.LaboBiochimie.Entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.NonNull;

@Entity
@Table(name="Absence")
public class Absence implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NonNull
	private String motif;
	@NonNull
	@JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date_absence;
	/*
	@Lob
	private byte[] justificatif;
	 */
	private boolean statut;
	@ManyToOne
    @JoinColumn(name="personnel_id")
    private Personnel AbsencePersonnel;
	
	@ManyToOne
    @JoinColumn(name="admin_id")
    private Personnel AbsenceAdmin;
	
	public long getId() {
		return id;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public LocalDate getDate_absence() {
		return date_absence;
	}
	public void setDate_absence(LocalDate date_absence) {
		this.date_absence = date_absence;
	}
	/*
	public byte[] getJustificatif() {
		return justificatif;
	}
	public void setJustificatif(byte[] justificatif) {
		this.justificatif = justificatif;
	}
	*/
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Absence(@NonNull String motif, @NonNull LocalDate date_absence, /*byte[] justificatif,*/ boolean statut) {
		super();
		this.motif = motif;
		this.date_absence = date_absence;
		//this.justificatif = justificatif;
		this.statut = statut;
	}
	
}
