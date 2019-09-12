package fr.polymontp.mas.entreprise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestEntreprise {
	public static void main(String[] args) {
		Entreprise entreprise = new Entreprise(5);
		Employe[] employes = entreprise._emp;
		try {
			entreprise.ajouterEmp( new EmployeHoraire("Gérard", entreprise));
			((EmployeHoraire)employes[0]).setInfosSalaire(35, 10, 50);
			entreprise.ajouterEmp( new EmployeHoraire("Pascal",35,5,30, entreprise));
			entreprise.ajouterEmp( new EmployeHoraire("Abdel", 35, 45, 50, entreprise));
			entreprise.ajouterEmp( new Commercial("Jean-marie", 4500, 10000, entreprise));
			entreprise.ajouterEmp( new Commercial("Rhodia", 6500, 15000, entreprise));
			entreprise.ajouterEmp( new Commercial("Thierry", 2500, 7000, entreprise));
			entreprise.ajouterEmp( new Directeur("Rachid", entreprise));
		}catch(EntrepriseSatureDeCommerciauxException e){
			e.printError();
		}
		try {
			FileWriter f = new FileWriter("enregistrement");
			((Commercial) employes[3]).enregistreToi(f);
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		try {
			FileReader fr = new FileReader("enregistrement");
			Commercial.lire(fr);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	
		for (Employe employe : employes) {
			if (employe == null) break;
			employe.setPrimeHebdo(entreprise.getPrimeHebdo());
			System.out.println(employe.toString());
		}
	}
}
