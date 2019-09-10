package fr.polymontp.mas.entreprise;

import java.util.ArrayList;
import java.util.List;

public class DirecteurSingleton extends Employe{
	private float sommeFixe = 2000 ;
	static DirecteurSingleton leDirecteur = null;
	private List<Commercial> commerciaux = new ArrayList<>();
	
	
	public static DirecteurSingleton CreeDirecteur(String nom, Entreprise e) {
		if(leDirecteur == null) {
			leDirecteur = new DirecteurSingleton(nom, employes);
		}
		return leDirecteur;
	}

	private DirecteurSingleton(String nom, Entreprise e) {
		super(nom, e);		
		for(Employe employe : employes) {
			if(employe.getClass().equals(Commercial.class)) {
				commerciaux.add((Commercial)employe);
			}
		}
	}
	
	public float getSalaire() {
		float sommeCA = 0;
		for (Commercial commercial : commerciaux) {
			sommeCA = sommeCA + (float) (commercial.getCA()*0.04);
		}
		return sommeCA + sommeFixe;
	}
}
