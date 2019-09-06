

import java.util.ArrayList;
import java.util.List;

import fr.polymontp.mas.entreprise.Commercial;
import fr.polymontp.mas.entreprise.Employe;
import fr.polymontp.mas.entreprise.EmployeHoraire;
import fr.polymontp.mas.entreprise.Directeur;

public class Paie {
	public static void main(String[] args) {
		List<Employe> employes = new ArrayList<>();
		double primeHebdo = Math.random() * 1000;
		
		employes.add( new EmployeHoraire("Gérard"));
		((EmployeHoraire)employes.get(0)).setInfosSalaire(35, 10, 50);
		employes.add( new EmployeHoraire("Pascal",35,5,30));
		employes.add( new EmployeHoraire("Abdel", 35, 45, 50));
		employes.add( new Commercial("Jean-marie", 4500, 10000));
		employes.add( new Commercial("Rhodia", 6500, 15000));
		employes.add( new Commercial("Thierry", 2500, 7000));
		employes.add( Directeur.CreeDirecteur("Rachid", employes));
		
		for (Employe employe : employes) {
			employe.setPrimeHebdo(primeHebdo);
			System.out.println(employe.toString());
		}
	}

}
