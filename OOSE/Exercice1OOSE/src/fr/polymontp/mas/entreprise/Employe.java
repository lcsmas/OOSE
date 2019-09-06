package fr.polymontp.mas.entreprise;
public abstract class Employe {
	private String nom;
	private double primeHebdo;
	
	public Employe(String nom) {
		this.nom = nom;
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
}
