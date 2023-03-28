package oving_jpa;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oving1")
public class Ansatt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Ansatt_ID;
	private String stilling;
	private int maanedslonn;
	private String fornavn;
	private String etternavn;
	private String brukernavn;
	private LocalDate ansettelsesdato;
	private int avdeling_Id;

	public Ansatt() {

	}

	public Ansatt(String stilling, int maanedslonn, String fornavn, String etternavn, String brukernavn,
			LocalDate ansettelsesdato, int avdeling_Id) {

		this.stilling = stilling;
		this.maanedslonn = maanedslonn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.brukernavn = brukernavn;
		this.ansettelsesdato = ansettelsesdato;
		this.avdeling_Id = avdeling_Id;
		
	}

	@Override
	public String toString() {
		return "\nAnsatt ID:       " + Ansatt_ID + "\nstilling:        " + stilling + "\nmaanedslonn:     "
				+ maanedslonn + "\nfornavn:         " + fornavn + "\netternavn:       " + etternavn
				+ "\nbrukernavn:      " + brukernavn + "\nansettelsesdato: " + ansettelsesdato
				+ "\nAvdeling ID:		" + avdeling_Id;
	}

	public int getAnsatt_ID() {
		return Ansatt_ID;
	}

	public void setAnsatt_ID(int ansatt_ID) {
		Ansatt_ID = ansatt_ID;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getMaanedslonn() {
		return maanedslonn;
	}

	public void setMaanedslonn(int maanedslonn) {
		this.maanedslonn = maanedslonn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}
	

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public LocalDate getAnsettelsesdato() {
		return ansettelsesdato;
	}

	public void setAnsettelsesdato(LocalDate ansettelsesdato) {
		this.ansettelsesdato = ansettelsesdato;
	}

	public int getAvdeling_Id() {
		return avdeling_Id;
	}

	public void setAvdeling_Id(int avdeling_Id) {
		this.avdeling_Id = avdeling_Id;
	}
	
	

}
