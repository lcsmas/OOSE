package fr.polymontp.mas.entreprise;

public class Entreprise {
	private double primeHebdo = Math.random() * 1000;
	public double getPrimeHebdo() {
		return primeHebdo;
	}

	private Directeur Dir;
	private int nbComMax;
	public int getNbComMax() {
		return nbComMax;
	}

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
	
	public void ajouterEmp(Employe e) throws EntrepriseSatureDeCommerciauxException {
		if(_emp[_emp.length -1 ] == null) {
			if(e.getClass().equals(Commercial.class)) {
				if(nbCom < nbComMax) {
					_emp[findFirstEmptyIndex()] = e;
					 nbCom = nbCom +1;
				}else {
					throw new EntrepriseSatureDeCommerciauxException(this);
				}
			} else if(e.getClass().equals(Directeur.class) && Dir == null) {
				Dir = (Directeur) e;
				_emp[findFirstEmptyIndex()] = e;
			} else {
				_emp[findFirstEmptyIndex()] = e;
			}			
		}else {
			System.err.println("Entreprise pleine");
		}
	}
	
}
