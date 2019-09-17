package fr.polymontp.mas.entreprise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestEntreprise {
	public static void main(String[] args) {
		Entreprise entreprise = new Entreprise("Mas®",5);
		ArrayList<Employe> employes = entreprise.getEmp();
		
		entreprise.ajouterEmp( new EmployeHoraire("Gérard", entreprise));
		((EmployeHoraire)employes.get(0)).setInfosSalaire(35, 10, 50);
		entreprise.ajouterEmp( new EmployeHoraire("Pascal",35,5,30, entreprise));
		entreprise.ajouterEmp( new EmployeHoraire("Abdel", 35, 45, 50, entreprise));
		entreprise.ajouterEmp( new Commercial("Jean-marie", 4500, 10000, entreprise));
		entreprise.ajouterEmp( new Commercial("Rhodia", 6500, 15000, entreprise));
		entreprise.ajouterEmp( new Commercial("Thierry", 2500, 7000, entreprise));
		entreprise.ajouterEmp( new Directeur("Rachid", entreprise));
	
		Entreprise entreprise2 = new Entreprise("Mas®", 5);
		ArrayList<Employe> employes2 = entreprise.getEmp();
		entreprise2.ajouterEmp( new EmployeHoraire("Abdel2", 35, 45, 50, entreprise2));
		entreprise2.ajouterEmp( new Commercial("Thierry2", 2500, 7000, entreprise2));
		entreprise2.ajouterEmp( new Directeur("Rachid2", entreprise2));
		
	    joinEntreprise(entreprise, entreprise2).compareName();
		
	}
	
	public static Entreprise joinEntreprise(Entreprise e1, Entreprise e2) {
		Entreprise joinEntreprise = new Entreprise("Union", 10);
		for (Employe e : e1.getEmp()) {
			joinEntreprise.ajouterEmp(e);
		}
		for (Employe e : e2.getEmp()) {
			joinEntreprise.ajouterEmp(e);
		}
		return joinEntreprise;
	}
}
