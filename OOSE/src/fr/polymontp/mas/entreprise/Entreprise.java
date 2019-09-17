package fr.polymontp.mas.entreprise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Entreprise{
	private double primeHebdo = Math.random() * 1000;
	private String nom;
	private ArrayList<Employe> emp = new ArrayList<Employe>();
	private Directeur Dir;
	private int nbComMax;
	private int nbCom = 0;
	
	Entreprise(String nom, int nbComMax) {
		this.nom = nom; 
		this.nbComMax = nbComMax;
	}
	
	public double getPrimeHebdo() {
		return primeHebdo;
	}
	
	public int getNbComMax() {
		return nbComMax;
	}

	public void ajouterEmp(Employe e) {
		this.emp.add(e);
	}
	
	public void suprimerEmp(int index) {
		this.emp.remove(index);
	}

	public ArrayList<Employe> getEmp() {
		return emp;
	}

	public void setEmp(ArrayList<Employe> emp) {
		this.emp = emp;
	}
	
	public String toString() {
		System.out.println("Entreprise : "+this.nom);
		for (Employe employe : this.emp) {
			employe.setPrimeHebdo(this.getPrimeHebdo());
			System.out.println(employe.toStringName());
		}
		return nom;
	}
	
	public Iterator<Employe> iterEntreprise() {
		return emp.iterator();
	}
	
	public void compareSalaire() {
		Collections.sort(this.emp , new SalaryComparator( SalaryComparator.DESCENDING_ORDER));
		Iterator<Employe> it = this.iterEntreprise();
		while(it.hasNext()){
			Employe i = it.next();
			System.out.println( i.getNom()+" "+ i.getSalaire());
		}
	}
	
	public void compareName() {
		Collections.sort(this.emp);
		Iterator<Employe> it = this.iterEntreprise();
		while(it.hasNext()){
			Employe i = it.next();
			System.out.println( i.getNom()+" "+ i.getSalaire());
		}
	}
	
	
}
