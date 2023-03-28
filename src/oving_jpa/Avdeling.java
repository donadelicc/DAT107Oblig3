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
public class Avdeling {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdeling_Id;
	private String navn;
	
	@ManyToOne
	@JoinColumn(name="sjef_ID")
	private int sjef_Id;
	
	
	public Avdeling() {

	}

	public Avdeling(String navn, int id) {

		this.navn = navn;
		this.sjef_Id = id;

	}

	@Override
	public String toString() {
		return "\nAvdeling Id:		 " + avdeling_Id + "\nAvdelingsnavn:		 " +
				navn + "\nSjefs Id:		 "+ sjef_Id;
	}

	public int getAvdeling_Id() {
		return avdeling_Id;
	}

	public void setAvdeling_Id(int avdeling_Id) {
		this.avdeling_Id = avdeling_Id;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getSjef_Id() {
		return sjef_Id;
	}

	public void setSjef_Id(int sjef_Id) {
		this.sjef_Id = sjef_Id;
	}

}
