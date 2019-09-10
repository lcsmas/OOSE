package fr.polymontp.mas.entreprise;

public class Entreprise {
	private double primeHebdo = Math.random() * 1000;
	private Directeur Dir;
	private int nbComMax;
	private int nbCom = 0;
	public Employe _emp[] = new Employe[300];
	
	Entreprise(int nbComMax) {
		this.nbComMax = nbComMax;
	}
	
	public int findFirstEmptyIndex() {
		for (int i = 0; i < _emp.length; i++) {
			if(_emp[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	public void ajouterEmp(Employe e) {
		if( _emp[_emp.length-1] == null) {
			if(e.getClass().equals(Commercial.class)) {
				if(this.nbCom < this.nbComMax) {
					_emp[findFirstEmptyIndex()] = e;
					nbCom = nbCom + 1;
				} else {
					System.out.println("IMPOSSIBLE trop de commerciaux");
				}
			} else if(e.getClass().equals(Directeur.class) && Dir == null) {
				Dir = (Directeur) e;
				_emp[findFirstEmptyIndex()] = e;
			} else {
				_emp[findFirstEmptyIndex()] = e;
			}			
		} else {
			System.out.println("IMPOSSIBLE trop d'employés");
		}
	}
	
	public static void main(String[] args) {


		Entreprise entreprise = new Entreprise(7);
		Employe[] employes = entreprise._emp;
		entreprise.ajouterEmp( new EmployeHoraire("Gérard", entreprise));
		((EmployeHoraire)employes[0]).setInfosSalaire(35, 10, 50);
		entreprise.ajouterEmp( new EmployeHoraire("Pascal",35,5,30, entreprise));
		entreprise.ajouterEmp( new EmployeHoraire("Abdel", 35, 45, 50, entreprise));
		entreprise.ajouterEmp( new Commercial("Jean-marie", 4500, 10000, entreprise));
		entreprise.ajouterEmp( new Commercial("Rhodia", 6500, 15000, entreprise));
		entreprise.ajouterEmp( new Commercial("Thierry", 2500, 7000, entreprise));
		entreprise.ajouterEmp( new Directeur("Rachid", entreprise));
		
		for (Employe employe : employes) {
			employe.setPrimeHebdo(entreprise.primeHebdo);
			System.out.println(employe.toString());
		}
	}
}
