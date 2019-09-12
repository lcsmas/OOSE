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
	
		//entreprise.toString();
		entreprise.iterEntreprise();
	}
}
