package fr.polymontp.mas.entreprise;

public abstract class Employe {
	private String nom;
	private double primeHebdo;
	protected Entreprise entreprise;
	
	public Employe(String nom, Entreprise entreprise) {
		this.nom = nom;
		this.entreprise = entreprise;
	}

	public abstract float getSalaire();

	public String getNom() {
		return nom;
	}
	
	public void setPrimeHebdo(double primeHebdo) {
		this.primeHebdo = primeHebdo;
	}
	
	public String toString() {
		return getNom() + " gagne " + String.valueOf(this.getSalaire() + primeHebdo) + "€";
	}
	
	public String toStringName() {
		return getNom();
	}
}
