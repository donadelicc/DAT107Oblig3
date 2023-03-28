package oving_jpa;

import java.time.LocalDate;
import java.util.Scanner;

import jakarta.persistence.*;

public class Main {

	public static void main(String[] args) {
		AnsattDAO ansattDAO = new AnsattDAO();
		AvdelingDAO avdelingDAO = new AvdelingDAO();

		int valg = -1;
		Scanner intscanner = new Scanner(System.in);
		Scanner stringscanner = new Scanner(System.in);

		do {
			System.out.println("Hva ønsker du og gjøre?");
			System.out.println("0) logg ut " + "\n1) søke etter ansatt(ID)" + "\n2) søke etter ansatt(Brukernavn)"
					+ "\n3) liste alle ansatte" + "\n4) Oppdatere lønn eller stilling "
					+ "\n5) legge inn en ny ansatt" + "\n6) bytte sjef" + "\n7) Endre avdelingsnavn"
					);
			valg = intscanner.nextInt();

			if (valg == 1) {

				System.err.println("\nID:");
				int id = intscanner.nextInt();
				System.out.println(ansattDAO.hentAnsatt(id).toString());
				System.out.println();
			} else if (valg == 2) {

				System.out.println("\nSkriv inn brukernavn: ");
				String brukernavn = stringscanner.nextLine();
				System.out.println(ansattDAO.hentAnsattBrukernavn(brukernavn));
			} else if (valg == 3) {

				System.out.println("\nAlle ansatte:");
				System.out.println(ansattDAO.finnAlleAnsatte());
			} else if (valg == 4) {

				System.out.println("\nHvilken ansatt ønsker du og endre data på?(ID)");
				int soektID = intscanner.nextInt();
				System.out.println("Vil du oppdater lønn eller stilling? 1 / 2");
				int nyttvalg = intscanner.nextInt();

				if (nyttvalg == 1) {
					System.out.println("Hvilken lønn skal den ansatte ha?");
					int lonn = intscanner.nextInt();
					ansattDAO.oppdaterLonn(soektID, lonn);
					System.out.println(ansattDAO.hentAnsatt(soektID));
				} else {
					System.out.println("Hvilken stilling skal personen ha?");
					String stilling = stringscanner.nextLine();
					ansattDAO.oppdaterStilling(soektID, stilling);
					System.out.println(ansattDAO.hentAnsatt(soektID));
				}
			} else if (valg == 5) {
				System.out.println("Hva er navnet til den nye ansatte?");
				String navn = stringscanner.nextLine();
				System.out.println("Hva er etternavnet til den nye ansatte?");
				String etternavn = stringscanner.nextLine();
				System.out.println("Hva er brukernavnet til den nye ansatte?");
				String brukernavn = stringscanner.nextLine();
				System.out.println("Hva er månedslønnen til den nye ansatte?");
				int mndInntekt = intscanner.nextInt();
				System.out.println("Hvilken stilling har den nye ansatte?");
				String stilling = stringscanner.nextLine();
				LocalDate dato = LocalDate.now();
				Ansatt ny = new Ansatt(stilling, mndInntekt, navn, etternavn, brukernavn, dato);
				ansattDAO.lagreNyAnsatt(ny);
			} else if (valg == 6) {
				System.out.println("Hvilken avdelingen jobber du i?");
				int sjefId = intscanner.nextInt();
				System.out.println("Hva er sjefen din sin id?");
				String avdeling = stringscanner.nextLine();
				avdelingDAO.oppdaterSjef(sjefId, avdeling);
				System.out.println("Gratulerer, du har nå byttet sjef");
				
			}else if (valg == 7) {
				System.out.println("Hvilken avdelingen jobber du i?");
				int avdID = intscanner.nextInt();
				System.out.println("Hva skal det nye navnet være?");
				String nyttNavn = stringscanner.nextLine();
				avdelingDAO.oppdaterAvdelingsnavn(avdID, nyttNavn);
				System.out.println("Avdelingen sitt nye navn er: '" + nyttNavn + "'");
			}

		} while (valg != 0);

	}

}
